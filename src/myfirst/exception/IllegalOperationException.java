package myfirst.exception;

/**非法操作异常：用户非法操作抛出的异常，比如表单信息的非法输入，非法的请求等
 * @author Administrator
 *
 */
public class IllegalOperationException extends Exception {

	private static final long serialVersionUID = -5254585882392778664L;

	public IllegalOperationException(){
		
	}
	
	public IllegalOperationException(String msg){
		super(msg);
	}
	
	public IllegalOperationException(Throwable cause){
		super(cause);
	}
	
	public IllegalOperationException(String msg,Throwable cuase){
		super(msg, cuase);
	}
	
}
