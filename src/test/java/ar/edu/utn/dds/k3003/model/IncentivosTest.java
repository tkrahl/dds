package ar.edu.utn.dds.k3003.model;

import ar.edu.utn.dds.k3003.Fachada;
import ar.edu.utn.dds.k3003.catedra.ClassFinder;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.DonadorDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.donadoresYEntidades.EstadoDonadorEnum;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.CategoriaDonadorEnum;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.InsigniaDTO;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.MisionDTO;
import ar.edu.utn.dds.k3003.catedra.fachadas.FachadaDonadoresYEntidades;
import ar.edu.utn.dds.k3003.repositories.DonadoresYEntidadesDataMapper;
import ar.edu.utn.dds.k3003.repositories.IncentivosDataMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class IncentivosTest {

  Fachada instancia;
  @Mock FachadaDonadoresYEntidades fachadaDonadoresYEntidades;

  InsigniaDTO insigniaEjemplo;
  MisionDTO mision1;
  MisionDTO mision2;
  DonadorDTO donadorEjemplo;

  private DonadoresYEntidadesDataMapper donadoresYEntidadesDataMapper = new DonadoresYEntidadesDataMapper();

  @SneakyThrows
  @BeforeEach
  void setUp() {

    instancia = new Fachada();

    insigniaEjemplo = new InsigniaDTO("1000", "insignia1", "descripcion1");
    mision1 = new MisionDTO("1000", "Completitud", "1000", CategoriaDonadorEnum.OCASIONAL, CategoriaDonadorEnum.COLABORADOR);
    mision1 = new MisionDTO("1001", "Donaciones Exitosas", "1000", CategoriaDonadorEnum.COLABORADOR, CategoriaDonadorEnum.TRANSFORMADOR);
    donadorEjemplo =
            new DonadorDTO(
                    "1000",
                    "NombreDonador",
                    "ApellidoDonador",
                    18,
                    "NombreApellido@utn.edu.ar",
                    "10000000",
                    "Av. Medrano 123",
                    EstadoDonadorEnum.VERIFICADO,
                    "Ocasional");
  }

  @Test
  void testAgregarInsignia() {
    InsigniaDTO retorno = instancia.agregarInsignia(insigniaEjemplo);

    Assertions.assertNotNull(retorno.id());
    Assertions.assertEquals(retorno.nombre(), insigniaEjemplo.nombre());
  }

  @Test
  void testAgregarInsigniaExiste() {
    InsigniaDTO inicio = instancia.agregarInsignia(insigniaEjemplo);
    InsigniaDTO retorno = instancia.agregarInsignia(insigniaEjemplo);

    Assertions.assertNotNull(retorno.id());
    Assertions.assertEquals(retorno.nombre(), insigniaEjemplo.nombre());
  }

  @Test
  void testAgregarMision() {

    MisionDTO retorno = instancia.agregarMision(mision1);

    Assertions.assertNotNull(retorno.id());
    Assertions.assertEquals(retorno.nombre(), mision1.nombre());
  }

}
