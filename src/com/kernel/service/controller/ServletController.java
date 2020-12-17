package com.kernel.service.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kernel.service.dao.ClienteDAO;
import com.kernel.service.model.Cliente;
import com.kernel.service.model.Direccion;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		System.out.println("Accion: " + action);
		switch (action) {
		case "registrar":
			System.out.println("entro a registrar en swith");
			registrarDireccion(request, response);
			if(!registrarCliente(request, response)) {
				eliminarDir(request, response);
			}
			break;
		case "editCliente":
			actualizar(request, response);
			break;
		case "elimCliente":
			System.out.println("entro a eliminar en swith");
			eliminar(request, response);
			break;
		default:
			break;
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean registrarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean estado = false;
		try {
			System.out.println("Entro al metodo registrar Cliente del servlet");
			Cliente cliente = new Cliente(0, request.getParameter("txtNombre"), request.getParameter("txtApellido"),
					request.getParameter("txtContrasenia"), 0);
			System.out.println("Cliente recibido: " + cliente);
			if (clienteDao.registrar(cliente)) {
				request.getSession().setAttribute("msgAgre", "Cliente agregado correctamente");
				System.out.println("El Cliente se ingreso con exito Servlet");
				estado = true;
			} else {
				request.getSession().setAttribute("msgAgre", "Error El cliente no se agrego");
				System.out.println("Error. No se ingreso el Cliente Servlet");
			}

			// RequestDispatcher dispatcher =
			// request.getRequestDispatcher("/vista/inicio.jsp");
			// dispatcher.forward(request, response);
			response.sendRedirect("vista/inicio.jsp");

		} catch (Exception e) {
			System.out.println("Error metodo registrarCliente servlet: " + e);
			e.printStackTrace();
		}
		return estado;

	}

	private void registrarDireccion(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Entro al metodo registrar Direccion del servlet");
			Direccion direccion = new Direccion(0, request.getParameter("txtCalle"),
					request.getParameter("txtNoExterior"), Integer.parseInt(request.getParameter("txtCodPostal")),
					request.getParameter("txtEstado"), request.getParameter("txtReferencia"));
			if (clienteDao.registrarDir(direccion)) {
				System.out.println("La direccion se ingreso con exito");
			} else {
				System.out.println("Error. No se ingreso la nueva direccion");
			}

		} catch (Exception e) {
			System.out.println("Error al registrar cliente servlet: " + e);
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Entro metodo actualizar en servlet");
			Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("txtIdCliente")),
					request.getParameter("txtNombre"), request.getParameter("txtApellido"),
					request.getParameter("txtContrasenia"), 0, request.getParameter("txtCalle"),
					request.getParameter("txtNoExterior"), Integer.parseInt(request.getParameter("txtCodPostal")),
					request.getParameter("txtEstado"), request.getParameter("txtReferencia"));
			System.out.println("Cliente recibido del formulario: " + cliente);

			if (clienteDao.actualizarCD(cliente)) {
				System.out.println("Cliente Actualizado: " + cliente);
				request.getSession().setAttribute("msgEdit", "Cliente actualizado correctamente");
				response.sendRedirect("vista/inicio.jsp");
			} else {
				request.getSession().setAttribute("msgEdit", "Error al actualizar Cliente");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error no es posible actualizar en servlet: " + e);
			e.printStackTrace();
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
			if (clienteDao.elimCliente(idCliente)) {
				request.getSession().setAttribute("msgElim", "Cliente eliminado correctamente");
				response.sendRedirect("index.jsp");
			} else {
				request.getSession().setAttribute("msgElim", "Error al eliminar Cliente");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error no es posible eliminar");
			e.printStackTrace();
		}
	}
	
	private void eliminarDir(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (clienteDao.elimDireccion()) {
				System.out.println("Roll back aplicado correctamente");
			} else {
				System.out.println("error en Roll back");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error no es posible eliminar");
			e.printStackTrace();
		}
	}

}
