package modelo;
/**
 * Clase Tarifa_fibra
 */
import java.util.Objects;
/**
 * Clase que modelo las tarifas de Fibra
 * @author Araceli Cuadra y Manuel López
 *
 */
public class Tarifa_fibra {

	/**
	 * Variables estado del objeto Tarifa_fibra
	 */
	protected int id_tarifa_fibra;
	protected String tipo_tarifa;
	protected String nombre_tarifa;
	protected int id_operador;
	protected int velocidad_fibra;
	protected float precio;
	protected float precio_promocion;
	protected float precio_pack;
	protected String duracion_promocion;
	protected boolean fijo;
	
	/**
	 * Constructor sin parámetros que crea una Tarifa_fibra
	 */
	public Tarifa_fibra() {
		
	}
	/**
	 * Constructor parametralizado que crea una Tarifa_fibra dados
	 * los parámetros id_tarifa_fibra, tipo_tarifa, nombre_tarifa,
	 * id_operador, velocidad_fibra, precio, precio_promocion,
	 * precio_pack, duracion_promocion y fijo
	 * @param id_tarifa_fibra int con el id de la tarifa de fibra que la identifica
	 * @param tipo_tarifa String con el tipo de tarifa contrato, prepago, etc
	 * @param nombre_tarifa String con el nombre de la tarifa
	 * @param id_operador int que identifica al operador de la tarifa
	 * @param velocidad_fibra int número con la velocidad de la fibra
	 * @param precio float el precio de la tarifa
	 * @param precio_promocion float el precio en promocion de esa tarifa
	 * @param precio_pack float el precio en el caso que vaya en un pack con más productos
	 * @param duracion_promocion String la duracion de la promocion
	 * @param fijo boolean true si tiene un fijo la fibra y false para el caso contrario
	 */
	public Tarifa_fibra(int id_tarifa_fibra, String tipo_tarifa, String nombre_tarifa, int id_operador,
			int velocidad_fibra, float precio, float precio_promocion, float precio_pack, String duracion_promocion,
			boolean fijo) {
		super();
		this.id_tarifa_fibra = id_tarifa_fibra;
		this.tipo_tarifa = tipo_tarifa;
		this.nombre_tarifa = nombre_tarifa;
		this.id_operador = id_operador;
		this.velocidad_fibra = velocidad_fibra;
		this.precio = precio;
		this.precio_promocion = precio_promocion;
		this.precio_pack = precio_pack;
		this.duracion_promocion = duracion_promocion;
		this.fijo = fijo;
	}
	/**
	 * Método accesor que devuelve el id de la tarifa_fibra
	 * @return int con el id de la tarifa_fibra
	 */
	public int getId_tarifa_fibra() {
		return id_tarifa_fibra;
	}
	/**
	 * Método de establecimiento que cambia el id de la tarifa_fibra
	 * pasado por parámetro el nuevo id
	 * @param id_tarifa_fibra int nuevo id de tarifa_fibra
	 */
	public void setId_tarifa_fibra(int id_tarifa_fibra) {
		this.id_tarifa_fibra = id_tarifa_fibra;
	}
	/**
	 * Método accesor que devuelve el tipo de tarifa
	 * @return String tipo_tarifa con el tipo de tarifa
	 */
	public String getTipo_tarifa() {
		return tipo_tarifa;
	}
/**
 * Método de establecimiento que cambia el tipo de tarifa
 * pasado por parámetro el nuevo tipo
 * @param tipo_tarifa String El tipo de tarifa
 */
	public void setTipo_tarifa(String tipo_tarifa) {
		this.tipo_tarifa = tipo_tarifa;
	}
/**
 * Método accesor que devuelve el nombre de la tarifa
 * @return String nombre_tarifa con el nombre de la tarifa
 */
	public String getNombre_tarifa() {
		return nombre_tarifa;
	}
/**
 * Método de establecimiento que cambia el nombre de la tarifa
 * pasado por parámetro el nuevo nombre
 * @param nombre_tarifa String el nombre de la tarifa
 */
	public void setNombre_tarifa(String nombre_tarifa) {
		this.nombre_tarifa = nombre_tarifa;
	}
	/**
	 * Método accesor que devuelve el id del operador
	 * @return int id_operador el id del operador
	 */
	public int getId_operador() {
		return id_operador;
	}
	/**
	 * Método de establecimiento que cambia el id del operador
	 * pasado por parámetro el nuevo id
	 * @param id_operador int el nuevo id de operador
	 */
	public void setId_operador(int id_operador) {
		this.id_operador = id_operador;
	}
	/**
	 * Método accesor que devuelve la velocidad de la fibra
	 * @return int velocidad_fibra con la velocidad de la fibra
	 */
	public int getVelocidad_fibra() {
		return velocidad_fibra;
	}
	/**
	 * Método de establecimiento que cambia la velocidad de la fibra
	 * pasado por parámetro la nueva velocidad
	 * @param velocidad_fibra int con la nueva velocidad de la fibra
	 */
	public void setVelocidad_fibra(int velocidad_fibra) {
		this.velocidad_fibra = velocidad_fibra;
	}
	/**
	 * Método accesor que devuelve el precio de la tarifa
	 * @return Float precio con el precio de la tarifa
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Método de establecimiento que cambia el precio de una tarifa
	 * pasado por parámetro el nuevo precio
	 * @param precio float con el nuevo precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * Método accesor que devuelve el precio en promoción de la tarifa
	 * @return Float precio_promocion con el precio en promoción de la tarifa
	 */
	public float getPrecio_promocion() {
		return precio_promocion;
	}
	/**
	 * Método de establecimiento que cambia el precio en promocion de una tarifa
	 * pasado por parámetro el nuevo precio en promocion
	 * @param precio_promocion float con el nuevo precio en promocion
	 */
	public void setPrecio_promocion(float precio_promocion) {
		this.precio_promocion = precio_promocion;
	}
	/**
	 * Método accesor que devuelve el precio pack de la tarifa
	 * @return Float precio_pack con el precio en pack de la tarifa
	 */
	public float getPrecio_pack() {
		return precio_pack;
	}
	/**
	 * Método de establecimiento que cambia el precio pack de la tarifa
	 * pasado por parámetro el nuevo precio pack
	 * @param precio_pack float con el nuevo precio pack
	 */
	public void setPrecio_pack(float precio_pack) {
		this.precio_pack = precio_pack;
	}
	/**
	 * Método accesor que devuelve la duración de la promoción
	 * @return String duracion_promocion con la duración de la promocion
	 */
	public String getDuracion_promocion() {
		return duracion_promocion;
	}
	/**
	 * Método de establecimiento que cambia la duracion de la promocion
	 * pasado por parámetro la nueva duracion
	 * @param duracion_promocion String la duracion de la promocion
	 */
	public void setDuracion_promocion(String duracion_promocion) {
		this.duracion_promocion = duracion_promocion;
	}
	/**
	 * Método accesor que devuelve si tiene fijo o no
	 * @return boolean isFijo true si tiene fijo y false para el caso contrario
	 */
	public boolean isFijo() {
		return fijo;
	}
	/**
	 * Método de establecimiento que cambia a true o false si tiene fijo o no 
	 * correlativamente
	 * @param fijo boolean true si tiene fijo y false en caso contrario
	 */
	public void setFijo(boolean fijo) {
		this.fijo = fijo;
	}

	/**
	 * Muestra la Tarifa_fibra con todos sus datos
	 */
	@Override
	public String toString() {
		return "Tarifas_fibra [id_tarifa_fibra=" + id_tarifa_fibra + ", tipo_tarifa=" + tipo_tarifa + ", nombre_tarifa="
				+ nombre_tarifa + ", id_operador=" + id_operador + ", velocidad_fibra=" + velocidad_fibra + ", precio="
				+ precio + ", precio_promocion=" + precio_promocion + ", precio_pack=" + precio_pack
				+ ", duracion_promocion=" + duracion_promocion + ", fijo=" + fijo + "]";
	}
	/**
	 * Método para comparar dos objetos Tarifa_fibra
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id_tarifa_fibra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarifa_fibra other = (Tarifa_fibra) obj;
		return id_tarifa_fibra == other.id_tarifa_fibra;
	}
	
	
}
