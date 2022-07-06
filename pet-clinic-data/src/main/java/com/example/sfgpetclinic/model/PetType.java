package com.example.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "types")
@SuperBuilder
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
