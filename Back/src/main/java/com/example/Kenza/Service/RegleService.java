package com.example.Kenza.Service;

import com.example.Kenza.Repository.DocumentationRepository;
import com.example.Kenza.Repository.RegleRepository;
import com.example.Kenza.Repository.loiRepository;
import com.example.Kenza.entity.Regle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegleService implements IRegleService{

    @Autowired
    DocumentationRepository documentationRepository;
    @Autowired
    loiRepository loiRepository;
    @Autowired
    RegleRepository regleRepository;
    @Override
    public Regle saveRegle(Regle regle) {
        return regleRepository.save(regle);
    }
    @Override
    public Regle getRegle(Long id) {
        return regleRepository.findById(id).get();
    }

    @Override
    public List<Regle> getRegleLoi(Long id) {
        return        loiRepository.findById(id).get().getRegles();

    }

    @Override
    public List<Regle> getAllRegles() {
        return regleRepository.findAll();
    }
    @Override
    public void deleteRegle(Long id) {
        regleRepository.deleteById(id);
    }
    @Override
    public void updateRegle(Regle regle, Long id) {
        Regle r = regleRepository.findById(id).get();
        r.setContenu(regle.getContenu());
        r.setNom(regle.getNom());
        regleRepository.save(r);
    }
}