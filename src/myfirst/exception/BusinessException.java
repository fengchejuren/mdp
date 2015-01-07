package myfirst.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -5254585882392778664L;

	public BusinessException(){
		
	}
	
	public BusinessException(String msg){
		super(msg);
	}
	
	
	
	
}
