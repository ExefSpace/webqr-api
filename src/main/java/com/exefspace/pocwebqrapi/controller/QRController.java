package com.exefspace.pocwebqrapi.controller;

import com.exefspace.pocwebqrapi.exception.ResourceNotFoundException;
import com.exefspace.pocwebqrapi.model.IQRListCanales;
import com.exefspace.pocwebqrapi.model.QRList;
import com.exefspace.pocwebqrapi.repository.CanalesRepository;
import com.exefspace.pocwebqrapi.repository.QRListRepository;
import com.exefspace.pocwebqrapi.repository.TipoCanalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QRController {
    Logger logger = LoggerFactory.getLogger(QRController.class);


  @Autowired
  private QRListRepository qrListRepository;

 /*   @GetMapping("/qrlist")
    public List<QRList> getAllQRList() {
        return qrListRepository.findAll();
    }*/

    @GetMapping("/qrlist")
    public List<QRList> getQR(@RequestParam(required = false)  Integer IdQR)
            throws ResourceNotFoundException {

        List<QRList> lista = new ArrayList<QRList>();

        if(IdQR!=null){
            QRList qr = qrListRepository.findById(IdQR).orElseThrow(
                    () -> new ResourceNotFoundException("QR no encontrado para este ID:: " + IdQR));
            lista.add(qr);
        }
        else
        {
            lista=qrListRepository.findAll();
        }
        return lista;
    }

    @GetMapping("/qrxcanal")
    public List<IQRListCanales> getQrXCanal()
            throws ResourceNotFoundException {
        return qrListRepository.obtenerQrXCanalTodos();
    }



    @PostMapping("/qrlist")
    public QRList createQR(@Valid @RequestBody QRList qrList) {
        logger.info("--------------------------------------------------------");
        logger.info(qrList.toString());
        //estadoDispositivo(eventosIot.getIdDispositivo());
        return qrListRepository.save(qrList);
    }





    @PutMapping("/qrlist")
    public ResponseEntity<QRList> updateQR(@RequestParam Integer IdQR,
                                                           @Valid @RequestBody QRList qrList) throws ResourceNotFoundException {
        QRList result = qrListRepository.findById(IdQR).orElseThrow(
                () -> new ResourceNotFoundException("QR no encontrado para este id :: " + IdQR));

        result.setCreationDate(qrList.getCreationDate());
        result.setCreationUser(qrList.getCreationUser());
        result.setUpdateDate(qrList.getUpdateDate());
        result.setUpdateUser(qrList.getUpdateUser());
        result.setIdCanal(qrList.getIdCanal());
        result.setUrl(qrList.getUrl());
        result.setIdQR(qrList.getIdQR());
        QRList updatedQR= qrListRepository.save(result);
        return ResponseEntity.ok(updatedQR);
    }

    @DeleteMapping("/qrlist")
    void deleteQR(@RequestParam Integer IdQR) {
        qrListRepository.deleteById(IdQR);
    }

    @GetMapping("/fechasistema")
    public String getFechaSistema() {

        Instant instant= Instant.now();
        Timestamp tActual = Timestamp.from(instant);


        long milliseconds2 = tActual.getTime();

        //log.info("Current Time Stamp: " + tActual);

        return "Timestamp: "+tActual + " tiempo en ms: "+milliseconds2;
    }

}
