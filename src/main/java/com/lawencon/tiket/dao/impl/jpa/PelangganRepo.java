package com.lawencon.tiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.model.Pelanggan;

@Repository
public interface PelangganRepo extends JpaRepository<Pelanggan, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE pelanggan set nama = :namaParam where pelanggan_id = :idParam", nativeQuery = true)
	int update(@Param("namaParam") String nama, @Param("idParam") long id);
}
