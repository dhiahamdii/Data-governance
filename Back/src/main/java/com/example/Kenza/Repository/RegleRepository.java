package com.example.Kenza.Repository;

import com.example.Kenza.entity.Regle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegleRepository extends JpaRepository<Regle, Long> {}
