package ar.edu.utn.dds.k3003.catedra.logistica;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import ar.edu.utn.dds.k3003.Fachada;
import ar.edu.utn.dds.k3003.catedra.ClassFinder;
<<<<<<< HEAD
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.NecesidadMaterialDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.ProductoSolicitadoDTO;
=======
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.DonacionDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donaciones.EstadoDonacionEnum;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.NecesidadMaterialDTO;
>>>>>>> template/main
import ar.edu.utn.dds.k3003.catedra.dtos.logistica.*;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonaciones;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaLogistica;
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
@EnabledIf("ar.edu.utn.dds.k3003.catedra.logistica.LogisticaTest#condicion")
public class LogisticaTest {

  FachadaLogistica instancia;
  @Mock FachadaDonadoresYEntidades fachadaDonadoresYEntidades;
  @Mock FachadaDonaciones fachadaDonaciones;

  DepositoDTO depositoEjemplo;
  NecesidadDeEntidadDTO necesidadDeEjemplo;
  PaqueteDTO paqueteEjemplo;

  @SneakyThrows
  @BeforeEach
  void setUp() {

    var clazz = ClassFinder.findClass();
    instancia = (FachadaLogistica) clazz.getDeclaredConstructor().newInstance();
    instancia.setAlgoritmoMM();

    instancia.setFachadaDonadoresYEntidades(fachadaDonadoresYEntidades);
    instancia.setFachadaDonaciones(fachadaDonaciones);

<<<<<<< HEAD
    depositoEjemplo = new DepositoDTO(null, "Deposito1", "direc1", 1000, null);
    necesidadDeEjemplo =
        new NecesidadDeEntidadDTO(null, "entidad1", 5, "necesidadUrgente", 10, "producto1");
    paqueteEjemplo = new PaqueteDTO("1", "producto1", "producto1", 10);
=======
    depositoEjemplo = new DepositoDTO(null, "deposito1", "direccion1", 1000, null);
    necesidadDeEjemplo =
        new NecesidadDeEntidadDTO(null, "entidad1", 5, "descripcion1", 10, "producto1");
    paqueteEjemplo = new PaqueteDTO("paquete1", "donacion1", "producto1", 10);
>>>>>>> template/main
  }

  static boolean condicion() {

    return FachadaLogistica.class.isAssignableFrom(Fachada.class);
  }

  @Test
  void testAgregarDeposito() {

    DepositoDTO retorno = instancia.agregarDeposito(depositoEjemplo);

    Assertions.assertNotNull(retorno.id());
    Assertions.assertEquals(retorno.nombre(), depositoEjemplo.nombre());
  }

  @Test
  void testAgregarDepositoFallido() {
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.agregarDeposito(null);
        });

    DepositoDTO retorno = instancia.agregarDeposito(depositoEjemplo);

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.agregarDeposito(retorno);
        });
  }

  @Test
  void testBuscarDepositoPorID() {
    DepositoDTO retorno = instancia.agregarDeposito(depositoEjemplo);

    DepositoDTO buscado = instancia.buscarDepositoPorID(retorno.id());

    Assertions.assertNotNull(buscado);
    Assertions.assertEquals(retorno.id(), buscado.id());
  }

  @Test
  void testBuscarDepositoPorIDFallido() {
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.buscarDepositoPorID("Inexistente");
        });
  }

  @Test
  void testGestionarDonacion() {

<<<<<<< HEAD
    when(fachadaDonadoresYEntidades.obtenerNecesidadesInsatisfechasDe(
            new ProductoSolicitadoDTO("p1", "p1", "p1")))
        .thenReturn(List.of(new NecesidadMaterialDTO("1", "e1", 5, "neceDescr", 5, "producto1")));

    DepositoDTO depositoRetorno = instancia.agregarDeposito(depositoEjemplo);

    DepositoDTO actualizado = instancia.gestionarDonacion(depositoRetorno.id(), "producto1", 10);

    Assertions.assertNotNull(actualizado);
    Assertions.assertTrue(actualizado.id().equals(depositoRetorno.id()));

    verify(fachadaDonadoresYEntidades, times(1))
        .obtenerNecesidadesInsatisfechasDe(new ProductoSolicitadoDTO("p1", "p1", "p1"));
=======
    when(fachadaDonadoresYEntidades.obtenerNecesidadesInsatisfechasDe("producto1"))
        .thenReturn(
            List.of(
                new NecesidadMaterialDTO(
                    "necesidad1", "entidad1", 5, "descripcion1", 5, "producto1")));

    when(fachadaDonadoresYEntidades.satisfacerNecesidad("necesidad1", paqueteEjemplo.cantidad()))
        .thenReturn(any());

    DepositoDTO depositoRetorno = instancia.agregarDeposito(depositoEjemplo);

    DepositoDTO actualizado =
        instancia.gestionarDonacion(depositoRetorno.id(), "donacion1", "producto1", 10);

    Assertions.assertNotNull(actualizado);
    Assertions.assertEquals(actualizado.id(), depositoRetorno.id());

    verify(fachadaDonadoresYEntidades, times(1))
        .satisfacerNecesidad("necesidad1", paqueteEjemplo.cantidad());
    verify(fachadaDonadoresYEntidades, times(1)).obtenerNecesidadesInsatisfechasDe("producto1");
>>>>>>> template/main
  }

  @Test
  void testGestionarDonacionFallido() {
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
<<<<<<< HEAD
          instancia.gestionarDonacion("Inexistente", "producto1", 10);
=======
          instancia.gestionarDonacion("Inexistente", "donacion1", "producto1", 10);
>>>>>>> template/main
        });

    DepositoDTO depositoRetorno = instancia.agregarDeposito(depositoEjemplo);

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
<<<<<<< HEAD
          instancia.gestionarDonacion(depositoRetorno.id(), "producto1", -1);
=======
          instancia.gestionarDonacion(depositoRetorno.id(), "donacion1", "producto1", -1);
>>>>>>> template/main
        });

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
<<<<<<< HEAD
          instancia.gestionarDonacion(depositoRetorno.id(), "producto1", 0);
=======
          instancia.gestionarDonacion(depositoRetorno.id(), "donacion1", "producto1", 0);
>>>>>>> template/main
        });
  }

  @Test
  void testEjecutarMatchmaking() {

    List<NecesidadDeEntidadDTO> necesidades =
<<<<<<< HEAD
        List.of(new NecesidadDeEntidadDTO("n1", "e1", 5, "necDescr", 5, "producto1"));
=======
        List.of(
            new NecesidadDeEntidadDTO("necesidad1", "entidad1", 5, "descripcion1", 5, "producto1"));
>>>>>>> template/main

    AsignacionDTO asignacion = instancia.ejecutarMatchmaking(paqueteEjemplo, necesidades);

    Assertions.assertNotNull(asignacion);
    Assertions.assertEquals(paqueteEjemplo.id(), asignacion.paqueteID());
    Assertions.assertEquals(necesidades.getFirst().id(), asignacion.necesidadID());
  }

  @Test
  void testEjecutarMatchmakingFallido() {

    List<NecesidadDeEntidadDTO> necesidades =
<<<<<<< HEAD
        List.of(new NecesidadDeEntidadDTO("n1", "e1", 5, "necDescr", 5, "producto1"));
=======
        List.of(
            new NecesidadDeEntidadDTO("necesidad1", "entidad1", 5, "descripcion1", 5, "producto1"));
>>>>>>> template/main

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.ejecutarMatchmaking(null, necesidades);
        });
  }

  @Test
  void testReportarEntrega() {

<<<<<<< HEAD
    instancia.reportarEntrega(paqueteEjemplo);

    Assertions.assertTrue(
        instancia
            .buscarAsignacionPorPaqueteID("1")
            .estado()
            .equals(EstadoAsginacionEnum.COMPLETADA));

    verify(fachadaDonaciones, times(1)).cambiarEstadoDeDonacion("a", any());
=======
    when(fachadaDonaciones.cambiarEstadoDeDonacion(
            paqueteEjemplo.donacionID(), EstadoDonacionEnum.ACEPTADA))
        .thenReturn(
            new DonacionDTO(
                paqueteEjemplo.donacionID(),
                "donador1",
                "deposito1",
                "descripcion1",
                paqueteEjemplo.producto(),
                paqueteEjemplo.cantidad(),
                EstadoDonacionEnum.ACEPTADA));

    //Van a necesitar que ejecutarMatchmaking guarde la asignacion en el repo.
    AsignacionDTO asignacionDTO = instancia.ejecutarMatchmaking(paqueteEjemplo, List.of(necesidadDeEjemplo));

    instancia.reportarEntrega(paqueteEjemplo);

    Assertions.assertEquals(
        EstadoAsginacionEnum.COMPLETADA,
        instancia.buscarAsignacionPorPaqueteID(paqueteEjemplo.id()).estado());

    verify(fachadaDonaciones, times(1))
        .cambiarEstadoDeDonacion(paqueteEjemplo.donacionID(), EstadoDonacionEnum.ACEPTADA);
>>>>>>> template/main
  }

  @Test
  void testReportarEntregaFallido() {

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.reportarEntrega(null);
        });

<<<<<<< HEAD
    when(fachadaDonaciones.cambiarEstadoDeDonacion("d1", any())).thenThrow(new RuntimeException());
=======
    when(fachadaDonaciones.cambiarEstadoDeDonacion(
            paqueteEjemplo.donacionID(), EstadoDonacionEnum.ACEPTADA))
        .thenThrow(new RuntimeException());
>>>>>>> template/main

    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          instancia.reportarEntrega(paqueteEjemplo);
        });

<<<<<<< HEAD
    verify(fachadaDonaciones, times(1)).cambiarEstadoDeDonacion("d1", any());
=======
    verify(fachadaDonaciones, times(1))
        .cambiarEstadoDeDonacion(paqueteEjemplo.donacionID(), EstadoDonacionEnum.ACEPTADA);
>>>>>>> template/main
  }
}
