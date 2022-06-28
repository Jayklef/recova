package jerry_codes.example.recova.controller;

import jerry_codes.example.recova.entity.Bank;
import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("banks")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
    @PostMapping("banks")
    public  ResponseEntity<Bank> saveBank(@RequestBody Bank bank){
        Bank newBank = bankService.saveBank(bank);
        return new ResponseEntity<>(newBank, HttpStatus.CREATED);
    }
    @GetMapping("/banklist")
    public ResponseEntity<List<Bank>> getAllBanks(){
        List<Bank> banks = bankService.findAll();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }


}
