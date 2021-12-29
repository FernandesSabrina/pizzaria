package com.ciandt.pizzaria.rest.api.service;

import com.ciandt.pizzaria.rest.api.exception.FlavorException;
import com.ciandt.pizzaria.rest.api.model.Flavor;

import java.util.List;

public interface FlavorService {

    Flavor findById(Integer idFlavor) throws FlavorException;
    List<Flavor> findAll();
    void save(Flavor flavor) throws FlavorException;
    void update(Flavor flavor) throws FlavorException;
    void delete(Integer idFlavor) throws FlavorException;

}
