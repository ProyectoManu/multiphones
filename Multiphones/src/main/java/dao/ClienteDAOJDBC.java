package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import utilidades.ConexionBD;

public class ClienteDAOJDBC implements ClienteDAO {
	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	

	public ClienteDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Cliente> getCliente() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from clientes");
			while (resultado.next()) {
				int id_cliente = resultado.getInt("id_cliente");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String dni = resultado.getString("dni");
				String domicilio = resultado.getString("domicilio");
				String localidad = resultado.getString("localidad");
				String provincia = resultado.getString("provincia");
				String cod_postal = resultado.getString("cod_postal");
				Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
				String telefono_contacto = resultado.getString("telefono_contacto");
				String email = resultado.getString("email");
				Date fecha_contratacion = resultado.getDate("fecha_contratacion");
				Date permanencia = resultado.getDate("permanencia");
				String telefono_tarifa = resultado.getString("telefono_tarifa");
				int id_tarifa_movil = resultado.getInt("id_tarifa_movil");
				int id_tarifa_fibra = resultado.getInt("id_tarifa_fibra");
				int id_tarifa_movilYfibra = resultado.getInt("id_tarifa_movilYfibra");
				int id_tarifa_fijo = resultado.getInt("id_tarifa_fijo");
				
				Cliente c = new Cliente(id_cliente, nombre, apellidos, dni, domicilio, localidad, provincia, cod_postal,
										fecha_nacimiento, telefono_contacto, email, fecha_contratacion, permanencia,
										telefono_tarifa, id_tarifa_movil, id_tarifa_fibra, id_tarifa_movilYfibra,
										id_tarifa_fijo);
				
			
				listaClientes.add(c);
			}
			System.out.println("Añadiendo Clientes: ");
			System.out.println(listaClientes);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Clientes: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}

		
		return listaClientes;
		
	}

	@Override
	public int eliminarCliente(int id_cliente) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM clientes\r\n"
					+ "WHERE id_cliente = ?");
			
			consultaPreparada.setInt(1, id_cliente);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Cliente borrado correctamente: "+id_cliente);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado del cliente: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
		
	}

	@Override
	public Cliente getCliente(int id_cliente) {
		
		Connection con = conexion.getConexion();
		Cliente c = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from clientes"
					+ " where cod_empleado = ?");
			consultaPreparada.setInt(1, id_cliente);
			resultado=consultaPreparada.executeQuery();
			if (resultado.next()) {
				
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String dni = resultado.getString("dni");
				String domicilio = resultado.getString("domicilio");
				String localidad = resultado.getString("localidad");
				String provincia = resultado.getString("provincia");
				String cod_postal = resultado.getString("cod_postal");
				Date fecha_nacimiento = resultado.getDate("fecha_nacimiento");
				String telefono_contacto = resultado.getString("telefono_contacto");
				String email = resultado.getString("email");
				Date fecha_contratacion = resultado.getDate("fecha_contratacion");
				Date permanencia = resultado.getDate("permanencia");
				String telefono_tarifa = resultado.getString("telefono_tarifa");
				int id_tarifa_movil = resultado.getInt("id_tarifa_movil");
				int id_tarifa_fibra = resultado.getInt("id_tarifa_fibra");
				int id_tarifa_movilYfibra = resultado.getInt("id_tarifa_movilYfibra");
				int id_tarifa_fijo = resultado.getInt("id_tarifa_fijo");
				
				 c = new Cliente(id_cliente, nombre, apellidos, dni, domicilio, localidad, provincia, cod_postal,
						 fecha_nacimiento, telefono_contacto, email, fecha_contratacion,permanencia,
						 telefono_tarifa, id_tarifa_movil, id_tarifa_fibra, id_tarifa_movilYfibra, id_tarifa_fijo);

				 System.out.println("Cliente encontrado: "+c );
			}
		
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Clientes: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}

		
		return c;
	}

	@Override
	public int insertarCliente(Cliente c) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO clientes (nombre, apellidos, dni, domicilio,\r\n"
					+ "						localidad, provincia, cod_postal, fecha_nacimiento, telefono_contacto,\r\n"
					+ "						email, fecha_contratacion, permanencia, telefono_tarifa,\r\n"
					+ "						id_tarifa_movil, id_tarifa_fibra, id_tarifa_movilYfibra, id_tarifa_fijo)"
					+ "VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, c.getNombre());
			consultaPreparada.setString(2, c.getApellidos());
			consultaPreparada.setString(3, c.getDni());
			consultaPreparada.setString(4, c.getDomicilio());
			consultaPreparada.setString(5, c.getLocalidad());
			consultaPreparada.setString(6, c.getProvincia());
			consultaPreparada.setString(7, c.getCod_postal());
			consultaPreparada.setDate(8, c.getFecha_nacimiento());
			consultaPreparada.setString(9, c.getTelefono_contacto());
			consultaPreparada.setString(10, c.getEmail());
			consultaPreparada.setDate(11, c.getFecha_contratacion());
			consultaPreparada.setDate(12, c.getPermanencia());
			consultaPreparada.setString(13, c.getTelefono_tarifa());
			consultaPreparada.setInt(14, c.getId_tarifa_movil());
			consultaPreparada.setInt(15, c.getId_tarifa_fibra());
			consultaPreparada.setInt(16, c.getId_tarifa_movilYfibra());
			consultaPreparada.setInt(17, c.getId_tarifa_fijo());
			
			
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Cliente insertado: ");
			System.out.println(c);

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserci�n del cliente: " + c
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}

	@Override
	public int actualizarCliente(Cliente c) {
	
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE clientes \r\n"
					+ "SET nombre=?,\r\n"
					+ "    apellidos=? \r\n"
					+ "    dni=?, \r\n"
					+ "    domicilio=?, \r\n"
					+ "    localidad=? \r\n"
					+ "    provincia=?, \r\n"
					+ "    cod_postal=?, \r\n"
					+ "    fecha_nacimiento=? \r\n"
					+ "    telefono_contacto=?, \r\n"
					+ "    email=?, \r\n"
					+ "    fecha_contratacion=? \r\n"
					+ "    permanencia=?, \r\n"
					+ "    telefono_tarifa=?, \r\n"
					+ "    id_tarifa_movil=?, \r\n"
					+ "    id_tarifa_fibra=?, \r\n"
					+ "    id_tarifa_movilYfibra=?, \r\n"
					+ "    id_tarifa_fijo=?, \r\n"
					+ "WHERE id_cliente=?");
			
			consultaPreparada.setString(1, c.getNombre());
			consultaPreparada.setString(2, c.getApellidos());
			consultaPreparada.setString(3, c.getDni());
			consultaPreparada.setString(4, c.getDomicilio());
			consultaPreparada.setString(5, c.getLocalidad());
			consultaPreparada.setString(6, c.getProvincia());
			consultaPreparada.setString(7, c.getCod_postal());
			consultaPreparada.setDate(8, c.getFecha_nacimiento());
			consultaPreparada.setString(9, c.getTelefono_contacto());
			consultaPreparada.setString(10, c.getEmail());
			consultaPreparada.setDate(11, c.getFecha_contratacion());
			consultaPreparada.setDate(12, c.getPermanencia());
			consultaPreparada.setString(13, c.getTelefono_tarifa());
			consultaPreparada.setInt(14, c.getId_tarifa_movil());
			consultaPreparada.setInt(15, c.getId_tarifa_fibra());
			consultaPreparada.setInt(16, c.getId_tarifa_movilYfibra());
			consultaPreparada.setInt(17, c.getId_tarifa_fijo());
			consultaPreparada.setInt(18, c.getId_cliente());
			
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Cliente actualizado: ");
			System.out.println(c);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion del cliente: "+consultaPreparada
					+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}

}
