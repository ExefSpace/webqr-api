package com.exefspace.pocwebqrapi.model;


import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Canales")
public class Canales {
    private Integer IdCanal;
    private Integer IdTipoCanal;
    private String CodigoCanal;
    private String DescripcionCanal;
    private String DescripcionUbicacion;
    private String creationUser;
    private Timestamp creationDate;
    private String updateUser;
    private Timestamp updateDate;

    public Canales(){}

    public Canales(Integer idTipoCanal, String codigoCanal, String descripcionCanal, String descripcionUbicacion, String creationUser, Timestamp creationDate, String updateUser, Timestamp updateDate) {
        IdTipoCanal = idTipoCanal;
        CodigoCanal = codigoCanal;
        DescripcionCanal = descripcionCanal;
        DescripcionUbicacion = descripcionUbicacion;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCanal", nullable = false, unique = true)
    public Integer getIdCanal() {
        return IdCanal;
    }

    public void setIdCanal(Integer idCanal) {
        IdCanal = idCanal;
    }

    @Column(name = "IdTipoCanal", nullable = false)
    @Nationalized
    public Integer getIdTipoCanal() {
        return IdTipoCanal;
    }

    public void setIdTipoCanal(Integer idTipoCanal) {
        IdTipoCanal = idTipoCanal;
    }

    @Column(name = "CodigoCanal", nullable = false)
    @Nationalized
    public String getCodigoCanal() {
        return CodigoCanal;
    }

    public void setCodigoCanal(String codigoCanal) {
        CodigoCanal = codigoCanal;
    }

    @Column(name = "DescripcionCanal", nullable = false)
    @Nationalized
    public String getDescripcionCanal() {
        return DescripcionCanal;
    }

    public void setDescripcionCanal(String descripcionCanal) {
        DescripcionCanal = descripcionCanal;
    }

    @Column(name = "DescripcionUbicacion", nullable = false)
    @Nationalized
    public String getDescripcionUbicacion() {
        return DescripcionUbicacion;
    }

    public void setDescripcionUbicacion(String descripcionUbicacion) {
        DescripcionUbicacion = descripcionUbicacion;
    }

    @Column(name = "creationUser", nullable = false)
    @Nationalized
    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    @Column(name = "creationDate", nullable = false)
    @Nationalized
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
    @Column(name = "updateUser", nullable = false)
    @Nationalized
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    @Column(name = "updateDate", nullable = false)
    @Nationalized
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
