package com.example.backendspr.repository;

import com.example.backendspr.models.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentationRepository extends JpaRepository<Documentation,Long> {
}
