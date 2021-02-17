package com.exefspace.pocwebqrapi.model;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "QRList")
public class QRList {

    private Integer IdQR;
    private String url;
    private Integer IdCanal;
    private String creationUser;
    private Timestamp creationDate;
    private String updateUser;
    private Timestamp updateDate;

    public QRList(String url, Integer idCanal, String creationUser, Timestamp creationDate, String updateUser, Timestamp updateDate) {
        this.url = url;
        IdCanal = idCanal;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IdQR", nullable = false, unique = true)
    public Integer getIdQR() {
        return IdQR;
    }

    public void setIdQR(Integer idQR) {
        IdQR = idQR;
    }
    @Column(name = "url", nullable = false)
    @Nationalized
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "IdCanal", nullable = false)
    @Nationalized
    public Integer getIdCanal() {
        return IdCanal;
    }

    public void setIdCanal(Integer idCanal) {
        IdCanal = idCanal;
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
