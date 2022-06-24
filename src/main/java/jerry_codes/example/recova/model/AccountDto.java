package jerry_codes.example.recova.model;

import jerry_codes.example.recova.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String accountNumber;
    private String bank;
    private Boolean isActive;
    private String accountType;
    private BigDecimal accountBalance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
