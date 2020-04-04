package com.lawencon.tiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pelangganId;
	private String nama;

	public Long getPelangganId() {
		return pelangganId;
	}

	public void setPelangganId(Long pelangganId) {
		this.pelangganId = pelangganId;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}
