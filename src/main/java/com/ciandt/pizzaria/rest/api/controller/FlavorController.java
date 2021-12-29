package com.ciandt.pizzaria.rest.api.controller;

import com.ciandt.pizzaria.rest.api.dto.ErrorDTO;
import com.ciandt.pizzaria.rest.api.exception.FlavorException;
import com.ciandt.pizzaria.rest.api.model.Flavor;
import com.ciandt.pizzaria.rest.api.service.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/flavor")
public class FlavorController {

    @Autowired
    private FlavorService flavorService;

    @GetMapping(path = "/{idFlavor}")
    public ResponseEntity consultFlavor(@PathVariable(name = "idFlavor", required = true) Integer idFlavor) throws FlavorException {
        return ResponseEntity.ok(flavorService.findById(idFlavor));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(flavorService.findAll());
    }

    @PostMapping
        public ResponseEntity salve(@Valid
            @RequestBody Flavor flavor, BindingResult result) throws FlavorException {

        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(createErroDTO(result));
        }
        flavorService.save(flavor);

        URI uri = URI.create("/api/flavor/"+flavor.getIdFlavor());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
        public ResponseEntity update(@RequestBody Flavor flavor) throws FlavorException {
        flavorService.update(flavor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{idFlavor}")
    public ResponseEntity delete(@PathVariable(name = "idFlavor", required = true) Integer idFlavor) throws FlavorException {
        flavorService.delete(idFlavor);
        return ResponseEntity.noContent().build();
    }

    private ErrorDTO createErroDTO(BindingResult result){
        return new ErrorDTO(400, result.getFieldError().getDefaultMessage(), result.getFieldError().getField());
    }
}
