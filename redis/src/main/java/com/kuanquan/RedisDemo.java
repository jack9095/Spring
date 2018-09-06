package com.kuanquan;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 先安装redis
 * mac下面：https://www.cnblogs.com/feijl/p/6879929.html
 *
 * 教程：http://www.runoob.com/redis/redis-java.html
 */
public class RedisDemo {

    // 连接到 redis 服务      连接成功 服务正在运行: PONG  表示成功
    public static void main(String[] str){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());



        // Redis Java String(字符串) 实例
        //设置 redis 字符串数据
        jedis.set("hef","字符串数据");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("hef"));



        // Redis Java List(列表) 实例
        // 存储数据到列表中
        jedis.lpush("aa-list","存储数据到列表中");
        jedis.lpush("aa-list","google");
        jedis.lpush("aa-list","baidu");
        jedis.lpush("aa-list","ali");
        jedis.lpush("aa-list","tenxun");
        // 获取存储的数据并输出
        List<String> lrangeLists = jedis.lrange("aa-list", 0, 4);
        for (int i = 0; i < lrangeLists.size(); i++) {
            System.out.println("列表项为：" + lrangeLists.get(i));
        }


        // Redis Java Keys 实例
        // 获取所有的key并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("key = " + next);
        }
    }

}
