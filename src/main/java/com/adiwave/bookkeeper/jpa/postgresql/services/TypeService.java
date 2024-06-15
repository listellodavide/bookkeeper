package com.adiwave.bookkeeper.jpa.postgresql.services;

import com.adiwave.bookkeeper.jpa.postgresql.model.Typename;

import com.adiwave.bookkeeper.jpa.postgresql.repository.Typenamepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final Typenamepository typenamepository;

    public TypeService(Typenamepository typenamepository) {
        this.typenamepository = typenamepository;
    }

    public List<Typename> getTypesAll() {
        return typenamepository.findAll();
    }

    public Optional<Typename> getTypeId(Long id) {
        return typenamepository.findById(id);
    }

    public Typename addType(Typename type) {
        return typenamepository.save(type);
    }

    @Transactional
    public Typename editType(Typename type) throws Exception {
        Typename typeEdit = typenamepository.findById(type.getId()).orElseThrow(() -> new Exception("Type not found"));
        typeEdit.setName(type.getName());
        return typeEdit;
    }

    public void deleteTypeById(Long id) {
        typenamepository.deleteById(id);
    }
}
