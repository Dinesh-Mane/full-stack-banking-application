package com.dineshmane.bankapp.mapper;

import com.dineshmane.bankapp.dto.response.AccountResponse;
import com.dineshmane.bankapp.entity.Account;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-19T11:53:44+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponse toResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse.AccountResponseBuilder accountResponse = AccountResponse.builder();

        accountResponse.id( account.getId() );
        accountResponse.accountNumber( account.getAccountNumber() );
        accountResponse.accountType( account.getAccountType() );
        accountResponse.balance( account.getBalance() );
        accountResponse.status( account.getStatus() );
        accountResponse.createdAt( account.getCreatedAt() );

        return accountResponse.build();
    }
}
