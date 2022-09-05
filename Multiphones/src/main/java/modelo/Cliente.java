package modelo;

/**
 * Clase Cliente
 */

import java.util.Objects;
/**
 * Clase que modela los datos de los clientes
 * @author Manuel López y Araceli Cuadra
 *
 */

public class Cliente {
	
	/**
	 * Variables que representan al cliente
	 */
	private int id_cliente;
	private String nombre;
	private String apellidos;
	private String dni;
	private String domicilio;
	private String localidad;
	private String provincia;
	private String cod_postal;
	private String fecha_nacimiento;
	private String telefono_contacto;
	private String email;
	private String fecha_contratacion;
	private String permanencia;
	private String telefono_tarifa;
	private int id_tarifa_movil;
	private int id_tarifa_fibra;
	private int id_tarifa_movilYfibra;
	private int id_tarifa_fijo;
	
	/**
	 * Constructor sin parámetros que crea un cliente
	 */
	public Cliente() {
		
	}

/**
 * Constructor parametrizado que crea un cliente dado todos los parámetros (
 * id_cliente, nombre, apellidos, dni, domicilio, localidad, provincia, cod_postal
 * fecha_nacimiento, teléfono_contacto, email, fecha_contratación, permanencia, teléfono_tarifa
 * id_tarifa_movil, id_tarifa_fibra, id_tarifa_movilYfibra, id_tarifa_fijo)
 * @param id_cliente int número que identifica a cada cliente
 * @param nombre String nombre del cliente
 * @param apellidos String apellidos del cliente
 * @param dni String dni del cliente
 * @param domicilio String domicilio del cliente
 * @param localidad String localidad del cliente
 * @param provincia String provincia del cliente
 * @param cod_postal String código postal del cliente
 * @param fecha_nacimiento String fecha nacimiento del cliente
 * @param telefono_contacto String teléfono de contacto del cliente
 * @param email String email del cliente
 * @param fecha_contratacion String fecha en que contrata el cliente
 * @param permanencia String permanencia de lo que contrata el cliente
 * @param telefono_tarifa String número de teléfono que contrata el cliente
 * @param id_tarifa_movil int número que identifica una tarifa de móvil
 * @param id_tarifa_fibra int número que identifaca una tarifa de fibra
 * @param id_tarifa_movilYfibra int número que identifica una tarifa de móvil y fibra
 * @param id_tarifa_fijo int número que identifica una tarifa de fijo
 */
	
	public Cliente(int id_cliente, String nombre, String apellidos, String dni, String domicilio, String localidad,
			String provincia, String cod_postal, String fecha_nacimiento, String telefono_contacto, String email,
			String fecha_contratacion, String permanencia, String telefono_tarifa, int id_tarifa_movil, int id_tarifa_fibra,
			int id_tarifa_movilYfibra, int id_tarifa_fijo) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cod_postal = cod_postal;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono_contacto = telefono_contacto;
		this.email = email;
		this.fecha_contratacion = fecha_contratacion;
		this.permanencia = permanencia;
		this.telefono_tarifa = telefono_tarifa;
		this.id_tarifa_movil = id_tarifa_movil;
		this.id_tarifa_fibra = id_tarifa_fibra;
		this.id_tarifa_movilYfibra = id_tarifa_movilYfibra;
		this.id_tarifa_fijo = id_tarifa_fijo;
	}
	
/**
 * Constructor parametrizado que crea un cliente con tarifa asociada (nombre, apellidos, dni,
 * domicilio, localidad, provincia, cod_postal, fecha_nacimiento, telefono_contacto
 * email, telefono_tarifa, id_tarifa_movil)
 * @param nombre String nombre del cliente
 * @param apellidos String apellidos del cliente
 * @param dni String dni del cliente
 * @param domicilio String domicilio del cliente
 * @param localidad String localidad del cliente
 * @param provincia String provincia del cliente
 * @param cod_postal String código postal del cliente
 * @param fecha_nacimiento String fecha nacimiento del cliente
 * @param telefono_contacto String teléfono de contacto del cliente
 * @param email String email del cliente
 * @param telefono_tarifa String número de teléfono que contrata el cliente
 * @param id_tarifa_movil int número que identifica una tarifa de móvil
 * @param id_tarifa_fibra int número que identifica una tarifa de fibra
 * @param id_tarifa_movilYfibra int número que identifica una tarifa de móvil y fibra
 * @param id_tarifa_fijo int número que identifica una tarifa de fijo
 */

public Cliente(String nombre, String apellidos, String dni, String domicilio, String localidad, String provincia,
		String cod_postal, String fecha_nacimiento, String telefono_contacto, String email, String telefono_tarifa,
		int id_tarifa_movil, int id_tarifa_fibra, int id_tarifa_movilYfibra, int id_tarifa_fijo) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.dni = dni;
	this.domicilio = domicilio;
	this.localidad = localidad;
	this.provincia = provincia;
	this.cod_postal = cod_postal;
	this.fecha_nacimiento = fecha_nacimiento;
	this.telefono_contacto = telefono_contacto;
	this.email = email;
	this.telefono_tarifa = telefono_tarifa;
	this.id_tarifa_movil = id_tarifa_movil;
	this.id_tarifa_fibra = id_tarifa_fibra;
	this.id_tarifa_movilYfibra = id_tarifa_movilYfibra;
	this.id_tarifa_fijo = id_tarifa_fijo;
}

/**
 * Método accesor que devuelve el id del cliente
 * @return int con el id del cliente
 */

	public int getId_cliente() {
		return id_cliente;
	}
	
	/**
	 * Método de establecimiento que cambia el id del cliente
	 * 
	 * @param id_cliente int nuevo id del cliente
	 */

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	/**
	 * Método accesor que devuelve el nombre del cliente
	 * @return String con el nombre del cliente
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método de establecimiento que cambia el nombre del cliente
	 * @param nombre String nuevo nombre del cliente
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 *  Método accesor que devuelve el apellido del cliente
	 * @return String con el apellido del cliente
	 */

	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 *  Método de establecimiento que cambia el apellido del cliente
	 * @param apellidos String nuevo apellido del cliente
	 */

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Método accesor que devuelve el dni del cliente
	 * @return String con el dni del cliente
	 */

	public String getDni() {
		return dni;
	}
	
	/**
	 *  Método de establecimiento que cambia el dni del cliente
	 * @param dni String nuevo dni del cliente
	 */

	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método accesor que devuelve el domicilio del cliente
	 * @return String con el domicilio del cliente
	 */
	
	public String getDomicilio() {
		return domicilio;
	}
	
	/**
	 *  Método de establecimiento que cambia el domicilio del cliente
	 * @param domicilio String nuevo domiclilio del cliente
	 */

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	/**
	 * Método accesor que devuelve la localidad del cliente
	 * @return String con la localidad del cliente
	 */

	public String getLocalidad() {
		return localidad;
	}
	
	/**
	 *  Método de establecimiento que cambia la localidad del cliente
	 * @param localidad String nueva localidad del cliente
	 */

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	/**
	 * Método accesor que devuelve la provincia del cliente
	 * @return String con la localidad del cliente
	 */

	public String getProvincia() {
		return provincia;
	}
	
	/**
	 *  Método de establecimiento que cambia la provincia del cliente
	 * @param provincia String nueva provincia del cliente
	 */

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * Método accesor que devuelve el codigo postal del cliente
	 * @return String con el codigo postal del cliente
	 */

	public String getCod_postal() {
		return cod_postal;
	}
	
	/**
	 *  Método de establecimiento que cambia el codigo postal del cliente
	 * @param cod_postal String nuevo codigo postal del cliente
	 */

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}
	
	/**
	 * Método accesor que devuelve la fecha nacimiento del cliente
	 * @return String con la fecha de naçimiento del cliente
	 */

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	/**
	 *  Método de establecimiento que cambia la fecha de nacimiento del cliente
	 * @param fecha_nacimiento String nueva fecha de nacimiento del cliente
	 */

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	/**
	 * Método accesor que devuelve el telefono de contacto del cliente
	 * @return String con el telefono de contacto del cliente
	 */

	public String getTelefono_contacto() {
		return telefono_contacto;
	}
	
	/**
	 *  Método de establecimiento que cambia el telefono de contacto del cliente
	 * @param telefono_contacto String nuevo telefono contacto del cliente
	 */

	public void setTelefono_contacto(String telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}
	
	/**
	 * Método accesor que devuelve el email del cliente
	 * @return String con el email del cliente
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 *  Método de establecimiento que cambia el email del cliente
	 * @param email String nuevo email del cliente
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método accesor que devuelve la fecha de contratacion del cliente
	 * @return String nueva fecha contratacion del cliente
	 */

	public String getFecha_contratacion() {
		return fecha_contratacion;
	}
	
	/**
	 *  Método de establecimiento que cambia la fecha contratación del cliente
	 * @param fecha_contratacion String nueva fecha contratación del cliente
	 */

	public void setFecha_contratacion(String fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}
	
	/**
	 * Método accesor que devuelve la permanencia del cliente
	 * @return String nueva permanencia del cliente
	 */

	public String getPermanencia() {
		return permanencia;
	}
	
	/**
	 *  Método de establecimiento que cambia la permanencia del cliente
	 * @param permanencia String nueva permanecia del cliente
	 */

	public void setPermanencia(String permanencia) {
		this.permanencia = permanencia;
	}

	/**
	 * Método accesor que devuelve el telefono tarifa del cliente
	 * @return String nuevo telefono tarifa
	 */
	public String getTelefono_tarifa() {
		return telefono_tarifa;
	}

	/**
	 *  Método de establecimiento que cambia el telefono de la tarifa del cliente
	 * @param telefono_tarifa String nuevo telefono tarifa del cliente
	 */
	public void setTelefono_tarifa(String telefono_tarifa) {
		this.telefono_tarifa = telefono_tarifa;
	}
	
	/**
	 * Método accesor que devuelve el id de la tarifa movil del cliente
	 * @return String nueva tarifa movil del cliente
	 */

	public int getId_tarifa_movil() {
		return id_tarifa_movil;
	}
	
	/**
	 *  Método de establecimiento que cambia el id de la tarifa movil del cliente
	 * @param id_tarifa_movil String nuevo id tarifa movil del cliente
	 */

	public void setId_tarifa_movil(int id_tarifa_movil) {
		this.id_tarifa_movil = id_tarifa_movil;
	}
	
	/**
	 * Método accesor que devuelve el id de la tarifa fibra del cliente
	 * @return String nueva tarifa fibra del cliente
	 */

	public int getId_tarifa_fibra() {
		return id_tarifa_fibra;
	}
	
	/**
	 *  Método de establecimiento que cambia el id de la tarifa fibra del cliente
	 * @param id_tarifa_fibra String nuevo id de la tarifa fibra del cliente
	 */

	public void setId_tarifa_fibra(int id_tarifa_fibra) {
		this.id_tarifa_fibra = id_tarifa_fibra;
	}
	
	/**
	 * Método accesor que devuelve el id de la tarifa movil y fibra del cliente
	 * @return String nueva tarifa movil y fibra del cliente
	 */

	public int getId_tarifa_movilYfibra() {
		return id_tarifa_movilYfibra;
	}
	
	/**
	 * Método de establecimiento que cambia el id de la tarifa movil y fibra del cliente
	 * @param id_tarifa_movilYfibra String nuevo id de la tarifa movil y fibra del cliente
	 */

	public void setId_tarifa_movilYfibra(int id_tarifa_movilYfibra) {
		this.id_tarifa_movilYfibra = id_tarifa_movilYfibra;
	}
	
	/**
	 * Método accesor que devuelve el id de la tarifa fijo del cliente
	 * @return String nueva tarifa fijo del cliente
	 */

	public int getId_tarifa_fijo() {
		return id_tarifa_fijo;
	}
	
	/**
	 * Método de establecimiento que cambia el id de la tarifa fijo del cliente
	 * @param id_tarifa_fijo String nuevo id de la tarifa fijo del cliente
	 */

	public void setId_tarifa_fijo(int id_tarifa_fijo) {
		this.id_tarifa_fijo = id_tarifa_fijo;
	}
	
	/**
	 * Muestra el cliente con todos sus datos
	 */

	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", domicilio=" + domicilio + ", localidad=" + localidad + ", provincia=" + provincia + ", cod_postal="
				+ cod_postal + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono_contacto=" + telefono_contacto
				+ ", email=" + email + ", fecha_contratacion=" + fecha_contratacion + ", permanencia=" + permanencia
				+ ", telefono_tarifa=" + telefono_tarifa + ", id_tarifa_movil=" + id_tarifa_movil + ", id_tarifa_fibra="
				+ id_tarifa_fibra + ", id_tarifa_movilYfibra=" + id_tarifa_movilYfibra + ", id_tarifa_fijo="
				+ id_tarifa_fijo + "]";
	}
	
	/**
	 * Métodos para comparar dos objetos Cliente
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id_cliente == other.id_cliente;
	}

	
}