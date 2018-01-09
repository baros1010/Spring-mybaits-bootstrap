package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import bean.UserBean;
import controller.LoginController;
import service.LoginService;

public class LoginControllerTest {
	@InjectMocks
	LoginController target;
	@Mock
	ResponseEntity res;
	@Mock
	LoginService log;

	@Before
	public void setUp() throws Exception {
		target = new LoginController();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test001() {
		UserBean userbean = new UserBean();
		userbean.setUsername("katoumegumi");
		userbean.setPassword("123");
		Mockito.when(log.isLogin(userbean.getUsername(), userbean.getPassword())).thenReturn(1);
		ResponseEntity test = (ResponseEntity) target.Login(userbean);

	}
}
