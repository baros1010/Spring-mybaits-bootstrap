package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;

import exception.UsersException;
@Service
public class LoginServiceImp implements LoginService{
	@Autowired
	public LoginDao userService;
	
	public int isLogin(String username,String password){
		int count=userService.isLogin(username, password);
		System.out.println(count);
		
		if(count==0){
			
				throw new UsersException(001);
			
		}
		return count;
		
	}
	
}
