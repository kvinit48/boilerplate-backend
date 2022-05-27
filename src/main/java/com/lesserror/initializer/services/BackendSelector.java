package com.lesserror.initializer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackendSelector {

    @Autowired
    S3Service s3Service;

    public void select(String backend){
        String backendFilePath = "backend/" + backend + ".zip";
        String destPath = "src/main/resources/project-target/" + backend + ".zip";
        s3Service.downloadFile(backendFilePath,destPath);
    }
}
