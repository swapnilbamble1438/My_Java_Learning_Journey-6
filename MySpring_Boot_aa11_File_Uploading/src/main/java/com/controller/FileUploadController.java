package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	
	@Autowired
	private FileUploadHelper fileuploadhelper;
	
	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		
	
				
		/*
		  System.out.println("Original filename: " + file.getOriginalFilename());
		  System.out.println("filesize: " + file.getSize());
		  System.out.println("filetype: " + file.getContentType());
		  System.out.println("filename: " + file.getName());
		 */
		
		
		try {
		
		// validation
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
			
		if(!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content type are allowed");

		}
		
		// file upload code
	boolean f =	fileuploadhelper.uploadfile(file);
		if(f)
		{
			return ResponseEntity.ok("File is successfully uploaded");
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		// return ResponseEntity.ok("working");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again");
		
	}
}
