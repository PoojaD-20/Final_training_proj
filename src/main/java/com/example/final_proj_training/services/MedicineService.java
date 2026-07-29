package com.example.final_proj_training.services;

import java.util.List;

import com.example.final_proj_training.dtos.MedicineRequest;
import com.example.final_proj_training.dtos.MedicineResponse;

public interface MedicineService {
	
	MedicineResponse createMedicine(MedicineRequest request, int user_id);

    List<MedicineResponse> getAllMedicines(int user_id);

    MedicineResponse getMedicineById(int id, int user_id);

    MedicineResponse updateMedicine(int id, MedicineRequest request, int user_id);

    void deleteMedicine(int id, int user_id);

    List<MedicineResponse> getLowStockMedicines(int user_id);

    List<MedicineResponse> getExpiredMedicines(int user_id);

    List<MedicineResponse> getMedicinesByCategory(int category_id, int user_id);
	

}
