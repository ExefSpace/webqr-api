package com.exefspace.pocwebqrapi.model;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TipoCanales")
public class TipoCanales {

    private Integer IdTipoCanal;
    private String DescripcionTipoCanal;
    private String creationUser;
    private Timestamp creationDate;
    private String updateUser;
    private Timestamp updateDate;
    public TipoCanales(){}

    public TipoCanales( String descripcionTipoCanal, String creationUser, Timestamp creationDate, String updateUser, Timestamp updateDate) {
        DescripcionTipoCanal = descripcionTipoCanal;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
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
