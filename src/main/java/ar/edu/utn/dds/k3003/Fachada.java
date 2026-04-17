package ar.edu.utn.dds.k3003;

import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.*;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.*;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonaciones;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaIncentivos;
import ar.edu.utn.dds.k3003.exceptions.DonadorNoEncontradoException;
import ar.edu.utn.dds.k3003.exceptions.DonadorYaExistenteException;
import ar.edu.utn.dds.k3003.exceptions.InsigniaNoEncontradaException;
import ar.edu.utn.dds.k3003.exceptions.MisionNoEncontradaException;
import ar.edu.utn.dds.k3003.repositories.DonadoresRepository;
import ar.edu.utn.dds.k3003.repositories.DonadoresYEntidadesDataMapper;
import ar.edu.utn.dds.k3003.repositories.InMemoryDonadoresRepo;
import ar.edu.utn.dds.k3003.repositories.InMemoryInsigniasRepo;
import ar.edu.utn.dds.k3003.repositories.InMemoryMisionesRepo;
import ar.edu.utn.dds.k3003.repositories.IncentivosDataMapper;
import ar.edu.utn.dds.k3003.repositories.InsigniasRepository;
import ar.edu.utn.dds.k3003.repositories.MisionesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.val;

public class Fachada implements FachadaIncentivos {

  private DonadoresRepository donadoresRepository;
  private InsigniasRepository insigniasRepository;
  private MisionesRepository misionesRepository;

  private DonadoresYEntidadesDataMapper donadoresYEntidadesDataMapper =
      new DonadoresYEntidadesDataMapper();
  private IncentivosDataMapper incentivosDataMapper = new IncentivosDataMapper();

  FachadaDonadoresYEntidades fachadaDonadoresYEntidades;

  public Fachada() {

    this.donadoresRepository = new InMemoryDonadoresRepo();
    this.insigniasRepository = new InMemoryInsigniasRepo();
    this.misionesRepository = new InMemoryMisionesRepo();
  }

  @Override
  public InsigniaDTO agregarInsignia(InsigniaDTO insignia) {

    if (this.insigniasRepository.findById(insignia.id()).isPresent()) {
      throw new DonadorYaExistenteException("Ya existe una insignia con ese ID");
    }

    val insigniaModel = incentivosDataMapper.toInsignia(insignia);
    val insigniaGuardada = this.insigniasRepository.save(insigniaModel);

    return incentivosDataMapper.toInsigniaDTO(insigniaGuardada);
  }

  @Override
  public MisionDTO agregarMision(MisionDTO mision) {

    if (this.misionesRepository.findById(mision.id()).isPresent()) {
      throw new DonadorYaExistenteException("Ya existe una mision con ese ID");
    }

    val misionModel = incentivosDataMapper.toMision(mision);
    val misionGuardada = this.misionesRepository.save(misionModel);

    return incentivosDataMapper.toMisionDTO(misionGuardada);
  }

  @Override
  public List<InsigniaDTO> getInsigniasDeDonador(String donadorID) throws NoSuchElementException {

    DonadorDTO donadorDTO = fachadaDonadoresYEntidades.buscarDonadorPorID(donadorID);

    if (donadorDTO==null) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }

    val donador = donadoresYEntidadesDataMapper.toDonador(donadorDTO);

    // Agregar exception lista nula

    List<InsigniaDTO> insigniasDTO = new ArrayList<>();
    for (String insigniaID : donador.getInsigniasID()) {
      val insignia = this.insigniasRepository.findById(insigniaID);

      val insigniaDTO = incentivosDataMapper.toInsigniaDTO(insignia.get());
      insigniasDTO.add(insigniaDTO);
    }

    return insigniasDTO;
  }

  @Override
  public MisionDTO getMisionEnCursoDeDonador(String donadorID) throws NoSuchElementException {

    DonadorDTO donadorDTO = fachadaDonadoresYEntidades.buscarDonadorPorID(donadorID);
    if (donadorDTO==null) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }
    val donador = donadoresYEntidadesDataMapper.toDonador(donadorDTO);

    String misionEnCursoID = donador.getMisionEnCursoID();
    if (misionEnCursoID == null) {
      throw new MisionNoEncontradaException("No hay mision en curso");
    }

    val misionEnCurso = this.misionesRepository.findById(misionEnCursoID);
    if (misionEnCurso.isEmpty()) {
      throw new MisionNoEncontradaException("No existe una mision con ese ID");
    }

    val misionEnCursoFinal = misionEnCurso.get();
    return incentivosDataMapper.toMisionDTO(misionEnCursoFinal);
  }

  @Override
  public void asignarMisionADonador(String donadorID, MisionDTO misionDTO)
      throws NoSuchElementException {

    DonadorDTO donadorDTO = fachadaDonadoresYEntidades.buscarDonadorPorID(donadorID);
    if (donadorDTO==null) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }

    val donador = donadoresRepository.findById(donadorID);
    if (donador.isEmpty()) {
      throw new DonadorNoEncontradoException("No existe una mision con ese ID");
    }
    val mision = misionesRepository.findById(misionDTO.id());
    if (mision.isEmpty()) {
      throw new MisionNoEncontradaException("No existe una mision con ese ID");
    }

    donador.get().setMisionEnCursoID(mision.get().getId());
  }

  @Override
  public void asignarInsigniaADonador(String donadorID, InsigniaDTO insigniaDTO) throws NoSuchElementException {

    val donador = donadoresRepository.findById(donadorID);
    if (donador.isEmpty()) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }
    val insignia = insigniasRepository.findById(insigniaDTO.id());
    if (insignia.isEmpty()) {
      throw new InsigniaNoEncontradaException("No existe una insignia con ese ID");
    }

    donador.get().addInsigniaIDToList(insignia.get().getId());
  }

  @Override
  public void procesarDonador(String donadorID) throws NoSuchElementException {

    val donador = donadoresRepository.findById(donadorID);
    if (donador.isEmpty()) {
      throw new DonadorNoEncontradoException("No existe una mision con ese ID");
    }
  }

  @Override
  public void setFachadaDonaciones(FachadaDonaciones fachadaDonaciones) {}

  @Override
  public void setFachadaDonadoresYEntidades(FachadaDonadoresYEntidades fachadaDonadoresYEntidades) {}

}
/*
public class Fachada implements FachadaDonadoresYEntidades {

  private DonadoresRepository donadoresRepository;
  private DonadoresYEntidadesDataMapper donadoresYEntidadesDataMapper =
      new DonadoresYEntidadesDataMapper();

  public Fachada() {
    /*
    Para que se ejecuten correctamente los tests, se necesita tener un constructor vacio
    Es decir, que no reciba parametros.
    Si necesitan un constructor con parametros
    Java permite tener varios constructores conviviendo sin conflictos.


    this.donadoresRepository = new InMemoryDonadoresRepo();
  }

  @Override
  public DonadorDTO agregarDonador(DonadorDTO donadorDTO) {
    if (this.donadoresRepository.findById(donadorDTO.id()).isPresent()) {
      throw new DonadorYaExistenteException("Ya existe un donador con ese ID");
    }

    val donador = donadoresYEntidadesDataMapper.toDonador(donadorDTO);

    val donadorGuardado = this.donadoresRepository.save(donador);

    return donadoresYEntidadesDataMapper.toDonadorDTO(donadorGuardado);
  }

  @Override
  public DonadorDTO buscarDonadorPorID(String donadorID) throws NoSuchElementException {
    val donadorOptional = this.donadoresRepository.findById(donadorID);

    if (donadorOptional.isEmpty()) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }
    val donadorFinal = donadorOptional.get();

    return donadoresYEntidadesDataMapper.toDonadorDTO(donadorFinal);
  }

  @Override
  public DonadorDTO modificarEstado(String donadorID, EstadoDonadorEnum estado)
      throws NoSuchElementException {

    val donadorOptional = this.donadoresRepository.findById(donadorID);

    if (donadorOptional.isEmpty()) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }

    val donadorFinal = donadorOptional.get();
    donadorFinal.setEstado(estado);

    this.donadoresRepository.deleteById(donadorID);
    this.donadoresRepository.save(donadorFinal);

    return donadoresYEntidadesDataMapper.toDonadorDTO(donadorFinal);
  }

  @Override
  public DonadorDTO modifcarCategoria(String donadorID, String categoria)
      throws NoSuchElementException {
    val donadorOptional = this.donadoresRepository.findById(donadorID);
    if (donadorOptional.isEmpty()) {
      throw new DonadorNoEncontradoException("No existe un donador con ese ID");
    }
    val donadorFinal = donadorOptional.get();
    donadorFinal.setCategoria(categoria);

    this.donadoresRepository.deleteById(donadorID);
    this.donadoresRepository.save(donadorFinal);

    return donadoresYEntidadesDataMapper.toDonadorDTO(donadorFinal);
  }

  @Override
  public void setFachadaIncentivos(FachadaIncentivos fachadaIncentivos) {}

  @Override
  public Boolean puedeDonar(String donadorID) throws NoSuchElementException {
    // A implementar por el alumno
    return null;
  }

  @Override
  public List<QuejaDTO> obtenerQuejasDe(String donadorID) throws NoSuchElementException {
    // A implementar por el alumno
    return List.of();
  }

  @Override
  public NecesidadMaterialDTO satisfacerNecesidad(String necesidadID, Integer cantidad)
      throws NoSuchElementException {
    // A implementar por el alumno
    return null;
  }

  @Override
  public DonadorStatsDTO estadisticasDonador(String donadorID) {
    return null;
  }

  @Override
  public EntidadBeneficaDTO agregarEntidad(EntidadBeneficaDTO entidadBeneficaDTO) {
    // A implementar por el alumno
    return null;
  }

  @Override
  public EntidadBeneficaDTO buscarEntidadPorID(String entidadID) throws NoSuchElementException {
    // A implementar por el alumno
    return null;
  }

  @Override
  public NecesidadMaterialDTO registrarNecesidad(NecesidadMaterialDTO necesidadMaterialDTO) {
    // A implementar por el alumno
    return null;
  }

  @Override
  public QuejaDTO agregarQueja(QuejaDTO quejaDTO) throws NoSuchElementException {
    // A implementar por el alumno
    return null;
  }

  @Override
  public List<NecesidadMaterialDTO> obtenerNecesidadesInsatisfechasDe(
      ProductoSolicitadoDTO productoSolicitado) {
    // A implementar por el alumno
    return List.of();
  }
}
 */
