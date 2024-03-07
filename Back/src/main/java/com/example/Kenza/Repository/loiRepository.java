package com.example.Kenza.Repository;

import com.example.Kenza.entity.Loi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loiRepository extends JpaRepository<Loi, Long> {}
