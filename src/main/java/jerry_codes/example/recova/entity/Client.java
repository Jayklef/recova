package jerry_codes.example.recova.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String address;
    private String nin;
    private String bvn;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<BankAccount> accounts;

    @ManyToOne
    @JoinColumn(name = "debt_id")
    private Debt debt;

}
