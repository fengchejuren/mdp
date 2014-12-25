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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import myfirst.utils.FileUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
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
		return "file/file_index";
	}
	
	
	/**上传单个文件
	 * @param file
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/fileup.html")
	public ModelAndView fileup(@RequestParam(value="myfile",required=false) 
			MultipartFile file,HttpServletRequest request,ModelMap map){
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
	
	@RequestMapping(value="/file_list.html")
	public String file_list(){
		return "file/file_list";
	}
	/**上传一组文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/filelistup.html")
	public ModelAndView filesup(HttpServletRequest request) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String[] alaises = ServletRequestUtils.getStringParameters(request, "alais");
		String[] params = new String[]{"alais"};
		Map<String, Object[]> values = new HashMap<String, Object[]>();
		values.put("alais", alaises);
		List<Map<String, Object>> result = FileUtil.upload(request, params, values);
		map.put("result", result);
		return new ModelAndView("file/fileup",map);
	}
}
