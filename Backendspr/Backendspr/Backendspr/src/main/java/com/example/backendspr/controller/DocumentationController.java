package com.example.backendspr.controller;

import com.example.backendspr.models.Documentation;
import com.example.backendspr.service.ServiceDocumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:4200")
@RestController
public class DocumentationController {
    @Autowired
    ServiceDocumentation serviceDocumentation;
    @GetMapping("findallDoc")
    public List<Documentation> getAllExercices() {
        return serviceDocumentation.findAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Documentation> getDocumentationById(@PathVariable long id) {
        Optional<Documentation> exercice = serviceDocumentation.findById(id);
        return exercice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("adddocumentation")
    public ResponseEntity<Documentation> adddoc(@RequestBody Documentation documentation) {

        Documentation newdoc = serviceDocumentation.adddocumentaion(documentation);
        return new ResponseEntity<>(newdoc, HttpStatus.CREATED);
    }


    @PutMapping("update-doc/{id}")
    public Documentation updatedoc(@RequestBody Documentation documentation,@PathVariable("id")Long id){

        return serviceDocumentation.updatedocumentation(documentation,id);
    }
    @DeleteMapping("delete-doc/{id}")
    public ResponseEntity<Void> deletedocumentation(@PathVariable long id) {
        serviceDocumentation.removedocumentation(id);
        return ResponseEntity.noContent().build();
    }
}
