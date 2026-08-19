package com.dineshmane.bankapp.mapper;

import com.dineshmane.bankapp.dto.response.UserResponse;
import com.dineshmane.bankapp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);

}
