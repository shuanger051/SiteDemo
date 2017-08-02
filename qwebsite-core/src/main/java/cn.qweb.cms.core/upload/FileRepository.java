package cn.qweb.cms.core.upload;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 本地文件存储
 */
@Component
@ConfigurationProperties(prefix = "uploadresource")
public class FileRepository {

	private String basePath;

	private Logger log = LoggerFactory.getLogger(FileRepository.class);

	public String storeByExt(String path, String ext, MultipartFile file)
			throws IOException {
		String filename = UploadUtils.generateFilename(path, ext);
		File dest = new File(filename);
		dest = UploadUtils.getUniqueFile(dest);
		store(file, dest);
		return filename;
	}

	public String storeByFilePath(String path, String filename, MultipartFile file)
			throws IOException {
		if(filename!=null&&(filename.contains("/")||filename.contains("\\")||filename.indexOf("\0")!=-1)){
			return "";
		}
		File dest = new File(path+filename);
		store(file, dest);
		return path+filename;
	}

//	public String storeByExt(String path, String ext, File file)
//			throws IOException {
//		String filename = UploadUtils.generateFilename(path, ext);
//		File dest = new File(getRealPath(filename));
//		dest = UploadUtils.getUniqueFile(dest);
//		store(file, dest);
//		return filename;
//	}
//
//	public String storeByFilename(String filename, File file)
//			throws IOException {
//		File dest = new File(getRealPath(filename));
//		store(file, dest);
//		return filename;
//	}

	private void store(MultipartFile file, File dest) throws IOException {
		try {
			UploadUtils.checkDirAndCreate(dest.getParentFile());
			file.transferTo(dest);
		} catch (IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}

	private void store(File file, File dest) throws IOException {
		try {
			UploadUtils.checkDirAndCreate(dest.getParentFile());
			FileUtils.copyFile(file, dest);
		} catch (IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}

}
