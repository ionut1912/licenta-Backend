package licenta.backend.repository;

import licenta.backend.model.Rezervation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervationRepository extends JpaRepository<Rezervation, Long> {

}
