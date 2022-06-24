package jerry_codes.example.recova.model;

import jerry_codes.example.recova.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String firstname;
    private String lastname;
    private String phonenumber;
    private String address;
    private String NIN;
    private String BVN;

    @OneToMany(mappedBy = "client")
    private Set<Account> accounts;
}
