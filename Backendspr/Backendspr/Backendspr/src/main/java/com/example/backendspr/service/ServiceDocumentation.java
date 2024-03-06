package com.example.backendspr.service;

import com.example.backendspr.models.Documentation;
import com.example.backendspr.repository.DocumentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDocumentation implements IServiceDocumentation{
    @Autowired
    DocumentationRepository documentationRepository;
    @Override
    public Documentation adddocumentaion(Documentation documentation) {
        return documentationRepository.save(documentation);
    }

    @Override
    public Documentation updatedocumentation(Documentation documentation, Long id) {
        Documentation doc= documentationRepository.findById(id).get();
        doc.setDescription(documentation.getDescription());
        doc.setRegle(documentation.getRegle());
        doc.setTypeLoi(documentation.getTypeLoi());
        return documentationRepository.save(documentation);
    }

    @Override
    public void removedocumentation(long id) {
       documentationRepository.deleteById(id);
    }

    @Override
    public List<Documentation> findAll() {
        return documentationRepository.findAll();
    }

    @Override
    public Optional<Documentation> findById(long id) {
        return documentationRepository.findById(id);
    }
}
