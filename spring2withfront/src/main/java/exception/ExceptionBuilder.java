package exception;

import java.util.HashMap;
import java.util.Map;

import util.ErrorCodeList;

public class ExceptionBuilder {
	public static UsersException getUserException(ErrorCodeList errorCode){
		UsersException ue=new UsersException(errorCode);
		Map<String, String> resObj = new HashMap<String, String>();
		resObj.put("errorCode", errorCode.getErrorCode());
		resObj.put("errorMessage", errorCode.getErrorMessage());
		ue.setMap(resObj);
		return ue;
	}

}
