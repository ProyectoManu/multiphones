package modelo;
/**
 * Clase Operador
 */
import java.util.Objects;
/**
 * Clase que modelo un Operador
 * @author Araceli Cuadra y Manuel López
 *
 */
public class Operador {
	
	/**
	 * Variables que representan al operador
	 */
	protected int id_operador;
	protected String nombre_operador;
	protected String red_movil;
	protected String red_fija;
	
	/**
	 * Constructor sin parámetros que crea un operador
	 */
	public Operador() {
		
	}
	/**
	 * Constructor parametrizado que crea un operador dado su id_operador,
	 * nombre_operador, red_movil y red_fija.
	 * @param id_operador int número que identifica a un operador
	 * @param nombre_operador String con el nombre del operador
	 * @param red_movil String con el nombre del operador que sirve la red móvil
	 * @param red_fija String con el nombre del operador que sirve la red fija
	 */

	public Operador(int id_operador, String nombre_operador, String red_movil, String red_fija) {
		super();
		this.id_operador = id_operador;
		this.nombre_operador = nombre_operador;
		this.red_movil = red_movil;
		this.red_fija = red_fija;
	}
	
	/**
	 * Método accesor que nos devuelve el id del operador
	 * @return id_operador int el id que identifica al operador
	 */

	public int getId_operador() {
		return id_operador;
	}
	/**
	 * Método de establecimiento que cambia el id del operador
	 * @param id_operador int el id que identifica al operador
	 */

	public void setId_operador(int id_operador) {
		this.id_operador = id_operador;
	}

	/**
	 * Método accesor que nos devuelve el nombre del operador
	 * @return nombre_operador String con el nombre del operador
	 */
	public String getNombre_operador() {
		return nombre_operador;
	}

	/**
	 * Método de establecimiento que cambia el nombre del operador
	 * por el nombre pasado por parámetro
	 * @param nombre_operador String el nuevo nombre del operador
	 */
	public void setNombre_operador(String nombre_operador) {
		this.nombre_operador = nombre_operador;
	}
	/**
	 * Método accesor que nos devuelve la red movil del operador
	 * @return red_movil String con la red movil del operador
	 */

	public String getRed_movil() {
		return red_movil;
	}
	/**
	 * Método de establecimiento que cambia la red movil del operador
	 * @param red_movil String la nueva red movil
	 */
	public void setRed_movil(String red_movil) {
		this.red_movil = red_movil;
	}
	/**
	 * Método accesor que nos devuelve la red fija
	 * @return red_fija String con la red fija del operador
	 */
	public String getRed_fija() {
		return red_fija;
	}
	/**
	 * Método de establecimiento que cambia la red fija del operador
	 * @param red_fija String la nueva red fija
	 */
	public void setRed_fija(String red_fija) {
		this.red_fija = red_fija;
	}

	/**
	 * Muestra el operador con todas sus variables
	 */
	@Override
	public String toString() {
		return "Operadores [id_operador=" + id_operador + ", nombre_operador=" + nombre_operador + ", red_movil="
				+ red_movil + ", red_fija=" + red_fija + "]";
	}

	/**
	 * Métodos para comparar dos objetos Operador
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id_operador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operador other = (Operador) obj;
		return id_operador == other.id_operador;
	}
	
	

}
