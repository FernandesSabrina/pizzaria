package com.ciandt.pizzaria.rest.api.repository;

import com.ciandt.pizzaria.rest.api.model.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlavorRepository extends JpaRepository<Flavor, Integer> {
    Optional<Flavor> findByNameFlavor(String nameFlavor);
}
