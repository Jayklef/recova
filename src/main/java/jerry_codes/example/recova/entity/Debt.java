package jerry_codes.example.recova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private DebtType debtType;

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL)
    private Set<Client> clients;
}
