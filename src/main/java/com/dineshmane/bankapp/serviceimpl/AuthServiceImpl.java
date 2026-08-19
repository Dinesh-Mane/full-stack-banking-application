package com.dineshmane.bankapp.serviceimpl;

import com.dineshmane.bankapp.dto.request.RegisterRequest;
import com.dineshmane.bankapp.dto.response.AuthResponse;
import com.dineshmane.bankapp.entity.KycStatus;
import com.dineshmane.bankapp.entity.Role;
import com.dineshmane.bankapp.entity.User;
import com.dineshmane.bankapp.mapper.UserMapper;
import com.dineshmane.bankapp.repository.UserRepository;
import com.dineshmane.bankapp.security.JwtProperties;
import com.dineshmane.bankapp.security.JwtUtil;
import com.dineshmane.bankapp.security.UserPrincipal;
import com.dineshmane.bankapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final JwtProperties jwtProperties;
    private final UserMapper userMapper;

    @Override
    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword())) // NEVER store the raw password
                .role(Role.CUSTOMER)          // self-registration always creates a CUSTOMER;
                // ADMIN/TELLER accounts are provisioned separately (Phase 6), never via public signup
                .kycStatus(KycStatus.PENDING)
                .enabled(true)
                .build();

        User savedUser = userRepository.save(user);

        UserPrincipal principal = new UserPrincipal(savedUser);
        return buildAuthResponse(principal, savedUser);
    }

    private AuthResponse buildAuthResponse(UserPrincipal principal, User user) {
        String accessToken = jwtUtil.generateAccessToken(principal);
        String refreshToken = jwtUtil.generateRefreshToken(principal);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresInMs(jwtProperties.getAccessTokenExpiryMs())
                .user(userMapper.toResponse(user))
                .build();
    }
}
