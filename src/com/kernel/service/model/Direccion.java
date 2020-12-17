package com.kernel.service.model;

public class Direccion {
	
	private int idDireccion;
	private String calle;
	private String numeroExterior;
	private int codigoPostal;
	private String estado;
	private String referencia;
	
	public Direccion(int idDireccion, String calle, String numeroExterior, int codigoPostal, String estado,
			String referencia) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numeroExterior = numeroExterior;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
		this.referencia = referencia;
	}

	public Direccion() {
		super();
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", numeroExterior=" + numeroExterior
				+ ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", referencia=" + referencia + "]";
	}
	
	

}
