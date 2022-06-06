package modelo;

public class User_estudiante implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// atributos
		protected int id;
		protected String name;
		protected String apellido;
		protected String materia;
		protected String grupo;
		protected String email;
		
		
		public User_estudiante() {
	
		}


		public User_estudiante(int id, String name, String apellido, String materia, String grupo, String email) {

			this.id = id;
			this.name = name;
			this.apellido = apellido;
			this.materia = materia;
			this.grupo = grupo;
			this.email = email;
		}


		public User_estudiante(String name, String apellido, String materia, String grupo, String email) {

			this.name = name;
			this.apellido = apellido;
			this.materia = materia;
			this.grupo = grupo;
			this.email = email;
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


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}


		public String getMateria() {
			return materia;
		}


		public void setMateria(String materia) {
			this.materia = materia;
		}


		public String getGrupo() {
			return grupo;
		}


		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		
}
