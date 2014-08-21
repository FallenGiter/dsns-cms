package org.dsns.common.service.interfaces;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadSV {
	public String UPLOAD_ROOT_DIR = "UPLOAD_ROOT_DIR";
	public String FILE_UPLOAD = "FILE_UPLOAD";
	
	public String proccessMultipartFile(MultipartFile mtf) throws Exception ;
	
	public String proccessFileItem(FileItem fileItem) throws Exception ;
}
