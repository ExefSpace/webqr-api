package com.exefspace.pocwebqrapi.model;

import java.sql.Timestamp;

public interface IQRListCanales {
  Integer getIdQR();
  String geturl();
  Integer getIdCanal();
  String getcreationUser();
  Timestamp getcreationDate();
  String getupdateUser();
  Timestamp getupdateDate();
  Integer getIdTipoCanal();
  String getCodigoCanal();
  String getDescripcionCanal();
  String getDescripcionUbicacion();
  String getDescripcionTipoCanal();
}
