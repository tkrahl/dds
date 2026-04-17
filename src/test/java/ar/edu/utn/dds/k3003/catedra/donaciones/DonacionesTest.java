package ar.edu.utn.dds.k3003.catedra.donaciones;

import static org.mockito.Mockito.*;

import ar.edu.utn.dds.k3003.Fachada;
import ar.edu.utn.dds.k3003.catedra.ClassFinder;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.DonacionDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.EstadoDonacionEnum;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.DonadorDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.QuejaDTO;
<<<<<<< HEAD
=======
import ar.edu.utn.dds.k3003.catedra.dtos.logistica.DepositoDTO;
>>>>>>> template/main
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonaciones;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaLogistica;
import java.time.LocalDate;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@EnabledIf("ar.edu.utn.dds.k3003.catedra.donaciones.DonacionesTest#condicion")
public class DonacionesTest {

  FachadaDonaciones instancia;
  @Mock FachadaDonadoresYEntidades fachadaDonadoresYEntidades;
  @Mock FachadaLogistica fachadaLogistica;

  DonadorDTO donadorEjemplo;
  DonacionDTO donacionEjemplo;
  DonacionDTO donacionAceptadaEjemplo;
  QuejaDTO quejaEjemplo;

  @SneakyThrows
  @BeforeEach
  void setUp() {

    var clazz = ClassFinder.findClass();
    instancia = (FachadaDonaciones) clazz.getDeclaredConstructor().newInstance();

    instancia.setFachadaDonadoresYEntidades(fachadaDonadoresYEntidades);
    instancia.setFachadaLogistica(fachadaLogistica);

<<<<<<< HEAD
    donacionEjemplo = new DonacionDTO(null, "1", "1", "dn1", "p1", 5, EstadoDonacionEnum.INGRESADA);
    donacionAceptadaEjemplo =
        new DonacionDTO(null, "1", "1", "dn1", "p1", 5, EstadoDonacionEnum.ACEPTADA);
    donadorEjemplo =
        new DonadorDTO("1", "dr1", "dra1", 5, "email", "dni", "calle", null, "Ocasional");
    quejaEjemplo = new QuejaDTO(null, "1", "1", null, "Lalala");
=======
    donacionEjemplo =
        new DonacionDTO(
            null,
            "donador1",
            "deposito1",
            "descripcion1",
            "producto1",
            5,
            EstadoDonacionEnum.INGRESADA);
    donacionAceptadaEjemplo =
        new DonacionDTO(
            null,
            "donador1",
            "deposito1",
            "descripcion1",
            "producto1",
            5,
            EstadoDonacionEnum.ACEPTADA);
    donadorEjemplo =
        new DonadorDTO(
            "donador1",
            "donador1",
            "donador1",
            5,
            "donador1",
            "donador1",
            "donador1",
            null,
            "donador1");
    quejaEjemplo = new QuejaDTO(null, "donacion1", "donador1", null, "descripcion1");
>>>>>>> template/main
  }

  static boolean condicion() {

    return FachadaDonaciones.class.isAssignableFrom(Fachada.class);
  }

  @Test
  void testRegistrarDonacion() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donacionEjemplo.donadorID()))
        .thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt())).thenReturn(null);
=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));
>>>>>>> template/main

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

    DonacionDTO busqueda = instancia.buscarDonacionPorID(retorno.id());

    Assertions.assertNotNull(retorno.id());
    Assertions.assertEquals(retorno.id(), busqueda.id());
<<<<<<< HEAD
    Assertions.assertEquals(busqueda.donadorID(), retorno.donadorID());
    Assertions.assertEquals(busqueda.productoID(), retorno.productoID());
    Assertions.assertEquals(busqueda.cantidad(), retorno.cantidad());

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donacionEjemplo.donadorID());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
=======

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
>>>>>>> template/main
  }

  @Test
  void testRegistrarDonacionFallido() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donacionEjemplo.donadorID()))
        .thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt()));
=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));
>>>>>>> template/main

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.registrarDonacion(null);
        });

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.registrarDonacion(retorno);
        });

<<<<<<< HEAD
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donacionEjemplo.donadorID());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
=======
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
>>>>>>> template/main
  }

  @Test
  void testRegistrarDonacionNoPuedeDonar() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donacionEjemplo.donadorID()))
        .thenReturn(Boolean.FALSE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt()));
=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.FALSE);
>>>>>>> template/main

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.registrarDonacion(donacionEjemplo);
        });

<<<<<<< HEAD
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(any());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
  }

  @Test
  void testBuscarDonacionPorID() {

    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donacionEjemplo.donadorID()))
        .thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt()));

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

    DonacionDTO buscada = instancia.buscarDonacionPorID(retorno.id());

    Assertions.assertNotNull(buscada);
    Assertions.assertEquals(retorno.id(), buscada.id());

    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(any());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
=======
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
>>>>>>> template/main
  }

  @Test
  void testBuscarDonacionPorIDFallido() {
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.buscarDonacionPorID("Inexistente");
        });
  }

  @Test
  void testRegistrarQueja() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donacionEjemplo.donadorID()))
        .thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt())).thenReturn(any());
    when(fachadaDonadoresYEntidades.agregarQueja(any())).thenReturn(any());

    DonacionDTO retornoD = instancia.registrarDonacion(donacionEjemplo);

=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));

    DonacionDTO retornoD = instancia.registrarDonacion(donacionEjemplo);

    instancia.cambiarEstadoDeDonacion(retornoD.id(), EstadoDonacionEnum.ACEPTADA);

    when(fachadaDonadoresYEntidades.agregarQueja(any()))
        .thenReturn(
            new QuejaDTO("queja1", retornoD.id(), retornoD.donadorID(), null, "descripcion1"));

>>>>>>> template/main
    DonacionDTO retorno =
        instancia.registrarQuejaEnDonacion(retornoD.id(), quejaEjemplo.descripcion());

    Assertions.assertNotNull(retorno.id());
<<<<<<< HEAD
    Assertions.assertEquals(retorno.descripcion(), quejaEjemplo.descripcion());
    Assertions.assertEquals(
        instancia.buscarDonacionPorID(retorno.id()).estado(), EstadoDonacionEnum.CONQUEJA);

    verify(fachadaDonadoresYEntidades, times(1)).agregarQueja(quejaEjemplo);
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donacionEjemplo.donadorID());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
=======
    Assertions.assertEquals(
        EstadoDonacionEnum.CONQUEJA, instancia.buscarDonacionPorID(retorno.id()).estado());

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
    verify(fachadaDonadoresYEntidades, times(1)).agregarQueja(any());
>>>>>>> template/main
  }

  @Test
  void testRegistrarQuejaFallido() {
<<<<<<< HEAD

=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));
>>>>>>> template/main
    when(fachadaDonadoresYEntidades.agregarQueja(any())).thenThrow(new RuntimeException());

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.registrarQuejaEnDonacion(null, quejaEjemplo.descripcion());
        });

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

<<<<<<< HEAD
=======
    instancia.cambiarEstadoDeDonacion(retorno.id(), EstadoDonacionEnum.ACEPTADA);

>>>>>>> template/main
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.registrarQuejaEnDonacion(retorno.id(), quejaEjemplo.descripcion());
        });
    Assertions.assertEquals(
<<<<<<< HEAD
        instancia.buscarDonacionPorID(retorno.id()).estado(), EstadoDonacionEnum.ACEPTADA);

    verify(fachadaDonadoresYEntidades, times(1)).agregarQueja(quejaEjemplo);
=======
        EstadoDonacionEnum.ACEPTADA, instancia.buscarDonacionPorID(retorno.id()).estado());

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
    verify(fachadaDonadoresYEntidades, times(1)).agregarQueja(any());
>>>>>>> template/main
  }

  @Test
  void testCambiarEstadoDeDonacion() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(any())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt()));
=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));
>>>>>>> template/main

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

    DonacionDTO actualizada =
        instancia.cambiarEstadoDeDonacion(retorno.id(), EstadoDonacionEnum.ACEPTADA);

    Assertions.assertNotNull(actualizada);
    Assertions.assertEquals(EstadoDonacionEnum.ACEPTADA, actualizada.estado());
    Assertions.assertEquals(
<<<<<<< HEAD
        instancia.buscarDonacionPorID(retorno.id()).estado(), EstadoDonacionEnum.ACEPTADA);

    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(any());
=======
        EstadoDonacionEnum.ACEPTADA, instancia.buscarDonacionPorID(retorno.id()).estado());

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
>>>>>>> template/main
  }

  @Test
  void testCambiarEstadoDeDonacionFallido() {
<<<<<<< HEAD
=======

    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));

>>>>>>> template/main
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.cambiarEstadoDeDonacion("Inexistente", EstadoDonacionEnum.ACEPTADA);
        });

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.cambiarEstadoDeDonacion(retorno.id(), null);
        });
<<<<<<< HEAD
=======

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
>>>>>>> template/main
  }

  @Test
  void testBuscarPorDonadorYFechaInicio() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donacionEjemplo.donadorID()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(any())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), anyInt()));

    String donadorID = "1";

    instancia.registrarDonacion(donacionEjemplo);

    List<DonacionDTO> resultado =
        instancia.buscarPorDonadorYFechaInicio(donadorID, LocalDate.ofYearDay(2025, 99));

    Assertions.assertNotNull(resultado);
    Assertions.assertTrue(resultado.stream().anyMatch(d -> d.id().equals(donacionEjemplo.id())));
    Assertions.assertEquals(1, resultado.size());

    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donacionEjemplo.donadorID());
    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(any());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), anyInt());
=======
    when(fachadaDonadoresYEntidades.buscarDonadorPorID(donadorEjemplo.id()))
        .thenReturn(donadorEjemplo);
    when(fachadaDonadoresYEntidades.puedeDonar(donadorEjemplo.id())).thenReturn(Boolean.TRUE);
    when(fachadaLogistica.gestionarDonacion(any(), any(), any(), anyInt()))
        .thenReturn(new DepositoDTO("deposito1", "deposito1", "direccion1", 1000, null));

    DonacionDTO retorno = instancia.registrarDonacion(donacionEjemplo);

    List<DonacionDTO> resultado =
        instancia.buscarPorDonadorYFechaInicio(retorno.donadorID(), LocalDate.ofYearDay(2025, 99));

    Assertions.assertNotNull(resultado);
    Assertions.assertTrue(resultado.stream().anyMatch(d -> d.id().equals(retorno.id())));
    Assertions.assertEquals(1, resultado.size());

    verify(fachadaDonadoresYEntidades, times(1)).puedeDonar(donadorEjemplo.id());
    verify(fachadaDonadoresYEntidades, times(1)).buscarDonadorPorID(donadorEjemplo.id());
    verify(fachadaLogistica, times(1)).gestionarDonacion(any(), any(), any(), anyInt());
>>>>>>> template/main
  }

  @Test
  void testBuscarPorDonadorYFechaInicioFallido() {
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.buscarPorDonadorYFechaInicio("Inexistente", LocalDate.now());
        });
  }
}
