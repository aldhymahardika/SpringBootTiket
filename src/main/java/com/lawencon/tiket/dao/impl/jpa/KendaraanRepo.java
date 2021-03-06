package com.lawencon.tiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.model.TipeKendaraan;

@Repository
public interface KendaraanRepo extends JpaRepository<TipeKendaraan, Long>{
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE tipe_kendaraan set harga = :hargaParam where tipe_id = :idParam", nativeQuery = true)
	int update(@Param("hargaParam") int harga, @Param("idParam") long id);
}
