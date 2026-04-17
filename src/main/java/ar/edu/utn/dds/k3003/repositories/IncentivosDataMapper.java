package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.MisionDTO;
import ar.edu.utn.dds.k3003.model.Mision;
import ar.edu.utn.dds.k3003.catedra.dtos.incentivos.InsigniaDTO;
import ar.edu.utn.dds.k3003.model.Insignia;

public class IncentivosDataMapper {

    public MisionDTO toMisionDTO(Mision mision) {
        return new MisionDTO(
            mision.getId(),
            mision.getNombre(),
            mision.getInsigniaID(),
            mision.getCategoriaInicio(),
            mision.getCategoriaFin());
    }

    public Mision toMision(MisionDTO misionDTO) {
        return new Mision(
            misionDTO.nombre(),
            misionDTO.insigniaID(),
            misionDTO.categoriaInicio(),
            misionDTO.categoriaFin());
    }

    public InsigniaDTO toInsigniaDTO(Insignia insignia) {
        return new InsigniaDTO(
            insignia.getId(),
            insignia.getNombre(),
            insignia.getDescripcion());
    }

    public Insignia toInsignia(InsigniaDTO insigniaDTO) {
        return new Insignia(
            insigniaDTO.nombre(),
            insigniaDTO.descripcion());
    }
    
}
