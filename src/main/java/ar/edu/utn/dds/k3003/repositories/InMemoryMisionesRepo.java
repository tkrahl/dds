package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Mision;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import lombok.val;

public class InMemoryMisionesRepo implements MisionesRepository {
    
private List<Mision> misions;
  private AtomicLong idSecuencial = new AtomicLong(1);

  public InMemoryMisionesRepo() {
    this.misions = new ArrayList<>();
  }

  @Override
  public Optional<Mision> findById(String id) {
    return this.misions.stream().filter(i -> i.getId().equals(id)).findFirst();
  }

  @Override
  public Mision save(Mision mision) {
    Mision misionConID = mision;
    misionConID.setId(String.valueOf(idSecuencial.getAndIncrement()));

    this.misions.add(misionConID);
    return this.findById(misionConID.getId()).get();
  }

  @Override
  public Mision deleteById(String id) {
    val mision = this.findById(id);
    this.misions.remove(mision.get());
    return mision.get();
  }
    
}
