package com.kernel.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kernel.service.conexion.Conexion;
import com.kernel.service.model.Direccion;
import com.mysql.cj.protocol.Resultset;

public class DireccionDAO {
	
	private Conexion con;
	private Connection connection;

	public DireccionDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
		con.conectar();
		System.out.println(con.getJdbcConnection());
	}
	
	public List<Direccion> mostrarDireccion() throws SQLException{
		System.out.println("Entro al metodo mostrar Direcciones del DAO");
		List<Direccion> listDireccion = new ArrayList<Direccion>();
		String sql = "select * from direcciones";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement stat = connection.createStatement();
		Resultset resul = (Resultset) stat.executeQuery(sql);
		
		while (((ResultSet) resul).next()) {
			int idDireccion = ((ResultSet) resul).getInt("idDireccion");
			String calle = ((ResultSet) resul).getString("calle");
			String numeroExterior = ((ResultSet) resul).getString("numeroExterior");
			int codigoPostal = ((ResultSet) resul).getInt("codigoPostal");
			String estado = ((ResultSet) resul).getString("estado");
			String referencia = ((ResultSet) resul).getString("referencia");
			Direccion direccion = new Direccion(idDireccion, calle, numeroExterior, codigoPostal, estado,referencia);
			listDireccion.add(direccion);
		}
		con.desconectar();
		System.out.println("Manda direcciones del metodo Mostrar clientes del DAO");
		return listDireccion;
	}

}
