package com.ciandt.pizzaria.rest.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "flavor")
public class Flavor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idFlavor;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank(message = "name is not blank")
    public String nameFlavor;

    @Column(nullable = false, length = 150)
    public String description;

    @Column(nullable = false)
    public Double price;

    public Integer getIdFlavor() {
        return idFlavor;
    }

    public void setIdFlavor(Integer idFlavor) {
        this.idFlavor = idFlavor;
    }

    public String getNameFlavor() {
        return nameFlavor;
    }

    public void setNameFlavor(String nameFlavor) {
        this.nameFlavor = nameFlavor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
