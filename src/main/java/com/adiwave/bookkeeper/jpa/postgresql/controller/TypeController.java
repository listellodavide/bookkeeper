package com.adiwave.bookkeeper.jpa.postgresql.controller;

import com.adiwave.bookkeeper.jpa.postgresql.model.Typename;
import com.adiwave.bookkeeper.jpa.postgresql.services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping("/types")
    public List<Typename> getTypes() {
        return typeService.getTypesAll();
    }

    @GetMapping("/types/{id}")
    public Optional<Typename> getTypeId(@PathVariable Long id) {
        return typeService.getTypeId(id);
    }

    @PostMapping("/types")
    public Typename addType(@RequestBody Typename type) {
        return typeService.addType(type);
    }

    @PutMapping("/types")
    public Typename editType(@RequestBody Typename type) throws Exception {
        return typeService.editType(type);
    }

    @DeleteMapping("types/{id}")
    public void deleteTypeId(@RequestParam Long id) {
        typeService.deleteTypeById(id);
    }
}
