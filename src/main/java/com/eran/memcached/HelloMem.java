package com.eran.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;


public class HelloMem {

	public static void main(String[] args) {
		//memcached客户端很多，我选择推荐的xmemcached
		List<InetSocketAddress> addresses = AddrUtil.getAddresses("127.0.0.1:11211");
		XMemcachedClientBuilder bulider = new XMemcachedClientBuilder(addresses);
		MemcachedClient client;
		
		try {
			client = bulider.build();

			client.set("hello", 0, "xmemcached");
			
			String value = client.get("hello");
			System.out.println("hello" + value );
			
			client.delete("hello");
			String value1 = client.get("hello");
			System.out.println("hello" + value1);
			
			client.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
