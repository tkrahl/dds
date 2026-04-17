package ar.edu.utn.dds.k3003.model;

import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.EstadoDonadorEnum;
import java.util.List;

public class Donador {

  private String id;
  private String nombre;
  private String apellido;
  private Integer edad;
  private String email;
  private String nroDocumento;
  private String domicilio;
  private EstadoDonadorEnum estado;
  private String categoria;
  private List<String> insigniasID;
  private String misionEnCursoID;

  public Donador(
      String nombre,
      String apellido,
      Integer edad,
      String email,
      String nroDocumento,
      String domicilio,
      List<String> insigniasID,
      String misionEnCursoID) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.email = email;
    this.nroDocumento = nroDocumento;
    this.domicilio = domicilio;
    this.estado = EstadoDonadorEnum.VERIFICADO;
    this.categoria = "Ocasional";
    this.insigniasID = insigniasID;
    this.misionEnCursoID = misionEnCursoID;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNroDocumento() {
    return nroDocumento;
  }

  public void setNroDocumento(String nroDocumento) {
    this.nroDocumento = nroDocumento;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public EstadoDonadorEnum getEstado() {
    return estado;
  }

  public void setEstado(EstadoDonadorEnum estado) {
    this.estado = estado;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public List<String> getInsigniasID() {
    return insigniasID;
  }

  public void setInsigniasID(List<String> insigniasID) {
    this.insigniasID = insigniasID;
  }

  public void addInsigniaIDToList(String insigniaID) {
    this.insigniasID.add(insigniaID);
  }

  public String getMisionEnCursoID() {
    return misionEnCursoID;
  }

  public void setMisionEnCursoID(String misionEnCursoID) {
    this.misionEnCursoID = misionEnCursoID;
  }
}
