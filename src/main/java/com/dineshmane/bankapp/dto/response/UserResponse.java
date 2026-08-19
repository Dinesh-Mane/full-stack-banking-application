package com.dineshmane.bankapp.dto.response;

import com.dineshmane.bankapp.entity.KycStatus;
import com.dineshmane.bankapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private KycStatus kycStatus;
    private LocalDateTime createdAt;

}
