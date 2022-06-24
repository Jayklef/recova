package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Account;
import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.AccountDto;
import jerry_codes.example.recova.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Account saveAccount(AccountDto accountDto) {

        Account account = Account.builder()
                .accountBalance(accountDto.getAccountBalance())
                .bank(accountDto.getBank())
                .accountNumber(accountDto.getAccountNumber())
                .accountType(accountDto.getAccountType())
                .isActive(accountDto.getIsActive())
                .build();

        return account;
    }

}
