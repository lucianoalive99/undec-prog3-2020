package gestores;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import clases.Ciudad;
public class GestorCiudad {

	public List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	//public List<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	private int iterador = 0;
	//private Iterator iter = listaCiudades.iterator();
	//private ListIterator iteradorlista = listaCiudades.listIterator();
	
	public GestorCiudad() {
		
	}
	public void crearCiudad(int pidCiudad, String pNombreCiudad, String pCodigoPostal) {
		//
		//listaCiudades.add(nuevaCiudad);
		boolean bandera = false;
		
		Ciudad nuevaCiudad = new Ciudad(pidCiudad,pNombreCiudad,pCodigoPostal);
		if(iterador == 0) {
			//Ciudad nuevaCiudad = new Ciudad(pidCiudad,pNombreCiudad,pCodigoPostal);
			listaCiudades.add(nuevaCiudad);
			System.out.println("La ciudad fue creada exitosamente.");
			iterador++;
			
		}
		else
		{
		 
		
			for (Ciudad misCiudades : listaCiudades){
				//while(iter.hasNext()) {
				//Ciudad misCiudades = (Ciudad)iter.next();
				if(misCiudades.getIdCiudad() == nuevaCiudad.getIdCiudad() || misCiudades.getCodigoPostal() == nuevaCiudad.getCodigoPostal()) {
					bandera = true;
				}
			}
				if (bandera == true) {
					System.out.println("No se puede crear la ciudad, ya existe en el sistema");
					bandera = false;
				}
				else {
					//Ciudad nuevaCiudad = new Ciudad(pidCiudad,pNombreCiudad,pCodigoPostal);
					listaCiudades.add(nuevaCiudad);
					System.out.println("La Ciudad fue creada exitosamente.");
					bandera = false;
				
				}
			}
		
		}
		/*for (Ciudad misCiudades : listaCiudades) {
			if(misCiudades.getIdCiudad() == pidCiudad || misCiudades.getCodigoPostal() == pCodigoPostal) {
				Ciudad nuevaCiudad2 = new Ciudad(pidCiudad,pNombreCiudad,pCodigoPostal);
				listaCiudades.add(nuevaCiudad2);
				return true;
		//return nuevaCiudad;
			}
			else {
				return false;
			}
		}
		return false;*/
//	}
	public String mostrarCiudades() {
		for(Ciudad misCiudades : listaCiudades) {
			System.out.println(misCiudades.getNombre());
			return misCiudades.devolverCiudad();
				
		}
		return "";
	}
	
	public boolean modificarCodigoPostal(String pCodigoPostalViejo, String pCodigoPostalNuevo) {
		for (Ciudad misCiudades : listaCiudades) {
			if(misCiudades.getCodigoPostal() == pCodigoPostalViejo) {
				misCiudades.setCodigoPostal(pCodigoPostalNuevo);
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public boolean modificarnombre(int pIdCiudad, String pNombreNuevo) {
		for (Ciudad misCiudades : listaCiudades) {
			if(misCiudades.getIdCiudad() == pIdCiudad) {
				misCiudades.setNombre(pNombreNuevo);;
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public boolean modificarCodigoPostalYNombre(String pCodigoPostalViejo, String pCodigoPostalNuevo, String pNombreNuevo, int pIdCiudad) {
		for (Ciudad misCiudades : listaCiudades) {
			if(misCiudades.getCodigoPostal() == pCodigoPostalViejo) {
				misCiudades.setCodigoPostal(pCodigoPostalNuevo);
				return true;
			}
			else {
				if(misCiudades.getIdCiudad() == pIdCiudad) {
					misCiudades.setNombre(pNombreNuevo);
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean borrarCiudadPorCoidgoPostal(String pCodigoPostalViejo) {
		for (Ciudad misCiudades : listaCiudades) {
			if(misCiudades.getCodigoPostal() == pCodigoPostalViejo) {
				return true;
			}
			else {
					return false;
				
			}
		}
		return false;
	
	}
	
	
	
	
	
	//*public String 
}
