package com.springboot.app.assignment.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author puneet.negi
 *
 */
@Component
public class ResouceBean {

@Value("${file.url}")
private String fileUrl;

public String getFileUrl() {
	return fileUrl;
}

public void setFileUrl(String fileUrl) {
	this.fileUrl = fileUrl;
}	
	
}
