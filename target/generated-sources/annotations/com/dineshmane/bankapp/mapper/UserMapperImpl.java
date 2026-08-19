package com.dineshmane.bankapp.mapper;

import com.dineshmane.bankapp.dto.response.UserResponse;
import com.dineshmane.bankapp.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-19T11:53:44+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.fullName( user.getFullName() );
        userResponse.email( user.getEmail() );
        userResponse.role( user.getRole() );
        userResponse.kycStatus( user.getKycStatus() );
        userResponse.createdAt( user.getCreatedAt() );

        return userResponse.build();
    }
}
