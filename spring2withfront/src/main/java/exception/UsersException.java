package exception;

public class UsersException extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsersException(int code){
		switch(code){
		case 001:System.out.println("密码错误"); ;break;
		}
	};

}
