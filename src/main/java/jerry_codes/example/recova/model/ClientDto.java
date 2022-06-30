package jerry_codes.example.recova.model;

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
    private String telephone;
    private String address;
    private String nin;
    private String bvn;

}
