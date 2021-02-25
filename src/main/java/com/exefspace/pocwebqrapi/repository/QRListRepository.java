package com.exefspace.pocwebqrapi.repository;

import com.exefspace.pocwebqrapi.model.IQRListCanales;
import com.exefspace.pocwebqrapi.model.QRList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QRListRepository  extends JpaRepository<QRList,Integer> {

    @Query(value="SELECT  q.idQR, q.url, q.idCanal, q.creationUser, q.creationDate, q.updateUser, q.updateDate, c.idTipoCanal, c.CodigoCanal, c.DescripcionCanal, c.DescripcionUbicacion,t.DescripcionTipoCanal FROM QRList q inner join Canales c on q.IdCanal=c.IdCanal inner join TipoCanales t on c.IdTipoCanal=t.IdTipoCanal", nativeQuery = true)
    List<IQRListCanales> obtenerQrXCanalTodos();
}
