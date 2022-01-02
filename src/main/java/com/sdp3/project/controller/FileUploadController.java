package com.sdp3.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	
	public static String upload(MultipartFile file) {
		if(file.isEmpty())
			return null;
		Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
		String fileName = null;
		try{
			Files.write(fileNameAndPath, file.getBytes());
			fileName = file.getOriginalFilename();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public static String storeFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
        	Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
            Files.copy(file.getInputStream(), fileNameAndPath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
			e.printStackTrace();
		}
        return fileName;
    }
}
