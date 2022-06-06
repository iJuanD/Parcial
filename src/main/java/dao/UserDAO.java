package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/demo?useSSL=false";
	private String jdbcUsername = "crud_guia16";
	private String jdbcPassword = "clave123";
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(name, email, country, fecha, celular) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country,fecha,celular from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name =?,email= ?, country =?, fecha =?, celular=?  where id = ?;";

	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
//registra el driver de conexi�n para la base de datos
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

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
// Se conecta a la base de datos
		try (Connection connection = getConnection();
// Prepara la sentencia sql a ejecutar con el objeto

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setString(4, user.getFecha());
			preparedStatement.setString(5, user.getCelular());
//System.out.println(preparedStatement);
// Ejecuta la consulta
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

// METODO PARA BUSCAR POR USUARIO (ID)
	public User selectUser(int id) {
		User user = null;
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
				String email = rs.getString("email");
				String country = rs.getString("country");
				String fecha = rs.getString("fecha");
				String celular = rs.getString("celular");
				user = new User(id, name, email, country, fecha, celular);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

//METODO PARA MOSTRAR TODA LA LISTA DE USUARIOS
	public List<User> selectAllUsers() {
//crea el array para mostrar los resultados
		List<User> users = new ArrayList<>();
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
				String email = rs.getString("email");
				String country = rs.getString("country");
				String fecha = rs.getString("fecha");
				String celular = rs.getString("celular");
				users.add(new User(id, name, email, country, fecha, celular));
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
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setString(4, user.getFecha());
			statement.setString(5, user.getCelular());
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