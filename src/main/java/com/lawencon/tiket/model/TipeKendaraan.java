package com.lawencon.tiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipe_kendaraan")
public class TipeKendaraan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipeId;
	private String jenisKendaraan;
	private int harga;

	public Long getTipeId() {
		return tipeId;
	}

	public void setTipeId(Long tipeId) {
		this.tipeId = tipeId;
	}

	public String getJenisKendaraan() {
		return jenisKendaraan;
	}

	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

}
