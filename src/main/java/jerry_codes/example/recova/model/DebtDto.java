package jerry_codes.example.recova.model;

import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.entity.DebtType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class DebtDto {

    private BigDecimal amount;
    private Date dueDate;
    private DebtType debtType;
    private Set<Client> clients;
}
