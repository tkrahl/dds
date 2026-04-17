package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Insignia;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import lombok.val;

public class InMemoryInsigniasRepo implements InsigniasRepository {
    
private List<Insignia> insignias;
  private AtomicLong idSecuencial = new AtomicLong(1);

  public InMemoryInsigniasRepo() {
    this.insignias = new ArrayList<>();
  }

  @Override
  public Optional<Insignia> findById(String id) {
    return this.insignias.stream().filter(i -> i.getId().equals(id)).findFirst();
  }

  @Override
  public Insignia save(Insignia insignia) {
    Insignia insigniaConID = insignia;
    insigniaConID.setId(String.valueOf(idSecuencial.getAndIncrement()));

    this.insignias.add(insigniaConID);
    return this.findById(insigniaConID.getId()).get();
  }

  @Override
  public Insignia deleteById(String id) {
    val insignia = this.findById(id);
    this.insignias.remove(insignia.get());
    return insignia.get();
  }
    
}
