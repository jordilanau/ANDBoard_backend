package com.example.andboardbackend.service;

import com.example.andboardbackend.auth.AuthenticationRequest;
import com.example.andboardbackend.auth.AuthenticationResponse;
import com.example.andboardbackend.auth.RegisterRequest;

public interface AuthenticationService {

  AuthenticationResponse register(RegisterRequest request);
  AuthenticationResponse authenticate(AuthenticationRequest request);

}
