package jerry_codes.example.recova.service;

import jerry_codes.example.recova.entity.Bank;
import jerry_codes.example.recova.repository.BankRepository;
import jerry_codes.example.recova.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService{

    private BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank saveBank(Bank bank) {

        Bank newBank = Bank.builder()
                .bankName(bank.getBankName())
                .location(bank.getLocation())
                .clients(bank.getClients())
                .build();
        return bankRepository.save(newBank);
    }

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Bank::getBankName))
                .collect(Collectors.toList());
    }
}
