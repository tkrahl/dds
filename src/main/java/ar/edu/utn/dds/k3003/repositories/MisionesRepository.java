package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Mision;
import java.util.Optional;

public interface MisionesRepository {
  Optional<Mision> findById(String id);

  Mision save(Mision mision);

  Mision deleteById(String id);
}
