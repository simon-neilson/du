package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2015-11-16T10:43:27.803Z")
public class ApiException extends Exception{
	private int code;
	public ApiException (int code, String msg) {
		super(msg);
		this.code = code;
	}
}
