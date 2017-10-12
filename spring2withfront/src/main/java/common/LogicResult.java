package common;

import org.springframework.http.HttpStatus;

public class LogicResult {
	

	private final HttpStatus statusCode;



	public LogicResult(HttpStatus statusCode) {
		this.statusCode = statusCode;
	};
}
