package jerry_codes.example.recova.entity;

import jerry_codes.example.recova.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String address;
    private String NIN;
    private String BVN;

    @OneToMany(mappedBy = "client")
    private Set<Account> accounts;
}
