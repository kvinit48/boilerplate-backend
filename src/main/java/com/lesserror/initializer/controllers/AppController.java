package com.lesserror.initializer.controllers;

import com.lesserror.initializer.models.AppRequest;
import com.lesserror.initializer.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class AppController.
 */
@RestController
public class AppController {

  /** The s 3 service. */
  @Autowired
  S3Service s3Service;

  /*
  * Get app template with
  * frotend and backend
  * */
  @GetMapping("/api")
  public ResponseEntity<Resource> getAppTemplate(){

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
}
