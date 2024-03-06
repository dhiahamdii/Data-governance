package com.example.backendspr.service;

import com.example.backendspr.models.Documentation;

import java.util.List;
import java.util.Optional;

public interface IServiceDocumentation {
    Documentation adddocumentaion (Documentation documentation);
    Documentation updatedocumentation(Documentation documentation,Long id);
    void removedocumentation (long id);
    List<Documentation> findAll();
    Optional<Documentation> findById(long id);
}
