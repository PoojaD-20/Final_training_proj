package com.example.final_proj_training.serv_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_proj_training.dtos.MedicineRequest;
import com.example.final_proj_training.dtos.MedicineResponse;
import com.example.final_proj_training.enums.MedicineStatus;
import com.example.final_proj_training.exceptions.ResourceNotFoundException;
import com.example.final_proj_training.models.Medicine;
import com.example.final_proj_training.repositories.CategoryRepository;
import com.example.final_proj_training.repositories.MedicineRepository;
import com.example.final_proj_training.services.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
    public MedicineResponse createMedicine(MedicineRequest request, int user_id) {

        categoryRepository.findById(request.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Medicine medicine = new Medicine();

        medicine.setName(request.getName());
        medicine.setPrice(request.getPrice());
        medicine.setQuantity(request.getQuantity());
        medicine.setExpiryDate(request.getExpiryDate());
        medicine.setCategory_id(request.getCategory_id());
        medicine.setUser_id(user_id);

        medicine.updateStatus();

        Medicine saved = medicineRepository.save(medicine);

        return mapToResponse(saved);
    }

    @Override
    public List<MedicineResponse> getAllMedicines(int user_id) {

        return medicineRepository.findByUserId(user_id)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public MedicineResponse getMedicineById(int id, int user_id) {

        Medicine medicine = medicineRepository
                .findByIdAndUserId(id, user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found"));

        return mapToResponse(medicine);
    }

    @Override
    public MedicineResponse updateMedicine(int id, MedicineRequest request, int user_id) {

        Medicine medicine = medicineRepository
                .findByIdAndUserId(id, user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found"));

        categoryRepository.findById(request.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        medicine.setName(request.getName());
        medicine.setPrice(request.getPrice());
        medicine.setQuantity(request.getQuantity());
        medicine.setExpiryDate(request.getExpiryDate());
        medicine.setCategory_id(request.getCategory_id());

        medicine.updateStatus();

        Medicine updated = medicineRepository.save(medicine);

        return mapToResponse(updated);
    }

    @Override
    public void deleteMedicine(int id, int user_id) {

        Medicine medicine = medicineRepository
                .findByIdAndUserId(id, user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found"));

        medicine.setDeleted(true);

        medicineRepository.save(medicine);
    }

    @Override
    public List<MedicineResponse> getLowStockMedicines(int user_id) {

        return medicineRepository.findByUserId(user_id)
                .stream()
                .filter(m -> m.getStatus() == MedicineStatus.LOW_STOCK)
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<MedicineResponse> getExpiredMedicines(int user_id) {

        return medicineRepository.findByUserId(user_id)
                .stream()
                .filter(m -> m.getStatus() == MedicineStatus.EXPIRED)
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<MedicineResponse> getMedicinesByCategory(int category_id, int user_id) {

        return medicineRepository
                .findByCategoryIdAndUserId(category_id, user_id)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private MedicineResponse mapToResponse(Medicine medicine) {

        return new MedicineResponse(
                medicine.getId(),
                medicine.getName(),
                medicine.getPrice(),
                medicine.getQuantity(),
                medicine.getExpiryDate(),
                medicine.getStatus(),
                medicine.getCategory_id()
        );
    }

}
