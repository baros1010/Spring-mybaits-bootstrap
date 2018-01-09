package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;

import exception.ExceptionBuilder;
import exception.UsersException;
import util.ErrorCodeList;

@Service
public class LoginServiceImp implements LoginService {
	@Autowired
	public LoginDao userService;

	public int isLogin(String username, String password) throws UsersException{
		int count = userService.isLogin(username, password);
		if (count == 0) {
			
			throw ExceptionBuilder.getUserException(ErrorCodeList.BSC_0001);

		}
		return count;

	}

}
