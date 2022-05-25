package com.lesserror.initializer.controllers;

import com.lesserror.initializer.models.AppRequest;
import com.lesserror.initializer.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
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

  /**
   * Gets the app template.
   *
   * @param appRequest the app request
   */
  @GetMapping("/api")
  public void getAppTemplate(@RequestBody AppRequest appRequest) {
      s3Service.downloadFile();
  }
}
