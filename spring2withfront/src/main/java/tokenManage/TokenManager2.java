package tokenManage;

import bean.TokenBean;
import bean.UserBean;

public interface TokenManager2 {
	public TokenBean createToken(UserBean user);

	boolean checkToken( String userId);
}
