package com.exefspace.pocwebqrapi.repository;

 import com.exefspace.pocwebqrapi.model.TipoCanales;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;

public interface TipoCanalesRepository  extends JpaRepository<TipoCanales,Integer> {


}
