package org.dsns.common.service.impls;

import java.io.File;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.dsns.common.entity.StaticData;
import org.dsns.common.service.interfaces.IUploadSV;
import org.dsns.common.utils.DateUtils;
import org.dsns.common.utils.FileUtils;
import org.dsns.common.utils.StaticDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadSVImpl implements IUploadSV {
	protected final static Logger LOG = Logger.getLogger(UploadSVImpl.class);
	
	@Autowired
	StaticDataUtils staticDataUtils;
	
	@Override
	public String proccessMultipartFile(MultipartFile mtf) throws Exception {
		String abUrlPath = null;
		if (mtf != null) {
			StaticData staticData = staticDataUtils.findStaticDataByDataCodeAndDataAlias(UPLOAD_ROOT_DIR, FILE_UPLOAD);
			if (staticData == null || !StringUtils.hasText(staticData.getDataValue())) {
				// TODO
			} else {
				abUrlPath = "/uploaded/" + DateUtils.getCurDay_yyyyMMdd() + "/" + UUID.randomUUID().toString() + FileUtils.DOT + FileUtils.getFileSuffix(mtf.getOriginalFilename());
				String abPath = FileUtils.fixFilePath(StringUtils.trimWhitespace(staticData.getDataValue() + abUrlPath));
						
				File file = new File(abPath);
				if (FileUtils.ensureFile(file)) {
					FileCopyUtils.copy(mtf.getBytes(), file);
				} else {
					// TODO
				}
			}
		} else {
			// TODO
		}
		
		return abUrlPath;
	}

	public String proccessFileItem(FileItem fileItem) throws Exception {
		String abUrlPath = null;
		if (fileItem != null && !fileItem.isFormField()) {
			StaticData staticData = staticDataUtils.findStaticDataByDataCodeAndDataAlias(UPLOAD_ROOT_DIR, FILE_UPLOAD);
			if (staticData == null || !StringUtils.hasText(staticData.getDataValue())) {
				// TODO
			} else {
				abUrlPath = "/upload/" + DateUtils.getCurDay_yyyyMMdd() + "/" + UUID.randomUUID().toString() + FileUtils.DOT + FileUtils.getFileSuffix(fileItem.getName());
				String abPath = FileUtils.fixFilePath(StringUtils.trimWhitespace(staticData.getDataValue() + abUrlPath));

				File file = new File(abPath);
				if (FileUtils.ensureFile(file)) {
					fileItem.write(file);
				} else {
					// TODO
				}
			}
		} else {
			// TODO
		}
		
		return abUrlPath;
	}
	
	
}
