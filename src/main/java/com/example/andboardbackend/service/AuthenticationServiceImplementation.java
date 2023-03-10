package com.example.andboardbackend.service;

import com.example.andboardbackend.auth.AuthenticationRequest;
import com.example.andboardbackend.auth.AuthenticationResponse;
import com.example.andboardbackend.auth.RegisterRequest;
import com.example.andboardbackend.config.JwtService;
import com.example.andboardbackend.entity.User;
import com.example.andboardbackend.exception.ResourceNotFoundException;
import com.example.andboardbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    String email = request.getEmail();
    String password = passwordEncoder.encode(request.getPassword());
    User user = new User(email, password);

    userRepository.save(user);
    String jwtToken = jwtService.generateToken(user);
    return new AuthenticationResponse(jwtToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    String email = request.getEmail();
    String password = request.getPassword();
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

    Optional<User> result = userRepository.findUserByEmail(email);
    if (result.isPresent()) {
      User user = result.get();
      String jwtToken = jwtService.generateToken(user);
      return new AuthenticationResponse(jwtToken);
    }
    throw new ResourceNotFoundException("Resource not found");
  }

}
