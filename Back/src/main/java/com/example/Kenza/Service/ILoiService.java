package com.example.Kenza.Service;

import com.example.Kenza.entity.Loi;

import java.util.List;

public interface ILoiService {


    Loi getLoi(Long id);
    List<Loi> getLoidoc(Long id);

        List<Loi> getAllLois();

    void deleteLoi(Long id);

    void updateLoi(Loi Loi,Long id);
    }

