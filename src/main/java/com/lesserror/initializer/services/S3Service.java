package com.lesserror.initializer.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * The Class S3Service.
 */
@Configuration
public class S3Service {

  /** The Constant logger. */
  private static final Logger logger = LogManager.getLogger(S3Service.class);

  /** The credentials. */
  private AWSCredentials credentials =
      new BasicAWSCredentials("AKIAUZFHH2RN47CTPMKM", "Uy4Tif3fm43IB7U2SgMokt6n5v9qs6dESVonNXdI");

  /** The s 3 client. */
  private AmazonS3 s3client = AmazonS3ClientBuilder.standard()
      .withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.AP_SOUTH_1)
      .build();

  /** The bucket name. */
  private String bucketName = "selecttech";

  /**
   * Download file.
   *
   */
  public void downloadFile(String filename,String destDir) {

    S3Object s3object = s3client.getObject(bucketName, filename);
    S3ObjectInputStream inputStream = s3object.getObjectContent();
    try {
      FileUtils.copyInputStreamToFile(inputStream, new File(destDir));
    } catch (IOException e) {
      logger.info("Exception Occured in creating file", e);
    }

  }
}
