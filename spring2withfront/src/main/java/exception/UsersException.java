package exception;

import java.util.Map;

import util.ErrorCodeList;

public class UsersException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int errorStatus = 500;
	Map<String, String> map;
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Map<String, String> getResObj(){

		map.put("errorMessage", errorMessage);
		map.put("errorCode", errorCode);
		return map;
		
	};

	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}

	private String errorCode;

	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public UsersException(ErrorCodeList errorCode) {
		super(errorCode.getErrorMessage());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorMessage();
	}

}
