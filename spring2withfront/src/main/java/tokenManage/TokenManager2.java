package tokenManage;

import bean.UserBean;

public interface TokenManager2 {
	public String createToken(UserBean user);

	boolean checkToken(String token, String userId);
}
