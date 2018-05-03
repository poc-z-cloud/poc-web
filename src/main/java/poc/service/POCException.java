package poc.service;

public class POCException extends Exception {
	public static final String UNKNOWN="9999";
	
	public static final String AUTHENTICATION_USER_NOT_FOUND="0001";
	public static final String AUTHENTICATION_WRONG_PASSWORD="0002";

	public static POCException create(String code)
	{
		return new POCException(code);
	}
	
	private POCException(String code)
	{
		this.code=code;
	}
	
	private POCException(String code, Throwable cause)
	{
		super(cause);
		this.code=code;
		
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
