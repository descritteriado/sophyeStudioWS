package main.java.ec.com.ocampana.srv.pojo;

import main.java.ec.com.ocampana.srv.utils.ResponseEnum;

public class ServiceResponse {
	
	int code;
	String description;
	String token;
	
	public ServiceResponse() {
		super();
	}
	
	public ServiceResponse(int code, String description) {
		super();
		this.code = code;
		this.description = description;
		this.token = this.code+"";
	}
	
	public ServiceResponse(ResponseEnum responseEnum) {
		super();
		this.code = responseEnum.getResponseId();
		this.description = responseEnum.getResponseDescription();
		this.token = this.code+"";
	}
	
	public ServiceResponse setServiceResponse(ResponseEnum response)
	{
		this.code = response.getResponseId();
		this.description = response.getResponseDescription();
		this.token = this.code+"";
		
		return this;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
