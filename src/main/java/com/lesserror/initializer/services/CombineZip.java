package com.lesserror.initializer.services;

import com.lesserror.initializer.utils.ZipUtil;
import org.springframework.stereotype.Service;

@Service
public class CombineZip {

    public void combine(String frontend,String backend){
        String frontendZipPath = "src/main/resources/project-target/" + frontend +".zip";
        String backendZipPath = "src/main/resources/project-target/" + backend +".zip";
        String unzipDir = "src/main/resources/project";
        ZipUtil.unzip(frontendZipPath,unzipDir);
        ZipUtil.unzip(backendZipPath,unzipDir);

        String projectZipPath = "src/main/resources/project";
        String destFile = "src/main/resources/project.zip";
        ZipUtil.zipDirectory(projectZipPath,destFile);
    }
}
