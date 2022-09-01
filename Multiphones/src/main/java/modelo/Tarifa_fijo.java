package modelo;
/**
 * Clase Tarifa_fijo
 */
import java.util.Objects;

/**
 *  Clase que modela los datos de la Tarifa fijo
 * @author Manuel López y Araceli Cuadra
 *
 */

public class Tarifa_fijo {
	
	/**
	 * Variables que representan a la Tarifa Fijo
	 */
	
	private int id_tarifa_fijo;
	private String tipo_tarifa;
	private String nombre_tarifa;
	private int id_operador;
	private String minutos_nacionales;
	private String minutos_internacionales;
	private float precio;
	private float precio_promocion;
	private float precio_pack;
	private String duracion_promocion;
	
	
	/**
	 * Constructor sin parámetros que crea una Tarifa fijo
	 */
	
	public Tarifa_fijo() {
		
	}

	/**
	 * Constructor parametrizado que crea una Tarifa fijo dado todos los parámetros (
	 * id_tarifa_fijo, tipo_tarifa, nombre_tarifa, id_operador, mihutos_nacionales
	 * minutos internacionales, precio, precio_promocion, precio_pack, duracion_promocion)
	 * @param id_tarifa_fijo int número que identifica la tarifa fijo
	 * @param tipo_tarifa String que identifica el tipo de tarifa
	 * @param nombre_tarifa String que identificw el nombre de la tarifa
	 * @param id_operador int número que identifica el operqdor
	 * @param minutos_nacionales String que identifica los minutos nacionales
	 * @param minutos_internacionales String que identifica los minutos internacionales
	 * @param precio float que identificq el precio
	 * @param precio_promocion float que identificq el precio promocion
	 * @param precio_pack float que identificq el precio pack
	 * @param duracion_promocion String que identifica la duración de la promoción
	 */
	
	public Tarifa_fijo(int id_tarifa_fijo, String tipo_tarifa, String nombre_tarifa, int id_operador,
			String minutos_nacionales, String minutos_internacionales, float precio, float precio_promocion,
			float precio_pack, String duracion_promocion) {
		super();
		this.id_tarifa_fijo = id_tarifa_fijo;
		this.tipo_tarifa = tipo_tarifa;
		this.nombre_tarifa = nombre_tarifa;
		this.id_operador = id_operador;
		this.minutos_nacionales = minutos_nacionales;
		this.minutos_internacionales = minutos_internacionales;
		this.precio = precio;
		this.precio_promocion = precio_promocion;
		this.precio_pack = precio_pack;
		this.duracion_promocion = duracion_promocion;
	}
	
	/**
	 * Método accesor que devuelve el id de la tarifa fijo
	 * @return int con el id de la tarifa fijo
	 */

	public int getId_tarifa_fijo() {
		return id_tarifa_fijo;
	}

	/**
	 * Método de establecimiento que cambia el id de la tarifa fijo
	 * @param id_tarifa_fijo int nuevo id de la tarifa fijo
	 */
	
	public void setId_tarifa_fijo(int id_tarifa_fijo) {
		this.id_tarifa_fijo = id_tarifa_fijo;
	}
	
	/**
	 * Método accesor que devuelve el tipo de tarifa 
	 * @return String con el tipo de tarifq
	 */

	public String getTipo_tarifa() {
		return tipo_tarifa;
	}
	
	/**
	 *  Método de establecimiento que cambia el tipo de tarifa
	 * @param tipo_tarifa String nuevo tipo de tarifa
	 */

	public void setTipo_tarifa(String tipo_tarifa) {
		this.tipo_tarifa = tipo_tarifa;
	}
	
	/**
	 * Método accesor que devuelve el nombre de la tarifa 
	 * @return String con el nombre de la tarifa
	 */

	public String getNombre_tarifa() {
		return nombre_tarifa;
	}
	
	/**
	 * Método de establecimiento que cambia el nombre de la tarifa
	 * @param nombre_tarifa String nuevo nombre de la tarifa
	 */

	public void setNombre_tarifa(String nombre_tarifa) {
		this.nombre_tarifa = nombre_tarifa;
	}
	
	/**
	 * Método accesor que devuelve el id del operador
	 * @return int con el id del operador
	 */

	public int getId_operador() {
		return id_operador;
	}
	
	/**
	 * Método de establecimiento que cambia el id del operador
	 * @param id_operador int nuevo id del operqdor
	 */

	public void setId_operador(int id_operador) {
		this.id_operador = id_operador;
	}
	
	/**
	 * Método accesor que devuelve los minutos nacionales
	 * @return String con los minutos nacionales
	 */

	public String getMinutos_nacionales() {
		return minutos_nacionales;
	}
	
	/**
	 * Método de establecimiento que cambia los minutos nacionales
	 * @param minutos_nacionales String nuevo con los minutos nacionales
	 */

	public void setMinutos_nacionales(String minutos_nacionales) {
		this.minutos_nacionales = minutos_nacionales;
	}
	
	/**
	 * Método accesor que devuelve los minutos internacionales
	 * @return String con los minutos internacionales
	 */

	public String getMinutos_internacionales() {
		return minutos_internacionales;
	}
	
	/**
	 * Método de establecimiento que cambia los minutos internacionales
	 * @param minutos_internacionales String nuevo con los minutos internacionales
	 */

	public void setMinutos_internacionales(String minutos_internacionales) {
		this.minutos_internacionales = minutos_internacionales;
	}
	
	/**
	 * Método accesor que devuelve el precio
	 * @return float con el precio
	 */

	public float getPrecio() {
		return precio;
	}
	
	/**
	 * Método de establecimiento que cambia el precio
	 * @param precio float nuevo con el precio
	 */

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Método accesor que devuelve el precio promocion
	 * @return float con el precio promocion
	 */

	public float getPrecio_promocion() {
		return precio_promocion;
	}
	
	/**
	 * Método de establecimiento que cambia el precio promoción
	 * @param precio_promocion float nuevo con el precio promoción
	 */

	public void setPrecio_promocion(float precio_promocion) {
		this.precio_promocion = precio_promocion;
	}
	
	/**
	 * Método accesor que devuelve el precio pack
	 * @return float con el precio pack
	 */

	public float getPrecio_pack() {
		return precio_pack;
	}
	
	/**
	 * Método de establecimiento que cambia el precio pack
	 * @param precio_pack float nuevo con el precio pack
	 */

	public void setPrecio_pack(float precio_pack) {
		this.precio_pack = precio_pack;
	}
	
	/**
	 *  Método accesor que devuelve la duración de la promoción
	 * @return String con la duración de la promoción
	 */

	public String getDuracion_promocion() {
		return duracion_promocion;
	}
	
	/**
	 *  Método de establecimiento que cambia la duración de la promoción
	 * @param duracion_promocion String nuevo con la duración de la promoción
	 */

	public void setDuracion_promocion(String duracion_promocion) {
		this.duracion_promocion = duracion_promocion;
	}
	
	/**
	 * Muestra la Tarifa fijo con todos sus datos
	 */

	@Override
	public String toString() {
		return "Tarifas_fijo [id_tarifa_fijo=" + id_tarifa_fijo + ", tipo_tarifa=" + tipo_tarifa + ", nombre_tarifa="
				+ nombre_tarifa + ", id_operador=" + id_operador + ", minutos_nacionales=" + minutos_nacionales
				+ ", minutos_internacionales=" + minutos_internacionales + ", precio=" + precio + ", precio_promocion="
				+ precio_promocion + ", precio_pack=" + precio_pack + ", duracion_promocion=" + duracion_promocion
				+ "]";
	}
	
	/**
	 * Métodos para comparar dos objetos Tarifa fijo
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id_tarifa_fijo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarifa_fijo other = (Tarifa_fijo) obj;
		return id_tarifa_fijo == other.id_tarifa_fijo;
	}
	
	
	
}