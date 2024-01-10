package com.pract.classicmodels.dtos;

public class BancoDTO {

	private String numeroCuenta;
	private float saldo;
	


	public BancoDTO(String numeroCuenta, float saldo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

    
	public String geNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public float geSaldo() {
		return saldo;
	}

	public void setNumeroCuenta(float saldo) {
		this.saldo = saldo;
	}

}
