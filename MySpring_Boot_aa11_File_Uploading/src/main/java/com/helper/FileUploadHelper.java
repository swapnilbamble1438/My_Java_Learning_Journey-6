package com.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	

	
	// it is upload directory where file is to be uploaded
	public final String UPLOAD_DIR = "C:\\Users\\Swapnil\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\MySpring_Boot_aa11_File_Uploading\\src\\main\\resources\\static\\image";
	
	public boolean uploadfile(MultipartFile file)
	{
		boolean f = false;
		
		try {
	/*
		// file upload code	
		InputStream is = file.getInputStream();
		byte data[] = new byte[is.available()];
		is.read();
		
		// write 
		// FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\"+file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(UPLOAD_DIR +File.separator+file.getOriginalFilename());
			
		fos.write(data);
		fos.close();
		fos.flush();
		f = true;
	*/
		
		//
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR +File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f = true;
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return f;
	}

}
