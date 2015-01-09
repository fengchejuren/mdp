package myfirst.base;

import javax.servlet.http.HttpServletRequest;

import myfirst.exception.BusinessException;
import myfirst.exception.IllegalOperationException;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	/**
	 * 日志记录
	 */
	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * 异常处理
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView exception(HttpServletRequest request, Exception e) {
		if (e instanceof BusinessException) { // 业务异常
			return new ModelAndView("error/business").addObject("e", e);
		} else if (e instanceof IllegalOperationException) { // 非法操作异常
			// 这种异常设置为严重的异常，记录下Ip地址，并且立即报告给管理员
			String ip = request.getRemoteAddr();
			String requestInfo = "非法请求：\n ip:" + request.getRemoteAddr()
					+ "  host:" + request.getRemoteHost() 
					+ " port:" + request.getRemotePort() 
					+ " user:" + request.getRemoteUser();
			logger.error(requestInfo);
			return new ModelAndView("error/business").addObject("e", e);
		} else { // 其它原因引起的异常
			return new ModelAndView("error/common");
		}
	}
}
