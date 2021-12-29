package com.ciandt.pizzaria.rest.api.service;

import com.ciandt.pizzaria.rest.api.exception.FlavorException;
import com.ciandt.pizzaria.rest.api.model.Flavor;
import com.ciandt.pizzaria.rest.api.repository.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlavorServiceImpl implements FlavorService {

    @Autowired
    private FlavorRepository flavorRepository;

    @Override
    public Flavor findById(Integer idFlavor) throws FlavorException {
        return hasIdFlavor(idFlavor);
    }

    @Override
    public List<Flavor> findAll() {
        return flavorRepository.findAll();
    }

    @Override
    public void save(Flavor flavor) throws FlavorException {
        hasNameFlavor(flavor.getNameFlavor());
        flavorRepository.save(flavor);
    }

    @Override
    public void update(Flavor flavor) throws FlavorException {
        Flavor flavorEntity= hasIdFlavor(flavor.getIdFlavor());
        if(!flavorEntity.getNameFlavor().equals(flavor.getNameFlavor())){
            hasNameFlavor(flavor.getNameFlavor());
        }
        flavorRepository.save(flavor);
    }

    @Override
    public void delete(Integer idFlavor) throws FlavorException {
        hasIdFlavor(idFlavor);
        flavorRepository.deleteById(idFlavor);
    }

    private Flavor hasIdFlavor(Integer idFlavor) throws FlavorException {
        Optional<Flavor> optionalFlavor= flavorRepository.findById(idFlavor);
        Flavor flavor = new Flavor();
        if(!optionalFlavor.isPresent()){
            throw new FlavorException(String.format("Flavor with id %s does not exist", idFlavor));
        }else{
            flavor= optionalFlavor.get();
        }
        return flavor;
    }

    private void hasNameFlavor(String nameFlavor) throws FlavorException {
        if(flavorRepository.findByNameFlavor(nameFlavor).isPresent()){
            throw new FlavorException(String.format("Flavor with name %s already existing", nameFlavor));
        }
    }
}
