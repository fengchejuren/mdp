package myfirst.exception;

/**业务异常：用户在正常的操作时产生的异常。比如用户想上传一个附件，但是他没有上传附件的权限
 * @author Administrator
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = -5254585882392778664L;

	public BusinessException(){
		
	}
	
	public BusinessException(String msg){
		super(msg);
	}
	
	public BusinessException(Throwable cause){
		super(cause);
	}
	
	public BusinessException(String msg,Throwable cuase){
		super(msg, cuase);
	}
	
}
