package tokenManage;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bean.TokenBean;
import redis.clients.jedis.Jedis;

@Component
public class RedisTokenManager implements TokenManager {
	@Autowired
	JedisUitl util;
	Jedis jedis = null;

	@PostConstruct
	public void setConnection() {
		jedis = util.getConnection();
	}

	@Override
	public TokenBean createToken(String userId) {
		String token = UUID.randomUUID().toString().replace("-", "");
		TokenBean bean = new TokenBean(userId, token);

		jedis.setex(userId, 600, token);
		return bean;
	}

	@Override
	public boolean checkToken(TokenBean bean) {
		if (bean == null) {
            return false;
        }
		String token = jedis.get(bean.getUserId());
		if (token == null || !token.equals(bean.getToken())) {
			return false;
		}
		jedis.setex(bean.getUserId(), 600, bean.getToken());
		return true;
	}

	@Override
	public TokenBean getToken(String authentication) {
		if(authentication==null||authentication.length()==0){
			return null;	
		}
		String[] param = authentication.split("_");
		if (param.length != 2) {
			return null;
		}
		return new TokenBean(param[0], param[1]);
	}

	@Override
	public void deleteToken(String userId) {

		jedis.del(userId);

	}

}
