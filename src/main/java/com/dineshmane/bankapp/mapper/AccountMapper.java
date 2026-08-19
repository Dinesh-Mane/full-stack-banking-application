package com.dineshmane.bankapp.mapper;

import com.dineshmane.bankapp.dto.response.AccountResponse;
import com.dineshmane.bankapp.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponse toResponse(Account account);

}
