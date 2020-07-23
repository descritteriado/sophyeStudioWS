package main.java.ec.com.ocampana.srv.utils;

public enum ResponseEnum {
	
OK(0,"OK"),
ERROR(-1,"ERROR"),
AUTHORIZED(10,"AUTHORIZED"),
UNAUTHORIZED(20,"UNAUTHORIZED")

;
	
	private final int responseId;

	private final String responseDescription;

	public int getResponseId() {
		return responseId;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	private ResponseEnum(int responseId, String responseDescription) {
		this.responseId = responseId;
		this.responseDescription = responseDescription;
	}

	

}
