package com.tydic.task;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.tydic.base.util.FileUtils;


public class FileDeleteService {
	private Logger logger=LoggerFactory.getLogger(FileDeleteService.class);
	public void execute(){
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();   
        ServletContext servletContext = webApplicationContext.getServletContext();
        File tempFileDirFile=new File(servletContext.getRealPath("/uploadtemp"));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String currDate=sdf.format(new Date());
        if(tempFileDirFile.exists()){
        	File[] files=tempFileDirFile.listFiles();
        	for(File file:files){
        		if(!file.getName().endsWith(currDate)){
        			try {
						FileUtils.deleteFile(file.getAbsolutePath());
					} catch (IOException e) {
						logger.error("定是任务删除webcontent目录临时文件失败", e);
						continue;
					}
        		}
        	}
        }
	}
}
