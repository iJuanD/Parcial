package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import modelo.User;
import dao.UserDAO_estudiante;
import modelo.User_estudiante;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private UserDAO_estudiante userDAO_estudiante; 
	
	public void init() {
		userDAO = new UserDAO();
		userDAO_estudiante = new UserDAO_estudiante();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			
			
			case "/new_estudiante":
			showNewForm_estudiante(request, response);
				break;
			case "/insert_estudiante":
				insertUser_estudiante(request, response);
				break;
			case "/delete_estudiante":
				deleteUser_estudiante(request, response);
				break;
			case "/edit_estudiante":
				showEditForm_estudiante(request, response);
				break;
			case "/update_estudiante":
				updateUser_estudiante(request, response);
				break;		
				
				
			case "/listUser":
				listUser(request, response);
				break;
			case "/listUser_estudiante":
				listUser_estudiante(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	// USER DAO_Estudiante
	
	private void listUser_estudiante(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User_estudiante> listUser = userDAO_estudiante.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list2.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm_estudiante(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form2.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm_estudiante(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User_estudiante existingUser = userDAO_estudiante.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form2.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser_estudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String apellido = request.getParameter("apellido");
		String materia = request.getParameter("materia");
		String grupo = request.getParameter("grupo");
		String email = request.getParameter("email");
		User_estudiante newUser = new User_estudiante(name, apellido, materia, grupo, email);
		userDAO_estudiante.insertUser(newUser);
		response.sendRedirect("listUser_estudiante");
	}

	private void updateUser_estudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String apellido = request.getParameter("apellido");
		String materia = request.getParameter("materia");
		String grupo = request.getParameter("grupo");
		String email = request.getParameter("email");
		User_estudiante book = new User_estudiante(id, name, apellido, materia, grupo, email);
		userDAO_estudiante.updateUser(book);
		response.sendRedirect("listUser_estudiante");
	}

	private void deleteUser_estudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO_estudiante.deleteUser(id);
		response.sendRedirect("listUser_estudiante");
	}
	
	// FIN USER DAO_ESTUDIANTE
	

//	USER DAO
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String fecha = request.getParameter("fecha");
		String celular = request.getParameter("celular");
		User newUser = new User(name, email, country, fecha, celular);
		userDAO.insertUser(newUser);
		response.sendRedirect("listUser");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String fecha = request.getParameter("fecha");
		String celular = request.getParameter("celular");
		User book = new User(id, name, email, country, fecha, celular);
		userDAO.updateUser(book);
		response.sendRedirect("listUser");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("listUser");
	}
	// FIN USER DAO
}
