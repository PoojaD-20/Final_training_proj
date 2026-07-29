package com.example.final_proj_training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_proj_training.dtos.MedicineRequest;
import com.example.final_proj_training.dtos.MedicineResponse;
import com.example.final_proj_training.services.MedicineService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

	@Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<MedicineResponse> createMedicine(@RequestBody MedicineRequest request,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.createMedicine(request, user_id)
        );
    }

    @GetMapping
    public ResponseEntity<List<MedicineResponse>> getAllMedicines(
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.getAllMedicines(user_id)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineResponse> getMedicineById(
            @PathVariable int id,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.getMedicineById(id, user_id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineResponse> updateMedicine(
            @PathVariable int id,
            @RequestBody MedicineRequest request,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.updateMedicine(id, request, user_id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(
            @PathVariable int id,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        medicineService.deleteMedicine(id, user_id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<MedicineResponse>> getLowStockMedicines(
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.getLowStockMedicines(user_id)
        );
    }

    @GetMapping("/expiry")
    public ResponseEntity<List<MedicineResponse>> getExpiredMedicines(
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.getExpiredMedicines(user_id)
        );
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<MedicineResponse>> getMedicinesByCategory(
            @PathVariable int category_id,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                medicineService.getMedicinesByCategory(category_id, user_id)
        );
    }
}
