package jerry_codes.example.recova.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class CollectDebt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amountOwed;

    @OneToOne
    private Client client;

    @OneToMany
    private Set<BankAccount> bankAccount;
}
