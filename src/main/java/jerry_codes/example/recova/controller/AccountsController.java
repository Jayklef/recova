package jerry_codes.example.recova.controller;

import jerry_codes.example.recova.entity.Account;
import jerry_codes.example.recova.model.AccountDto;
import jerry_codes.example.recova.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountsController {

    private AccountService accountService;

    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccount(){
        List<Account> accounts = accountService.findAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Account> saveAccount(@RequestBody AccountDto accountDto){
        Account account = accountService.saveAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

}
