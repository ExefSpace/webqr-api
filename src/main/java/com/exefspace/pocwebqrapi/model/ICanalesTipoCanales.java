package com.exefspace.pocwebqrapi.model;

import java.sql.Timestamp;

public interface ICanalesTipoCanales {
    Integer getIdCanal();
    Integer getIdTipoCanal();
    String getCodigoCanal();
    String getDescripcionCanal();
    String getDescripcionUbicacion();
    String getcreationUser();
    Timestamp getcreationDate();
    String getupdateUser();
    Timestamp getupdateDate();
    String getDescripcionTipoCanal();
}
