package com.lesserror.initializer.models;

/**
 * The Class AppRequest.
 */
public class AppRequest {
  
  /** The front end. */
  private String frontend;
  
  /** The back end. */
  private String backend;

  /**
   * Instantiates a new app request.
   */
  public AppRequest() {}

  /**
   * Instantiates a new app request.
   *
   * @param frontend the frontend
   * @param backend the backend
   */
  public AppRequest(String frontend, String backend) {
    this.frontend = frontend;
    this.backend = backend;
  }

  /**
   * Gets the frontend.
   *
   * @return the frontend
   */
  public String getFrontend() {
    return frontend;
  }

  /**
   * Sets the frontend.
   *
   * @param frontend the new frontend
   */
  public void setFrontend(String frontend) {
    this.frontend = frontend;
  }

  /**
   * Gets the backend.
   *
   * @return the backend
   */
  public String getBackend() {
    return backend;
  }

  /**
   * Sets the backend.
   *
   * @param backend the new backend
   */
  public void setBackend(String backend) {
    this.backend = backend;
  }
}
