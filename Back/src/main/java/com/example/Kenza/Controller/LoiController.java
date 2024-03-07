package com.example.Kenza.Controller;

import com.example.Kenza.Service.ILoiService;
import com.example.Kenza.entity.Loi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Loi")
public class LoiController {
    @Autowired
    ILoiService iLoiService;

    @GetMapping("/{id}")
    public Loi getLoi(@PathVariable Long id) {
        return iLoiService.getLoi(id);
    }
    @GetMapping("/Doc/{id}")
    public Loi getLoiByDoc(@PathVariable Long id) {
        return iLoiService.getLoi(id);
    }
    @GetMapping
    public List<Loi> getAllLois() {

        return iLoiService.getAllLois();
    }

    @PutMapping("/{id}")
    public Void updateLoi(@RequestBody Loi Loi, @PathVariable Long id) {
        iLoiService.updateLoi(Loi, id);

        return null;
    }

    @DeleteMapping("/{id}")
    public Void deleteLoi(@PathVariable Long id) {
        iLoiService.deleteLoi(id);
        return null;

    }
}