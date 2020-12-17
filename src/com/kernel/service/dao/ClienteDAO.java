package com.kernel.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kernel.service.conexion.Conexion;
import com.kernel.service.model.Cliente;
import com.kernel.service.model.Direccion;
import com.mysql.cj.protocol.Resultset;

public class ClienteDAO {

	private static Conexion con;
	private static Connection connection;

	public ClienteDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
		con.conectar();
		System.out.println(con.getJdbcConnection());
	}

	public String validaUsuario(String nombre, String contrasenia) {
		System.out.println("Entro a validacion");

		Statement stm;
		String UsuarioSess = null;
		String sql = "SELECT nombre FROM clientes where nombre = '" + nombre + "' and contrasenia = '" + contrasenia + "'";
		try {
			con.conectar();
			connection = con.getJdbcConnection();
			stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				UsuarioSess = rs.getString(1);
			System.out.println("UsuarioSes: " + UsuarioSess);
			}else {
				UsuarioSess = null;
				System.out.println("No se encuentra el usuario");
			}
			stm.close();
			con.desconectar();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ek metodo validaUsuario() UsuarioSes = " + UsuarioSess);
			e.printStackTrace();
		}
		System.out.println("return metodo validaUsuario: " + UsuarioSess);
		return UsuarioSess;
	}
	
	public static int obtenerIdDireccion() {
		System.out.println("Entro a obtnener id en DAO");
		int idDireccion = 0;
		try {
		String sql = "select max(idDireccion) idDireccion from direcciones";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement stm = connection.createStatement();
		Resultset res = (Resultset) stm.executeQuery(sql);
		System.out.println("Resultset = " + ((ResultSet) res).next());
		
		idDireccion = ((ResultSet) res).getInt("idDireccion");
		System.out.println("idDireccion: " + idDireccion);
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("idDireccion: " + idDireccion);
			System.out.println("Error al obtener id del DAO: " + e);
		}
		return idDireccion;
	}
	public boolean elimDireccion() {
		boolean elimDir = false;
		int idDireccion = obtenerIdDireccion();
		try {
		String sql = "DELETE FROM Direcciones WHERE idDireccion = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println("id de direccion a eliminar: " + idDireccion);
		statement.setInt(1, idDireccion);
		System.out.println("Statement" + statement);
 
		elimDir = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error al eliminar en ClienteDAO.elimDireccion())");
			e.printStackTrace();
		}
 
		return elimDir;
	}

	public boolean registrar(Cliente cl) throws SQLException {
		/*
		 * String sql =
		 * "INSERT clientes (idCliente, nombre, apellido, contrasenia, idDireccion) VALUES (null,'"
		 * + cl.getNombre() + "','" + cl.getApellido() + "','" + cl.getContrasenia() +
		 * "'," + cl.getIdDireccion() + ")";
		 */
		System.out.println("Entro al metodo registrar DAO" );
		int idDireccion = obtenerIdDireccion();
		String sql = "insert into clientes (idCliente, nombre, apellido, contrasenia, idDireccion) values ( ?, ?, ?, ?, ?)";
		boolean estado = false;
		PreparedStatement statement;
		try {
			con.conectar();
			connection = con.getJdbcConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, cl.getNombre());
			statement.setString(3, cl.getApellido());
			statement.setString(4, cl.getContrasenia());
			statement.setInt(5, idDireccion);
			
			estado = statement.executeUpdate() > 0;
			
			statement.close();
			con.desconectar();
			System.out.println("Dato insertado correctamente DAO");
		} catch (Exception e) {
			// TODO: handle exception
			estado = false;
			System.out.println("Error al insertar Cliente DAO");
		}
		return estado;
	}
	
	public boolean registrarDir(Direccion dir) {
		
		System.out.println("Entro a metodo registrar direccion DAO");
		String sql = "insert into direcciones (idDireccion, calle, numeroExterior, codigoPostal, estado, referencia) values (?, ?, ?, ?, ?, ?)";
		boolean estado = false;
		PreparedStatement statement;
		try {
			con.conectar();
			connection = con.getJdbcConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, dir.getCalle());
			statement.setString(3, dir.getNumeroExterior());
			statement.setInt(4, dir.getCodigoPostal());
			statement.setString(5, dir.getEstado());
			statement.setString(6, dir.getReferencia());
			
			estado = statement.executeUpdate() > 0;
			
			statement.close();
			con.desconectar();
			System.out.println("Direccion insertado correctamente DAO");
		} catch (Exception e) {
			// TODO: handle exception
			estado = false;
			System.out.println("Error al insertar Direccion DAO");
		}
		return estado;
	}

	public Cliente mostrarClientesId(int id) throws SQLException {
		System.out.println("Entro al metodo mostrar clienteDir por id del DAO");
		Cliente cliente = null;
		String sql = "select cl.idCliente, cl.nombre, cl.apellido, cl.contrasenia, dir.idDireccion, \r\n" + 
				"dir.calle, dir.numeroExterior, dir.codigoPostal, dir.estado, dir.referencia\r\n" + 
				"from clientes cl, direcciones dir\r\n" + 
				"where dir.idDireccion = cl.idDireccion\r\n" + 
				"and idCliente = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, id);
		
		ResultSet resul = stm.executeQuery();
		if (resul.next()) {
			cliente = new Cliente( resul.getInt("idCliente"), resul.getString("nombre"), resul.getString("apellido"), resul.getString("contrasenia"), 
					resul.getInt("idDireccion"), resul.getString("calle"), resul.getString("numeroExterior"), resul.getInt("codigoPostal"), 
							resul.getString("estado"), resul.getString("referencia"));
			System.out.println("ClienteDir  BD DAO: " + cliente);
		}
		stm.close();
		con.desconectar();
		System.out.println("Manda cliente del metodo Mostrar clientes del DAO");
		return cliente;
	}
	
	public List<Cliente> mostrarClientesDir() throws SQLException{
		System.out.println("Entro al metodo mostrarClientesDir en DAO");
		List<Cliente> listClietesDir = new ArrayList<Cliente>();
		String sql = "select cl.idCliente, cl.nombre, cl.apellido, cl.contrasenia, dir.idDireccion, \r\n" + 
				"dir.calle, dir.numeroExterior, dir.codigoPostal, dir.estado, dir.referencia\r\n" + 
				"from clientes cl, direcciones dir\r\n" + 
				"where dir.idDireccion = cl.idDireccion";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement stat = connection.createStatement();
		ResultSet resul = stat.executeQuery(sql);
		
		while (resul.next()) {
			int idCliente = resul.getInt("idCliente");
			String nombre = resul.getString("nombre");
			String apellido = resul.getString("apellido");
			String contrasenia = resul.getString("contrasenia");
			int idDireccion = resul.getInt("idDireccion");
			String calle = resul.getString("calle");
			String numeroExterior = resul.getString("numeroExterior");
			int codigoPostal = resul.getInt("codigoPostal");
			String estado = resul.getString("estado");
			String referencia = resul.getString("referencia");
			Cliente cliente = new Cliente(idCliente, nombre, apellido, contrasenia, idDireccion, calle, numeroExterior, codigoPostal, estado, referencia);
			listClietesDir.add(cliente);
			System.out.println("calle" + calle);
		}
		System.out.println("ClientesDir del DAO: " + listClietesDir);
		con.desconectar();
		System.out.println("Manda ClientesDir del metodo Mostrar clientesDir del DAO");
		return listClietesDir;
	}
	
	public List<Direccion> mostrarDireccion() throws SQLException{
		System.out.println("Entro al metodo mostrar Direcciones en cliente.jsp del DAO");
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
	
	public boolean actualizarCD(Cliente cliente) {
		System.out.println("Entrando al metodo actualizar del DAO");
		boolean estatus = false;
		try {
			
		String sql = "UPDATE direcciones as dir INNER JOIN CLIENTES as cl ON dir.idDireccion = cl.idDireccion\r\n" + 
				"SET cl.nombre = ?, cl.apellido = ?, cl.contrasenia = ?, dir.calle = ?,\r\n" + 
				"dir.numeroExterior = ?, dir.codigoPostal = ?, dir.estado = ?, dir.referencia = ?\r\n" + 
				"where cl.idCliente = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellido());
		statement.setString(3, cliente.getContrasenia());
		statement.setString(4, cliente.getCalle());
		statement.setString(5, cliente.getNumeroExterior());
		statement.setInt(6, cliente.getCodigoPostal());
		statement.setString(7, cliente.getEstado());
		statement.setString(8, cliente.getReferencia());
		statement.setInt(9, cliente.getIdCliente());
		
		estatus = statement.executeUpdate() > 0;
		System.out.println("Statement DAO: " + statement);
		System.out.println("Cliente actualizado Correctamene en DAO");
		statement.close();
		con.desconectar();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al actualizar cliente en DAO: " + e);
			e.printStackTrace();
		}
		return estatus;
	}
	
	public boolean elimCliente(int idCliente) {
		boolean eliminarCl = false;
		try {
		String sql = "DELETE dir, cl FROM Direcciones AS dir INNER JOIN Clientes AS cl\r\n" + 
				"WHERE dir.idDireccion=cl.idDireccion AND cl.idCliente = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println("id del cliente a eliminar: " + idCliente);
		statement.setInt(1, idCliente);
		System.out.println("Statement" + statement);
 
		eliminarCl = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error al eliminar en ClienteDAO.elimCliente()");
			e.printStackTrace();
		}
 
		return eliminarCl;
	}
	
	
}
