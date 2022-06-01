package com.example.sfgpetclinic.service.map;

import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.service.CrudService;
import com.example.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return findById(id);
    }
}
