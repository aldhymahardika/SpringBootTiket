package com.lawencon.tiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;
	private String kotaAsal;
	private String kotaTujuan;
	private String tglBerangkat;
	private int totalTiket;
	private int totalHarga;

	@ManyToOne
	@JoinColumn(name = "pelangganId")
	private Pelanggan pelanggan;

	@OneToOne
	@JoinColumn(name = "tipeId")
	private TipeKendaraan tipeKendaraan;

	@OneToOne
	@JoinColumn(name = "diskonId")
	private Diskon diskon;

	public int getTransaksiId() {
		return transId;
	}

	public void setTransaksiId(int transId) {
		this.transId = transId;
	}

	public String getKotaAsal() {
		return kotaAsal;
	}

	public void setKotaAsal(String kotaAsal) {
		this.kotaAsal = kotaAsal;
	}

	public String getKotaTujuan() {
		return kotaTujuan;
	}

	public void setKotaTujuan(String kotaTujuan) {
		this.kotaTujuan = kotaTujuan;
	}

	public String getTglBerangkat() {
		return tglBerangkat;
	}

	public void setTglBerangkat(String tglBerangkat) {
		this.tglBerangkat = tglBerangkat;
	}

	public int getTotalTiket() {
		return totalTiket;
	}

	public void setTotalTiket(int totalTiket) {
		this.totalTiket = totalTiket;
	}

	public Pelanggan getPelanggan() {
		return pelanggan;
	}

	public void setPelanggan(Pelanggan pelanggan) {
		this.pelanggan = pelanggan;
	}

	public TipeKendaraan getTipeKendaraan() {
		return tipeKendaraan;
	}

	public void setTipeKendaraan(TipeKendaraan tipeKendaraan) {
		this.tipeKendaraan = tipeKendaraan;
	}

	public Diskon getDiskon() {
		return diskon;
	}

	public void setDiskon(Diskon diskon) {
		this.diskon = diskon;
	}

	public int getTotalHarga() {
		return totalHarga;
	}

	public void setTotalHarga(int totalHarga) {
		this.totalHarga = totalHarga;
	}

}
