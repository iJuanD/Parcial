package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.User_estudiante;

public class UserDAO_estudiante {
	private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/demo?useSSL=false";
	private String jdbcUsername = "crud_guia16";
	private String jdbcPassword = "clave123";
	private static final String INSERT_USERS_SQL = "INSERT INTO estudiante" + "(name, apellido, materia, grupo, email) VALUES " + 
	" (?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name, apellido, materia, grupo, email  from estudiante where id =?";
	private static final String SELECT_ALL_USERS = "select * from estudiante";
	private static final String DELETE_USERS_SQL = "delete from estudiante where id = ?;";
	private static final String UPDATE_USERS_SQL = "update estudiante set name =?, apellido= ?, materia =?, grupo =?, email=?  where id = ?;";

	public UserDAO_estudiante() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
//registra el driver de conexión para la base de datos
//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User_estudiante user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getApellido());
			preparedStatement.setString(3, user.getMateria());
			preparedStatement.setString(4, user.getGrupo());
			preparedStatement.setString(5, user.getEmail());

//System.out.println(preparedStatement);
// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public User_estudiante selectUser(int id) {
		User_estudiante user = null;
//Se conecta a la base de datos
		try (Connection connection = getConnection();
//Prepara la sentencia sql a ejecutar con el objeto
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
//System.out.println(preparedStatement);
//Ejecuta la consulta
			ResultSet rs = preparedStatement.executeQuery();
//Recorre los resultados y los devuelve en el objeto user
			while (rs.next()) {
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				String materia = rs.getString("materia");
				String grupo = rs.getString("grupo");
				String email = rs.getString("email");
				user = new User_estudiante(id, name, apellido, materia, grupo, email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<User_estudiante> selectAllUsers() {
//crea el array para mostrar los resultados
		List<User_estudiante> users = new ArrayList<>();
//Conecta con la bd
		try (Connection connection = getConnection();
//Prepara la consulta sql
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//System.out.println(preparedStatement);
//Ejecuta la consulta y la almacena en un objeto ResultSet
			ResultSet rs = preparedStatement.executeQuery();
//Recorre el resultado y lo almacena en el objeto users
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				String materia = rs.getString("materia");
				String grupo = rs.getString("grupo");
				String email = rs.getString("email");
				users.add(new User_estudiante(id, name, apellido, materia, grupo, email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

//METODO PARA BORRAR UN USUARIO DE LA BD
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// METODO PARA ACTUALIZAR DATOS DE UN USUARIO GUARDADO EN BD
	public boolean updateUser(User_estudiante user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getApellido());
			statement.setString(3, user.getMateria());
			statement.setString(4, user.getGrupo());
			statement.setString(5, user.getEmail());
			statement.setInt(6, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}