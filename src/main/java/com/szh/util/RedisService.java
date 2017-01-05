/*
package main.java.com.szh.util;

import com.dajie.framework.cache.key.StringBasedKeyGenerator;
import com.dajie.framework.cache.redis.MapOperation;
import com.dajie.framework.cache.redis.SetOperation;
import com.dajie.framework.cache.redis.StringOperation;
import com.dajie.framework.cache.redis.impl.jedis.cluster.*;
import com.dajie.framework.cache.serializer.FastJsonStringSerializer;
import redis.clients.jedis.JedisCluster;

*/
/**
 * Created by zhihaosong on 16-11-25.
 *//*


public class RedisService {
    private static JedisClusterFactory jedisClusterFactory = new ConfigBaseJedisClusterFactory("PT_SEND_CENTER");
    private static JedisCluster jedisCluster = jedisClusterFactory.create();
    private static StringOperation<String, String> stringOperation =
            new JedisClusterBasedStringOperationImpl<String, String>("mailSender", jedisCluster, new StringBasedKeyGenerator(), new FastJsonStringSerializer<String>());
    private static MapOperation mapOperation = new JedisClusterBasedMapOperationImpl<String>(
            "mailSender", // 名称，为了管理方便，名称业务自己定
            jedisCluster, // jedisCluster实例
            new StringBasedKeyGenerator() // key生成器
    );
    private static SetOperation<String, String> setOperation = new JedisClusterBasedSetOperationImpl<String, String>(
            "mailSender", // 名称，为了管理方便，名称业务自己定
            jedisCluster,// jedisCluster实例
            new StringBasedKeyGenerator(), // key生成器
            new FastJsonStringSerializer<String>()// value的序列化方式
    );
    private static RedisService instance;

    private RedisService() {
    }

    public static RedisService getInstance() {
        if (instance == null) {
            synchronized (RedisService.class) {
                if (instance == null) {
                    instance = new RedisService();
                }
            }
        }
        return instance;
    }

    public String get(String key) {
        return stringOperation.get(key);
    }

    public void set(String key, String value, long expire) {
        stringOperation.set(key, value);
        if (expire != 0) {
            stringOperation.expire(key, expire);
        }
    }
}
*/
