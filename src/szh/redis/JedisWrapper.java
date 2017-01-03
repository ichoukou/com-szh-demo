package szh.redis;

import java.util.ArrayList;
import java.util.List;

import com.dajie.common.config.AppConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisWrapper {
    private static JedisPool pool = null;
    private static Logger logger = LoggerFactory.getLogger(JedisWrapper.class);

    private static JedisWrapper instance = new JedisWrapper();

    private JedisWrapper() {
        JedisPoolConfig config = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
//		config.setMaxActive(500);
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(5);
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
//		config.setMaxWait(1000 * 100);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(true);

        String redisip = "localhost";
        // "192.168.13.128";
        String redisport = "6379";

        logger.info("JedisWrapper::getPool-->reisip=" + redisip + " redisport="
                + redisport);

        pool = new JedisPool(config, redisip, Integer.valueOf(redisport));
    }

    public static JedisWrapper getInstance() {
        return instance;
    }

    JedisPool getPool() {
        return pool;
    }

    void returnResource(JedisPool pool, Jedis redis) {
        if (pool != null && redis != null) {
            pool.returnResource(redis);
        }
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        String value = null;

        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            if (pool != null) {
                jedis = pool.getResource();
                if (jedis != null) {
                    value = jedis.get(key);
                }
            }
        } catch (Exception e) {
            // 释放redis对象
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            // 返还到连接池
            returnResource(pool, jedis);
        }

        return value;
    }

    public String setString(String key, String value) {
        String code = "";
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            if (pool != null) {
                jedis = pool.getResource();
                if (jedis != null) {
                    code = jedis.set(key, value);
                }
            }
        } catch (Exception e) {
            // 释放redis对象
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            // 返还到连接池
            returnResource(pool, jedis);
        }
        return code;
    }

    public long rpush(String key, String value) {
        long code = 0;
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            if (pool != null) {
                jedis = pool.getResource();
                if (jedis != null) {
                    code = jedis.rpush(key, value);
                }
            }
        } catch (Exception e) {
            // 释放redis对象
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            // 返还到连接池
            returnResource(pool, jedis);
        }

        return code;
    }

    public String lpop(String key) {
        String result = null;
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            if (pool != null) {
                jedis = pool.getResource();
                if (jedis != null) {
                    result = jedis.lpop(key);
                }
            }
        } catch (Exception e) {
            // 释放redis对象
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            // 返还到连接池
            returnResource(pool, jedis);
        }
        return result;
    }

    public List<String> lpopTopN(String key, int n) {
        List<String> result = new ArrayList<String>();
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            if (pool != null) {
                jedis = pool.getResource();
                if (jedis != null) {
                    for (int i = n; i > 0; i--) {
                        String resultTmp = jedis.lpop(key);
                        if (resultTmp == null) {
                            break;
                        }
                        result.add(resultTmp);
                    }
                }
            }
        } catch (Exception e) {
            // 释放redis对象
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            // 返还到连接池
            returnResource(pool, jedis);
        }
        return result;
    }

    public long llen(String key) {
        long result = 0;
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            if (pool != null) {
                jedis = pool.getResource();
                if (jedis != null) {
                    result = jedis.llen(key);
                }
            }
        } catch (Exception e) {
            // 释放redis对象
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            // 返还到连接池
            returnResource(pool, jedis);
        }

        return result;

    }

    public static void main(String[] args) {
        JedisWrapper jedisWrapper = JedisWrapper.getInstance();
        System.out.println(jedisWrapper.rpush("lSONG", "Rzhihao"));
    }

}
