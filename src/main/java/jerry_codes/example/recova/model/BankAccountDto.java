package jerry_codes.example.recova.model;

import jerry_codes.example.recova.entity.AccountStatus;
import jerry_codes.example.recova.entity.AccountType;
import jerry_codes.example.recova.entity.Client;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountDto {

    private String accountNumber;
    private BigDecimal availableBalance;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Client client;
}
