package repositories;

import models.Vino;
import models.VinoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VinoRepository extends JpaRepository<Vino, VinoId> {
    Vino update(VinoId vinoId, Vino entity);
}
