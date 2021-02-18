package com.exefspace.pocwebqrapi.controller;


import com.exefspace.pocwebqrapi.exception.ResourceNotFoundException;
import com.exefspace.pocwebqrapi.model.Canales;
import com.exefspace.pocwebqrapi.model.QRList;
import com.exefspace.pocwebqrapi.repository.CanalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CanalesController {
    Logger logger = LoggerFactory.getLogger(CanalesController.class);
    @Autowired
    private CanalesRepository canalesRepository;

    @GetMapping("/canales")
    public List<Canales> getCanalByIdCanal(@RequestParam(required = false) Integer IdCanal)
            throws ResourceNotFoundException {
        List<Canales> lista = new ArrayList<Canales>();

        if(IdCanal!=null){
            Canales canales = canalesRepository.findById(IdCanal).orElseThrow(
                    () -> new ResourceNotFoundException("Evento no encontrado para este ID:: " + IdCanal));
            lista.add(canales);
        }
        else
        {
            lista=canalesRepository.findAll();
        }
        return lista;

    }

    @PostMapping("/canales")
    public Canales createCanales(@Valid @RequestBody Canales canales) {
        logger.info("--------------------------------------------------------");
        logger.info(canales.toString());
        //estadoDispositivo(eventosIot.getIdDispositivo());
        return canalesRepository.save(canales);
    }
}
