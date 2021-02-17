package com.exefspace.pocwebqrapi.controller;

import com.exefspace.pocwebqrapi.exception.ResourceNotFoundException;
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
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QRController {
    Logger logger = LoggerFactory.getLogger(QRController.class);

  @Autowired
  private CanalesRepository canalesRepository;
  @Autowired
  private QRListRepository qrListRepository;
  @Autowired
  private TipoCanalesRepository tipoCanalesRepository;



    @GetMapping("/qrlist")
    public List<QRList> getAllQRList() {
        return qrListRepository.findAll();
    }

    @GetMapping("/qrlist/{IdQR}")
    public ResponseEntity<QRList> getQRById(@PathVariable(value = "IdQR") Integer IdQR)
            throws ResourceNotFoundException {
        QRList qr = qrListRepository.findById(IdQR).orElseThrow(
                () -> new ResourceNotFoundException("Evento no encontrado para este ID:: " + IdQR));
        return ResponseEntity.ok().body(qr);
    }



    @PostMapping("/qrlist")
    public QRList createQR(@Valid @RequestBody QRList qrList) {
        logger.info("--------------------------------------------------------");
        logger.info(qrList.toString());
        //estadoDispositivo(eventosIot.getIdDispositivo());
        return qrListRepository.save(qrList);
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
