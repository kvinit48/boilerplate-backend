package com.lesserror.initializer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontedSelector {

    @Autowired
    S3Service s3Service;

    public void select(String frontend){
        String frontendFilePath = "frontend/" + frontend;
        String destPath = "src/main/resources/project-target/" + frontend + ".zip";
        s3Service.downloadFile(frontendFilePath,destPath);
    }
}
