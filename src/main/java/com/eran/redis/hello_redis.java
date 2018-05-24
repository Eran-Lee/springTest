package com.eran.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class hello_redis {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		System.out.println("服务正在运行：" + jedis.ping());
		
		jedis.set("ni", "jack");
		System.out.println("redis存储的字符串：" + jedis.get("ni"));
		
		jedis.lpush("second_list", "aa");
		jedis.lpush("second_list", "bb");
		jedis.lpush("second_list", "cc");
		List<String> lrange = jedis.lrange("second_list", 0, 5);
		System.out.println("list中的元素：" + lrange.toString());
	}

}
