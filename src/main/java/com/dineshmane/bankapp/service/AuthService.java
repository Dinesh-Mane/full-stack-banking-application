package com.dineshmane.bankapp.service;

import com.dineshmane.bankapp.dto.request.RegisterRequest;
import com.dineshmane.bankapp.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
}
