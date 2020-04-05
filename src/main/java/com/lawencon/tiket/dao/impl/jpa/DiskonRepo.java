package com.lawencon.tiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.model.Diskon;

@Repository
public interface DiskonRepo extends JpaRepository<Diskon, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Diskon set diskon = :diskonParam where diskon_id = :idParam", nativeQuery=true)
	int update(@Param("diskonParam") float diskon, @Param("idParam") long id);

}
