package com.lawencon.tiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diskon")
public class Diskon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long diskonId;
	private float diskon;

	public Long getDiskonId() {
		return diskonId;
	}

	public void setDiskonId(Long diskonId) {
		this.diskonId = diskonId;
	}

	public float getDiskon() {
		return diskon;
	}

	public void setDiskon(float diskon) {
		this.diskon = diskon;
	}

}
