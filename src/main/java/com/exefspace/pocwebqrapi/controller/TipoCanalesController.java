package com.exefspace.pocwebqrapi.controller;

import com.exefspace.pocwebqrapi.exception.ResourceNotFoundException;
import com.exefspace.pocwebqrapi.model.Canales;
import com.exefspace.pocwebqrapi.model.QRList;
import com.exefspace.pocwebqrapi.model.TipoCanales;
import com.exefspace.pocwebqrapi.repository.CanalesRepository;
import com.exefspace.pocwebqrapi.repository.TipoCanalesRepository;
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
public class TipoCanalesController {
    Logger logger = LoggerFactory.getLogger(TipoCanalesController.class);

    @Autowired
    private TipoCanalesRepository tipoCanalesRepository;

    @Autowired
    private CanalesRepository canalesRepository;

    @GetMapping("/tipocanales")
    public List<TipoCanales> getTipoCanalByIdTipoCanal(@RequestParam(required = false) Integer IdTipoCanal)
            throws ResourceNotFoundException {
        List<TipoCanales> lista = new ArrayList<TipoCanales>();
        if(IdTipoCanal!=null){
            TipoCanales tipoCanales = tipoCanalesRepository.findById(IdTipoCanal).orElseThrow(
                    () -> new ResourceNotFoundException("Evento no encontrado para este ID:: " + IdTipoCanal));
            lista.add(tipoCanales);
        }
        else
        {
            lista=tipoCanalesRepository.findAll();
        }
        return lista;
    }



    @PostMapping("/tipocanales")
    public TipoCanales createTipoCanales(@Valid @RequestBody TipoCanales tipoCanales) {
        logger.info("--------------------------------------------------------");
        logger.info(tipoCanales.toString());
        //estadoDispositivo(eventosIot.getIdDispositivo());
        return tipoCanalesRepository.save(tipoCanales);
    }


    @PutMapping("/tipocanales")
    public ResponseEntity<TipoCanales> updateTipoCanales(@RequestParam Integer IdTipoCanal,
                                                 @Valid @RequestBody TipoCanales tipoCanales) throws ResourceNotFoundException {
        TipoCanales result = tipoCanalesRepository.findById(IdTipoCanal).orElseThrow(
                () -> new ResourceNotFoundException("tipoCanales no encontrado para este id :: " + IdTipoCanal));

        result.setCreationDate(tipoCanales.getCreationDate());
        result.setCreationUser(tipoCanales.getCreationUser());
        result.setUpdateDate(tipoCanales.getUpdateDate());
        result.setUpdateUser(tipoCanales.getUpdateUser());
        result.setDescripcionTipoCanal(tipoCanales.getDescripcionTipoCanal());

        TipoCanales updatedTipoCanales= tipoCanalesRepository.save(result);
        return ResponseEntity.ok(updatedTipoCanales);
    }

    @DeleteMapping("/tipocanales")
    ResponseEntity<String> deleteTipoCanales(@RequestParam Integer IdTipoCanal) {
        Integer conteo = this.canalesRepository.contarCanalesAsociadosATipoCanal(IdTipoCanal);
        if (conteo>0)
        {
            return new ResponseEntity<>(
                    "El tipo de canal no puede ser eliminado ya que existen canales asociados a este",
                    HttpStatus.CONFLICT);
        }
        else {
            tipoCanalesRepository.deleteById(IdTipoCanal);
            return new ResponseEntity<>(
                    "Se ha eliminado el tipo de canal " + IdTipoCanal,
                    HttpStatus.OK);
        }
    }
}
