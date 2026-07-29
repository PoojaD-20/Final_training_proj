package com.example.final_proj_training.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.final_proj_training.enums.MedicineStatus;
import com.example.final_proj_training.models.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{
	
    @Query("""
            SELECT m
            FROM Medicine m
            WHERE m.isDeleted = false
            """)
    List<Medicine> findAllActiveMedicines();

    @Query("""
            SELECT m
            FROM Medicine m
            WHERE m.id = :id
            AND m.isDeleted = false
            """)
    Optional<Medicine> findActiveMedicineById(
            @Param("id") int id
    );

    @Query("""
            SELECT m
            FROM Medicine m
            WHERE m.status = :status
            AND m.isDeleted = false
            """)
    List<Medicine> findByStatus(
            @Param("status") MedicineStatus status
    );

    @Query("""
            SELECT m
            FROM Medicine m
            WHERE m.category_id = :category_id
            AND m.isDeleted = false
            """)
    List<Medicine> findByCategoryId(
            @Param("category_id") int category_id
    );
    
    
    @Query("""
    	       SELECT m
    	       FROM Medicine m
    	       WHERE m.user_id = :user_id
    	       AND m.isDeleted = false
    	       """)
    	List<Medicine> findByUserId(@Param("user_id") int user_id);
    
    
    
    @Query("""
    	       SELECT m
    	       FROM Medicine m
    	       WHERE m.id = :id
    	       AND m.user_id = :user_id
    	       AND m.isDeleted = false
    	       """)
    	Optional<Medicine> findByIdAndUserId(
    	        @Param("id") int id,
    	        @Param("user_id") int user_id
    	);
    
    
    @Query("""
    	       SELECT m
    	       FROM Medicine m
    	       WHERE m.category_id = :category_id
    	       AND m.user_id = :user_id
    	       AND m.isDeleted = false
    	       """)
    	List<Medicine> findByCategoryIdAndUserId(
    	        @Param("category_id") int category_id,
    	        @Param("user_id") int user_id
    	);


        @Query("""
       SELECT m
       FROM Medicine m
       WHERE m.name = :name
       AND m.category_id = :categoryId
       AND m.user_id = :userId
       AND m.isDeleted = false
       """)
Optional<Medicine> findByNameAndCategoryIdAndUserId(
        @Param("name") String name,
        @Param("categoryId") int categoryId,
        @Param("userId") int userId
);

}
