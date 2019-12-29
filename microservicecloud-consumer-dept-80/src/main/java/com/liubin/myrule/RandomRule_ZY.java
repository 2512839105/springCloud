package com.liubin.myrule;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A loadbalacing strategy that randomly distributes traffic amongst existing
 * servers.
 * 
 * @author stonse
 * 
 */

public class RandomRule_ZY extends AbstractLoadBalancerRule {

    /**
     * Randomly choose from all living servers
     */
	private int total=0;  //总共被调用的次数，目前要求每台被调用5次
	private int currentIndex=0;  //当前提供服务的机器号
	 
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            //自定义负载均衡算法
            if(total<5){
            	total++;
            	 server = upList.get(currentIndex);            	
            }else{//当某个服务器被调用五次时，清空调用次数，并将服务器下标下移一个
            	total=0;
            	currentIndex++;
            	if(currentIndex>=upList.size()){  //当最后一个服务器被调用了五次之后，清空，重新来过
            		currentIndex=0;
            	}
            	
            }
            /*随机算法
             * int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}


	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}
	
 
}
 
