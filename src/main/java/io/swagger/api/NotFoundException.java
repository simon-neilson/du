package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2015-11-16T10:43:27.803Z")
public class NotFoundException extends ApiException {
	private int code;
	public NotFoundException (int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
