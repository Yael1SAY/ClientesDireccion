package com.kernel.service.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kernel.service.dao.ClienteDAO;
import com.kernel.service.model.Cliente;
import com.kernel.service.model.Direccion;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteDAO clienteDao;
	// DireccionDAO direccionDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL);
		try {
			clienteDao = new ClienteDAO(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hola Servlet doGet..");

		/*
		 * Cliente cliente = new Cliente(0, "Osmar", "Salinas Santillan", "0000", 3); if
		 * (clienteDao.registrar(cliente)) {
		 * System.out.println("El Cliente se ingreso con exito"); } else {
		 * System.out.println("Error. No se ingreso el Cliente"); }
		 */

		String action = request.getParameter("action");
		System.out.println("Accion: " + action);
		try {
			switch (action) {
			case "inicio":
				irInicio(request, response);
				break;
			case "mostrarClienDir"://cliente.jsp
				mostrarTodo(request, response);
				break;
			case "mostrarDir"://direccion.jsp
				mostrarDir(request, response);
				break;
			case "irNuevoCliente": //nuevoCliente.jsp
				System.out.println("entro al metodo ir nuevoCliente en switch");
				String cadenaNC = "/vista/nuevoCliente.jsp";
				mostrarSoloDir(request, response);
				irVentana(request, response, cadenaNC);
				break;
			case "irNuevaDireccion"://nuevaDireccion.jsp
				String cadenaND = "/vista/nuevaDireccion.jsp";
				irVentana(request, response, cadenaND);
				break;
			case "irActualizarDireccion"://actualizarDir.jsp
				String cadenaAD = "/vista/actualizarDir.jsp";
				irVentana(request, response, cadenaAD);
				break;
			case "mostrarEditCliente"://actualizarCliente.jsp
				String cadenaEdC = "/vista/actualizarCliente.jsp";
				mostrarClienteId(request, response, cadenaEdC);
				break;
			case "mostrarElimCliente"://actualizarCliente.jsp
				String cadenaElC = "/vista/eliminarCliente.jsp";
				mostrarClienteId(request, response, cadenaElC);
				break;
			case "cerrarSesion"://index.jsp
				String cadenaCS = "index.jsp";
				irVentana(request, response, cadenaCS);
				break;
			default:
				break;
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Hola servlet doPost..");

		String nombre = request.getParameter("txtNombre");
		String contrasenia = request.getParameter("txtContrasenia");

		String usuario = clienteDao.validaUsuario(nombre, contrasenia);
		if (usuario != null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("sUsuario", usuario);
			System.out.println("------------Acceso ok----------");
			response.sendRedirect("vista/inicio.jsp");
		} else {
			System.out.println("Usuario o contraseña incorrecto");
			request.getSession().setAttribute("msg", "Usuario o contraseña incorrectos, vuelva a intentarlo");
			response.sendRedirect("index.jsp");
		}

	}
	
	private void cerrrarSesion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		response.sendRedirect("vista/inicio.jsp");
	}
	

	private void irInicio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		response.sendRedirect("vista/inicio.jsp");
	}

	private void irVentana(HttpServletRequest request, HttpServletResponse response, String cadena) {
		try {
			System.out.println("Entro al metodo ir nuevo cliente Servlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher(cadena);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error al acceder a nuevo Cliente" + e);
		}
	}

	/*private void mostrarCliente(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Entro al metodo mostrar del servlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/cliente.jsp");
			List<Cliente> listaClientes = clienteDao.mostrarClientes();
			request.setAttribute("listaClientes", listaClientes);
			System.out.println("Envio lista a jsp" + listaClientes);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}*/
	
	private void mostrarTodo(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Entro al metodo mostrar del servlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/cliente.jsp");
			List<Cliente> listaClientesDir = clienteDao.mostrarClientesDir();
			request.setAttribute("listaClientesDir", listaClientesDir);
			System.out.println("Envio lista a jsp" + listaClientesDir);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
	
	private void mostrarClienteId(HttpServletRequest request, HttpServletResponse response, String cadena) {
		try {
			
			System.out.println("Entro a metodo mostar cliente por id");
			Cliente clienteDir = clienteDao.mostrarClientesId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("clienteDir", clienteDir);
			System.out.println("Cliente enviado al jsp: " + clienteDir);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(cadena);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error no es posible mostrar por id: " + e);
			// TODO: handle exception
		}
	}

	private void mostrarDir(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Entro al metodo mostrarDir del servlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/direccion.jsp");
			System.out.println("Entrando a ventana direccion");
			List<Direccion> listaDirecciones = clienteDao.mostrarDireccion();
			System.out.println("Lista de BD: " + listaDirecciones);
			request.setAttribute("listaDir", listaDirecciones);
			System.out.println("Envio lista a jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
	private void mostrarSoloDir(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Entro al metodo mostrarDir en Cliente.jsp del servlet");
			List<Direccion> listaDirecciones = clienteDao.mostrarDireccion();
			System.out.println("Lista de BD: " + listaDirecciones);
			request.setAttribute("listaDir", listaDirecciones);
			System.out.println("Envio lista a jsp");
		} catch (Exception e) {
			System.out.println("Error metodo mostrarSoloDir()" + e);
		}
	}

	
}
