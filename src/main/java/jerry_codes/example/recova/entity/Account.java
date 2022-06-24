package jerry_codes.example.recova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String bank;
    private Boolean isActive;
    private String accountType;
    private BigDecimal accountBalance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
