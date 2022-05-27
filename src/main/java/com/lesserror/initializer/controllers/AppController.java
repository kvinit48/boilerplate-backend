package com.lesserror.initializer.controllers;

import com.lesserror.initializer.models.AppRequest;
import com.lesserror.initializer.services.CreateTemplate;
import com.lesserror.initializer.services.S3Service;
import com.lesserror.initializer.utils.DeleteDirectroyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Class AppController.
 */
@RestController
public class AppController {

  /** The s 3 service. */
  @Autowired
  S3Service s3Service;

  @Autowired
  CreateTemplate createTemplate;

  /*
  * Get app template with
  * frotend and backend
  * */
  @GetMapping("/api")
  public ResponseEntity<Resource> getAppTemplate(
          @RequestParam("frontend") String frontend,
          @RequestParam("backend") String backend){

    DeleteDirectroyUtil.deleteDirectory(new File("src/main/resources/project-target"));
    DeleteDirectroyUtil.deleteDirectory(new File("src/main/resources/project-target"));
    File f1 = new File("src/main/resources/project-target");
    File f2 = new File("src/main/resources/project");
    f1.mkdir();
    f2.mkdir();

    createTemplate.create(frontend,backend);

    Path path = Paths.get("src/main/resources/project.zip");
    Resource resource = null;
    resource = new FileSystemResource(path);
    return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.TRANSFER_ENCODING,"binary")
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() )
            .body(resource);
  }

  /**
   * Gets testing api.
   *
   * @param appRequest the app request
   */
  @GetMapping("/testApi")
  public void getTestTemplate() {
      s3Service.downloadFile("test.txt","test.txt");
  }

  @GetMapping("")
  public String getHello(){
    return "Hello, try /api with query parameter containing name of frontend and backend tech";
  }
}
