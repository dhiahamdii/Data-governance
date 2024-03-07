package com.example.Kenza.Repository;

import com.example.Kenza.entity.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentationRepository extends JpaRepository<Documentation,Long> {


}
