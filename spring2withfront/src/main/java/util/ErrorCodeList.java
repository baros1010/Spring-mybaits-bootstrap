package util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ErrorCodeList {
	BSC_0001("BSC_0001","用户密码不正确"),
	BSC_0002("BSC_0002","用户无权限");
	private String errorCode;
	private String errorMessage;
	private static final Map<String,ErrorCodeList> mapping;
	static {
		mapping = Arrays.asList(ErrorCodeList.values()).stream()
				.collect(Collectors.toMap(ErrorCodeList::getErrorCode, v -> v));
	}
	private ErrorCodeList(String errorCode,String errorMessage){
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public static ErrorCodeList asErrorcode(String errorCode){
		return mapping.get(errorCode);
	}

}
