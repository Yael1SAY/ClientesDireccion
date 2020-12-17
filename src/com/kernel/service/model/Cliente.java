package com.kernel.service.model;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private int idDireccion;
	private String calle;
	private String numeroExterior;
	private int codigoPostal;
	private String estado;
	private String referencia;
	
	public Cliente(int idCliente, String nombre, String apellido, String contrasenia, int idDireccion) {
		//super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.idDireccion = idDireccion;
	}


	public Cliente(int idCliente, String nombre, String apellido, String contrasenia, int idDireccion, String calle,
			String numeroExterior, int codigoPostal, String estado, String referencia) {
		//super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numeroExterior = numeroExterior;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
		this.referencia = referencia;
	}


	public Cliente(String nombre, String contrasenia) {
		//super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}
	
	public Cliente() {
		
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



	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", contrasenia="
				+ contrasenia + ", idDireccion=" + idDireccion + ", calle=" + calle + ", numeroExterior="
				+ numeroExterior + ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", referencia="
				+ referencia + "]";
	}
	
}
