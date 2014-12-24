/**  
 * @Title: FileUpLoadController.java 
 * @Package myfirst.web 
 * @Description: TODO 
 * @author Rock King 2014年12月24日 下午10:32:52
 * @version V1.0  
 */ 
package myfirst.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月24日 下午10:32:52 
 * @see ~!^ Keep bugs away and code with U!	 
 */
@Controller
@RequestMapping("/file")
public class FileUpLoadController {

	@RequestMapping(value="/index.html")
	public String filePage(){
		return "file/index";
	}
	
	@RequestMapping(value="/fileup.html")
	public ModelAndView fileup(@RequestParam(value="myfile",required=false) 
			MultipartFile file,HttpServletRequest request,ModelMap map){
		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		File targetFile = new File(path,fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
