package com.exefspace.pocwebqrapi.model;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "TipoCanales")
public class TipoCanales {

    private Integer IdTipoCanal;
    private String DescripcionTipoCanal;

    public TipoCanales(){}
    public TipoCanales(String descripcionTipoCanal) {
        DescripcionTipoCanal = descripcionTipoCanal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IdTipoCanal", nullable = false, unique = true)

    public Integer getIdTipoCanal() {
        return IdTipoCanal;
    }

    public void setIdTipoCanal(Integer idTipoCanal) {
        IdTipoCanal = idTipoCanal;
    }

    @Column(name = "DescripcionTipoCanal", nullable = false)
    @Nationalized
    public String getDescripcionTipoCanal() {
        return DescripcionTipoCanal;
    }

    public void setDescripcionTipoCanal(String descripcionTipoCanal) {
        DescripcionTipoCanal = descripcionTipoCanal;
    }
}
