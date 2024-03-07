package com.coderdot.repository;

import com.coderdot.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByNomRole(String nomRole);


    @Component
    public class DataInitializer {
        private final RoleRepository roleRepository;

        @Autowired
        public DataInitializer(RoleRepository roleRepository) {
            this.roleRepository = roleRepository;
            initializeRoles();
        }

        private void initializeRoles() {
            // Check if roles already exist
            if (roleRepository.count() == 0) {
                // Populate initial roles
                Role manager = new Role();
                manager.setNomRole("Manager");
                manager.setDescriptionRole("Responsible for managing teams and projects.");

                Role dataScientist = new Role();
                dataScientist.setNomRole("Data Scientist");
                dataScientist.setDescriptionRole("Analyzes complex data to inform business decisions.");

                Role accountant = new Role();
                accountant.setNomRole("Accountant");
                accountant.setDescriptionRole("Manages financial records and transactions.");

                Role auditor = new Role();
                auditor.setNomRole("Auditor");
                auditor.setDescriptionRole("Conducts financial audits to ensure compliance.");

                Role projectManager = new Role();
                projectManager.setNomRole("Project Manager");
                projectManager.setDescriptionRole("Plans and oversees project execution.");

                roleRepository.saveAll(Arrays.asList(manager, dataScientist, accountant, auditor, projectManager));
            }
        }
    }
}
