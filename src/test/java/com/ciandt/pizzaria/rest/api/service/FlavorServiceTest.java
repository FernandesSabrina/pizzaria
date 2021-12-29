package com.ciandt.pizzaria.rest.api.service;

import com.ciandt.pizzaria.rest.api.repository.FlavorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.ciandt.pizzaria.rest.api.exception.FlavorException;
import com.ciandt.pizzaria.rest.api.model.Flavor;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_flavor_test.sql")
public class FlavorServiceTest {

    @Autowired
    private FlavorService flavorService;

    @Autowired
    private FlavorRepository flavorRepository;

    @Test
    public void saveTest() throws FlavorException {
        Flavor flavorEntity = new Flavor();
        flavorEntity.setNameFlavor("Bacon");
        flavorEntity.setDescription("bacon, azeitona");
        flavorEntity.setPrice(45.46);
        flavorRepository.save(flavorEntity);
        assertNotNull(flavorEntity.getIdFlavor());
    }

    @Test
    public void findByIdTest() throws FlavorException {
        Integer idFlavor = 1;
        Flavor flavorEntity = flavorService.findById(idFlavor);
        assertEquals("Chuchu", flavorEntity.getNameFlavor());
        assertEquals("bacon e chuchu", flavorEntity.getDescription());
    }

    @Test
    public void updateTest() throws FlavorException {
        Flavor flavor = new Flavor();
        flavor.setIdFlavor(1);
        flavor.setNameFlavor("Bacon com catupiry");
        flavor.setDescription("bacon, azeitona e catupiry");
        flavor.setPrice(48.46);
        flavorService.update(flavor);
        Flavor flavorEntity = flavorService.findById(flavor.getIdFlavor());
        assertEquals("Bacon com catupiry", flavorEntity.getNameFlavor());
        assertEquals("bacon, azeitona e catupiry", flavorEntity.getDescription());
    }

    @Test
    public void deleteTest() throws FlavorException {
        Integer idFlavor = 1;
        flavorService.delete(idFlavor);
        Optional<Flavor> optionalFlavor = flavorRepository.findById(idFlavor);
        assertFalse(optionalFlavor.isPresent());
    }
}
