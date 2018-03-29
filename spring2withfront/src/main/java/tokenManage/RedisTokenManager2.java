package tokenManage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import JWT.JWT;
import bean.TokenBean;
import bean.UserBean;
import redis.clients.jedis.Jedis;
@Component
public class RedisTokenManager2 implements TokenManager2 {
	@Autowired
	JedisUitl util;
	Jedis jedis = null;

	@PostConstruct
	public void setConnection() {
		jedis = util.getConnection();
	}

	@Override
	public String createToken(UserBean user) {
		// TODO 自動生成されたメソッド・スタブ
		String token = JWT.sign(user, 60L * 1000L * 30L);
		jedis.setex(user.getUsername(), 600, token);
		return token;
	}

	@Override
	public boolean checkToken(String token, String userId) {
		UserBean user = JWT.unsign(token, UserBean.class);
		if (user == null || !userId.equals(user.getUsername())) {
			return false;
		}
		jedis.setex(user.getUsername(), 600, token);
		return true;

	}

}
