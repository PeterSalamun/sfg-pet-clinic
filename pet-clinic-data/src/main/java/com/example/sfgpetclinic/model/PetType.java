package com.example.sfgpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
@SuperBuilder
public class PetType extends BaseEntity {
    //todo constructor ak bude treba
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
