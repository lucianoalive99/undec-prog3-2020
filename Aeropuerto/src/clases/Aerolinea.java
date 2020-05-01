package clases;

public class Aerolinea {

		Integer idAerolinea;
		String nombre;
		
		
		public Integer getIdAerolinea() {
			return idAerolinea;
		}


		public void setIdAerolinea(Integer idAerolinea) {
			this.idAerolinea = idAerolinea;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public Aerolinea(Integer idAerolinea, String nombre) {
			super();
			this.idAerolinea = idAerolinea;
			this.nombre = nombre;
		}
		
		public String devolverAerolinea() {
			return getNombre();
		}
	

}
