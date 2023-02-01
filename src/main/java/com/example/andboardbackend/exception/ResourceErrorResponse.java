package com.example.andboardbackend.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResourceErrorResponse {

  private int status;
  private String message;
  private long timestamp;

}
