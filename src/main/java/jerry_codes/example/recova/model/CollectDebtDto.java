package jerry_codes.example.recova.model;

import jerry_codes.example.recova.entity.BankAccount;
import jerry_codes.example.recova.entity.Client;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class CollectDebtDto {

    private Long id;
    private BigDecimal amountOwed;
    private Client client;
    private Set<BankAccount> bankAccount;
}
