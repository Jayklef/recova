package jerry_codes.example.recova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bankName;
    private String location;

    @OneToMany(mappedBy = "bank")
    private Set<Client> clients;
}
