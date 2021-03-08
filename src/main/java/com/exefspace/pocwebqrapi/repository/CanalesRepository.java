package com.exefspace.pocwebqrapi.repository;

import com.exefspace.pocwebqrapi.model.Canales;
import com.exefspace.pocwebqrapi.model.ICanalesTipoCanales;
import com.exefspace.pocwebqrapi.model.IQRListCanales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CanalesRepository  extends JpaRepository<Canales,Integer> {

    @Query(value="select c.IdCanal, c.IdTipoCanal, c.CodigoCanal, c.DescripcionCanal, c.DescripcionUbicacion, c.creationUser, c.creationDate,c.updateUser,c.updateDate, t.DescripcionTipoCanal\n" +
            "    from [Canales] c inner join [TipoCanales] t on c.IdTipoCanal=t.IdTipoCanal", nativeQuery = true)
    List<ICanalesTipoCanales> obtenerCanalXTiposTodos();

    @Query(value="SELECT count(IdCanal) FROM Canales where IdTipoCanal = :IdTipoCanal", nativeQuery = true)
    Integer contarCanalesAsociadosATipoCanal(@Param("IdTipoCanal") Integer IdTipoCanal);
}
