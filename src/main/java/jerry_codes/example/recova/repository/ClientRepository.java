package jerry_codes.example.recova.repository;

import jerry_codes.example.recova.entity.Account;
import jerry_codes.example.recova.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByBVN(String BVN);

    Set<Account> findAllAccountsByIdAndBVN(Long id, String BVN);
}
