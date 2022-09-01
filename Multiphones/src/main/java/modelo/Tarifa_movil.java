package modelo;

/**
 * Clase Tarifa Móvil
 */

import java.util.Objects;

/**
 * Clase que modela los datos de la Tarifa móvil
 * @author Manuel López y Araceli Cuadra
 *
 */

public class Tarifa_movil {

	/**
	 * Variables que representan a la Tarifa movil
	 */
	
	private int id_tarifa_movil;
	private String tipo_tarifa;
	private String nombre_tarifa;
	private int id_operador;
	private String gigas;
	private String minutos;
	private float precio;
	private float precio_promocion;
	private float precio_pack;
	private String duracion_promocion;
	private boolean acumula;
	private boolean comparte;
	
	/**
	 * Constructor sin parámetros que crea una Tarifa móvil
	 */
	
	public Tarifa_movil() {
	
		
	}

	/**
	 * Constructor parametrizado que crea una Tarifa móvil dado todos los parámetros (
	 * id_tarifa_movil, tipo_tarifa, nombre_tarifa, Id_operador, gigas, minutos,
	 * precio, precio_promocion, precio_pack, duracion_promocion, acumula, comparte)
	 * @param id_tarifa_movil int número que identifica la tarifa movil
	 * @param tipo_tarifa String que identifica el tipo de tarifa
	 * @param nombre_tarifa String que identificw el nombre de la tarifa
	 * @param id_operador int número que identifica el operqdor
	 * @param gigas String que identifica los gigas
	 * @param minutos String que identifica los minutos
	 * @param precio float que identificq el precio
	 * @param precio_promocion float que identificq el precio de la promoción
	 * @param precio_pack float que identificq el precio pack
	 * @param duracion_promocion String que identifica la duración de la promoción
	 * @param acumula boolean que identifica acumula
	 * @param comparte boolean que identifica comparte
	 */
	
	public Tarifa_movil(int id_tarifa_movil, String tipo_tarifa, String nombre_tarifa, int id_operador, String gigas,
			String minutos, float precio, float precio_promocion, float precio_pack, String duracion_promocion,
			boolean acumula, boolean comparte) {
		super();
		this.id_tarifa_movil = id_tarifa_movil;
		this.tipo_tarifa = tipo_tarifa;
		this.nombre_tarifa = nombre_tarifa;
		this.id_operador = id_operador;
		this.gigas = gigas;
		this.minutos = minutos;
		this.precio = precio;
		this.precio_promocion = precio_promocion;
		this.precio_pack = precio_pack;
		this.duracion_promocion = duracion_promocion;
		this.acumula = acumula;
		this.comparte = comparte;
	}
	
	/**
	 * Método accesor que devuelve el id de la tarifa movil
	 * @return int con el id de la tarifa móvil
	 */

	public int getId_tarifa_movil() {
		return id_tarifa_movil;
	}
	
	/**
	 * Método de establecimiento que cambia el id de la tarifa móvil
	 * @param id_tarifa_movil int nuevo id de la tarifa móvil
	 */

	public void setId_tarifa_movil(int id_tarifa_movil) {
		this.id_tarifa_movil = id_tarifa_movil;
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
	 *  Método accesor que devuelve los gigas
	 * @return String con los gigas
	 */

	public String getGigas() {
		return gigas;
	}
	
	/**
	 *  Método de establecimiento que cambia los gigas
	 * @param gigas String nuevo de los gigas
	 */

	public void setGigas(String gigas) {
		this.gigas = gigas;
	}
	
	/**
	 *  Método accesor que devuelve los minutos
	 * @return String con los minutos
	 */

	public String getMinutos() {
		return minutos;
	}
	
	/**
	 * Método de establecimiento que cambia los minutos
	 * @param minutos String nuevo de los minutos
	 */

	public void setMinutos(String minutos) {
		this.minutos = minutos;
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
	 * Método accesor que devuelve el precio promoción
	 * @return float con el precio promoción
	 */

	public float getPrecio_promocion() {
		return precio_promocion;
	}
	
	/**
	 * Método de establecimiento que cambia el precio de la promoción
	 * @param precio_promocion float nuevo con el precio de la promoción
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
	 * Método accesor que devuelve la duración de la promoción
	 * @return String con la duración de la promoción
	 */

	public String getDuracion_promocion() {
		return duracion_promocion;
	}

	/**
	 * Método de establecimiento que cambia la duración de la promoción
	 * @param duracion_promocion String nuevo con la duración de la promoción
	 */
	public void setDuracion_promocion(String duracion_promocion) {
		this.duracion_promocion = duracion_promocion;
	}
	
	/**
	 *  Método accesor que devuelve acumula 
	 * @return boolean true o false acumula
	 */

	public boolean isAcumula() {
		return acumula;
	}

	/**
	 * Método de establecimiento que cambia acumula
	 * @param acumula boolean nuevo de acumula
	 */
	public void setAcumula(boolean acumula) {
		this.acumula = acumula;
	}
	
	/**
	 * Método accesor que devuelve comparte 
	 * @return boolean true o false comparte
	 */

	public boolean isComparte() {
		return comparte;
	}
	
	/**
	 * Método de establecimiento que cambia comparte
	 * @param comparte boolean nuevo de comparte
	 */

	public void setComparte(boolean comparte) {
		this.comparte = comparte;
	}
	
	/**
	 * Muestra la Tarifa móvil con todos sus datos
	 */

	@Override
	public String toString() {
		return "Tarifas_movil [id_tarifa_movil=" + id_tarifa_movil + ", tipo_tarifa=" + tipo_tarifa + ", nombre_tarifa="
				+ nombre_tarifa + ", id_operador=" + id_operador + ", gigas=" + gigas + ", minutos=" + minutos
				+ ", precio=" + precio + ", precio_promocion=" + precio_promocion + ", precio_pack=" + precio_pack
				+ ", duracion_promocion=" + duracion_promocion + ", acumula=" + acumula + ", comparte=" + comparte
				+ "]";
	}
	
	/**
	 *  Métodos para comparar dos objetos Tarifa móvil
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id_tarifa_movil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarifa_movil other = (Tarifa_movil) obj;
		return id_tarifa_movil == other.id_tarifa_movil;
	}
	
	
}