package com.apiRest.apiRest.models;

import java.io.Serializable;

public class JwtDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String jwtToken;

  public JwtDto(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  public String getJwtToken() {
    return this.jwtToken;
  }
}