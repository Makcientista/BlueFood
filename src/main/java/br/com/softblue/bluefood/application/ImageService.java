package br.com.softblue.bluefood.application;

import java.io.IOException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
 
	@Value("${bluefood.files.logotipo}")
	private String logotiposDir;
	
	public void uploadLogotipo(MultipartFile multipartFile, String fileName) {		
		try {
			IOUtils.copy(multipartFile.getInputStream(), fileName, logotiposDir);
		} catch (IOException e) {
		  throw new ApplicatonServiceException(e);
		}
	}
}
