package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Bank;

import java.util.List;
import java.util.Set;

public interface BankService {
    Bank saveBank(Bank bank);

    List<Bank> findAll();

    Bank findById(Long id);
}
