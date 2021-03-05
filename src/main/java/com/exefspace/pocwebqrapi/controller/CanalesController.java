package com.exefspace.pocwebqrapi.controller;


import com.exefspace.pocwebqrapi.exception.ResourceNotFoundException;
import com.exefspace.pocwebqrapi.model.Canales;
import com.exefspace.pocwebqrapi.model.ICanalesTipoCanales;
import com.exefspace.pocwebqrapi.model.IQRListCanales;
import com.exefspace.pocwebqrapi.model.QRList;
import com.exefspace.pocwebqrapi.repository.CanalesRepository;
import com.exefspace.pocwebqrapi.repository.QRListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private QRListRepository qrListRepository;
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

    @PutMapping("/canales")
    public ResponseEntity<Canales> updateCanales(@RequestParam Integer IdCanal,
                                           @Valid @RequestBody Canales canales) throws ResourceNotFoundException {
        Canales result = canalesRepository.findById(IdCanal).orElseThrow(
                () -> new ResourceNotFoundException("Canal no encontrado para este id :: " + IdCanal));

        result.setCreationDate(canales.getCreationDate());
        result.setCreationUser(canales.getCreationUser());
        result.setUpdateDate(canales.getUpdateDate());
        result.setUpdateUser(canales.getUpdateUser());
        result.setCodigoCanal(canales.getCodigoCanal());
        result.setIdTipoCanal(canales.getIdTipoCanal());
        result.setDescripcionUbicacion(canales.getDescripcionUbicacion());
        result.setDescripcionCanal(canales.getDescripcionCanal());

        Canales updatedCanales= canalesRepository.save(result);
        return ResponseEntity.ok(updatedCanales);
    }

    @DeleteMapping("/canales")
    ResponseEntity<String> deleteCanales(@RequestParam Integer IdCanal) {
        Integer conteo = this.qrListRepository.contarQRAsociadoACanal(IdCanal);
        if (conteo>0)
        {
            return new ResponseEntity<>(
                    "El canal no puede ser eliminado ya que existen QR asociados a este",
                    HttpStatus.CONFLICT);
        }
        else {
            canalesRepository.deleteById(IdCanal);
            return new ResponseEntity<>(
                    "Se ha eliminado el canal " + IdCanal,
                    HttpStatus.OK);
        }

    }


    @GetMapping("/canalesxtipo")
    public List<ICanalesTipoCanales> getCanalesXTipo()
            throws ResourceNotFoundException {
        return canalesRepository.obtenerCanalXTiposTodos();
    }
}
