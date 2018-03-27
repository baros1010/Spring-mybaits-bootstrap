package tokenManage;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class JedisUitl {
	JedisPool jedi = null;
	private static String REDISDB_IP = "127.0.0.1";
	private static int REDISDB_PORT = 6379;

	public JedisUitl() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);
		jedi = new JedisPool(config, REDISDB_IP, REDISDB_PORT);
	}
	public Jedis getConnection(){
		Jedis jedis=jedi.getResource();
		return jedis;
	}

}
