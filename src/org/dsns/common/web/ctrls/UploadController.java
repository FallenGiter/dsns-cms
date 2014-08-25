package org.dsns.common.web.ctrls;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.dsns.common.consts.ICommonConst;
import org.dsns.common.service.interfaces.IUploadSV;
import org.dsns.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController extends BaseController {
	protected final static Logger LOG = Logger.getLogger(UploadController.class);
	static final String RTN_PATHS = "rtnPaths";
	
	@Autowired
	protected IUploadSV uploadSv;
	
	
	@RequestMapping(value = "/uploadCKE", method = RequestMethod.POST)
	public void uploadCKE(MultipartHttpServletRequest req, HttpServletResponse resp)  {
		resp.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = null;
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			if (isMultipart) {
				Map<String, String> rtnPaths = proccessReq(req);
	            
                pw = resp.getWriter();
                pw.println("<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + req.getParameter("CKEditorFuncNum") + ", '" + rtnPaths.get("upload") + "', '');</script>");  
                pw.flush(); 
			} else {
				LOG.info("");
				
				pw = resp.getWriter();
                pw.println("<script type=\"text/javascript\">var ref = window.parent.CKEDITOR.tools.addFunction(function(){alert('')});window.parent.CKEDITOR.tools.callFunction(ref);</script>");  
                pw.flush(); 
			}
		} catch (Exception e) {
			LOG.error("", e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	@RequestMapping(value = "/uploadJson", method = RequestMethod.POST)
	public void uploadJson(MultipartHttpServletRequest req, HttpServletResponse resp)  {
		resp.setHeader("Cache-Control", "no-cache");
		resp.setContentType(MediaType.TEXT_HTML_VALUE);
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
			
			Map<String, String> rtnPaths = this.proccessReq(req);
			
			if (rtnPaths.size() > 0) {
				jsonObject.put(ICommonConst.FLAG, ICommonConst.NUM_ONE);
				jsonObject.put(RTN_PATHS, rtnPaths);
			} else {
				jsonObject.put(ICommonConst.FLAG, ICommonConst.NUM_ZERO);
				jsonObject.put(ICommonConst.MSG, "");
			}
		} catch (Exception e) {
			LOG.error("", e);
			
			jsonObject.put(ICommonConst.FLAG, ICommonConst.NUM_ZERO);
			jsonObject.put(ICommonConst.MSG, "");
		} finally {
			if (pw != null) {
				pw.println(JsonUtils.toJson(jsonObject));
				pw.flush();
				
				pw.close();
			}
		}
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> uploadAjax(MultipartHttpServletRequest req)  {
		HttpHeaders headers = new HttpHeaders(); 
        headers.setContentType(MediaType.TEXT_HTML); 
        headers.setCacheControl("no-cache"); 
		
        Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			Map<String, String> rtnPaths = proccessReq(req);
            
			if (rtnPaths.size() > 0) {
				dataMap.put(ICommonConst.FLAG, ICommonConst.NUM_ONE);
				dataMap.put(RTN_PATHS, rtnPaths);
			} else {
				dataMap.put(ICommonConst.FLAG, ICommonConst.NUM_ZERO);
				dataMap.put(ICommonConst.MSG, "");
			}
		} catch (Exception e) {
			dataMap.put(ICommonConst.FLAG, ICommonConst.NUM_ZERO);
			dataMap.put(ICommonConst.MSG, "");
		} finally {
			
		}
		
		return new ResponseEntity<Map<String, Object>>(dataMap, headers, HttpStatus.OK);
	}

	private Map<String, String> proccessReq(MultipartHttpServletRequest req) throws FileUploadException, Exception {
		Map<String, String> rtnPaths = new HashMap<String, String>();
		
		Iterator<String> it =  req.getFileNames();
        MultipartFile mtf = null;
        String fieldName, fileUrl;
        int i = 0;
        while(it.hasNext()){
            mtf = req.getFile(it.next()); 
            fieldName = mtf.getName();
            fileUrl = uploadSv.proccessMultipartFile(mtf);
            
            if (StringUtils.hasText(fileUrl)) {
            	rtnPaths.put(this.getKey(fieldName, i), fileUrl);
            }
	    	
	    	i++;
        }
        
        return rtnPaths;
	}
	
	private String getKey(String fieldName, int i) {
		if (StringUtils.hasText(fieldName)) {
			if (fieldName.contains("[")) {
				return fieldName.replace("[", "").replace("]", "") + "_" + i;
			} else {
				return fieldName;
			}
		}
		
		return fieldName;
	}
}
