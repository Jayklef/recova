package jerry_codes.example.recova.repository;

import jerry_codes.example.recova.entity.CollectDebt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectDebtRepository extends JpaRepository<CollectDebt, Long> {
}
