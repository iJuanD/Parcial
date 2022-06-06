package modelo;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
// atributos
	protected int id;
	protected String name;
	protected String email;
	protected String country;
	protected String fecha;
	protected String celular;

	// constructor vacío
	public User() {
	}
	
	

	public User(String name, String email, String country, String fecha, String celular) {
		this.name = name;
		this.email = email;
		this.country = country;
		this.fecha = fecha;
		this.celular = celular;
	}


	public User(int id, String name, String email, String country, String fecha, String celular) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.fecha = fecha;
		this.celular = celular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}