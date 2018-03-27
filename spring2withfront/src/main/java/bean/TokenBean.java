package bean;

/**
 * Token的Bean类，可以增加字段提高安全性，例如时间戳、url签名
 * 
 * @author firas
 *
 */
public class TokenBean {
	// 用户ID
	private String userId;
	// 随机Torken
	private String token;

	public TokenBean(String userId, String token) {
		this.userId = userId;
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
