package com.example.Kenza.Service;

import com.example.Kenza.Repository.DocumentationRepository;

import com.example.Kenza.Repository.RegleRepository;
import com.example.Kenza.Repository.loiRepository;
import com.example.Kenza.entity.Documentation;
import com.example.Kenza.entity.Loi;
import com.example.Kenza.entity.Regle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


@Service
public class DocumentationService implements IDocumentationService{

    @Autowired
    DocumentationRepository documentationRepository;

    @Autowired
    loiRepository loiRepository;
    @Autowired
    RegleRepository regleRepository;
    @Override
    public Documentation saveDocumentation(Documentation documentation) {
        // Your logic to read loi names from a file
        documentation.setFichier(documentation.getFichier().substring(12));
        documentationRepository.save(documentation);
        try {
            InputStream inputStream = getClass().getResourceAsStream("/"+documentation.getFichier());// fichier
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String loiName = null;
            String regleName = null;
            StringBuilder regleContenu = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into key and value
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "loiName":
                            // Save the previous Documentation if loiName is not null
                            if (loiName != null) {
                                documentationRepository.save(documentation);
                            }
                            loiName = value;
                            break;
                        case "RegleName":
                            regleName = value;
                            break;
                        case "RegleContenu":
                            regleContenu.append(value);
                            break;
                    }
                }

                // Check if the end of the file is reached
                boolean endOfFile = (line == null);

                // When a blank line is encountered or the end of the file is reached, it indicates the end of a rule entry
                if ((line.trim().isEmpty() && loiName != null && regleName != null) || endOfFile) {
                    // Create Loi and Rule objects and associate them with the documentation
                    Loi loi = new Loi(); // new loi
                    loi.setName(loiName); // loiname
                    loi.setDocumentation(documentation);// affectation lil documentation

                    Regle regle = new Regle(); // new regle
                    regle.setNom(regleName); // name
                    regle.setContenu(regleContenu.toString()); // contenu

                    regle.setLoi(loi); // aff regle lil loi

                    loiRepository.save(loi);
                    regleRepository.save(regle);

                    // Reset variables for the next entry
                    loiName = null;
                    regleName = null;
                    regleContenu = new StringBuilder();
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return  documentation ;
    }


    @Override
    public Documentation getDocumentation(Long id) {
        return documentationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Documentation> getAllDocumentations() {
        return documentationRepository.findAll();
    }

    @Override
    public void deleteDocumentation(Long id) {
        documentationRepository.deleteById(id);
    }

    @Override
    public void updateDocumenation(Documentation documentation, Long id) {
        Documentation existingDocumentation = documentationRepository.findById(id).get();

        existingDocumentation.setLabel(documentation.getLabel());

        existingDocumentation.setType(documentation.getType());
        existingDocumentation.setFichier(documentation.getFichier());
        documentationRepository.save(existingDocumentation);
    }
}