package com.example.sfgpetclinic.repositories;

import com.example.sfgpetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findByLastNameLike(String lastName);
}
