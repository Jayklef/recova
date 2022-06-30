package jerry_codes.example.recova.repository;

import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
