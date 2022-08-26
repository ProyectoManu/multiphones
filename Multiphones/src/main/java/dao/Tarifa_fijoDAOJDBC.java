package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Tarifa_fibra;
import modelo.Tarifa_fijo;
import utilidades.ConexionBD;

public class Tarifa_fijoDAOJDBC implements Tarifa_fijoDAO {
	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;

	
	public Tarifa_fijoDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Tarifa_fijo> getTarifa_fijo() {
		List<Tarifa_fijo> listaTarifa_fijo = new ArrayList<Tarifa_fijo>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from tarifas_fijo");
			while (resultado.next()) {
				int id_tarifa_fijo = resultado.getInt("id_tarifa_fijo");
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				String minutos_nacionales = resultado.getString("minutos_nacionales");
				String minutos_internacionales = resultado.getString("minutos_internacionales");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				
				
				
				Tarifa_fijo tarifa_fijo = new Tarifa_fijo(id_tarifa_fijo, tipo_tarifa, nombre_tarifa,
						id_operador, minutos_nacionales, minutos_internacionales, precio, 
						precio_promocion, precio_pack, duracion_promocion);
			
				listaTarifa_fijo.add(tarifa_fijo);
			}
			System.out.println("Añadiendo Tarifa de fijo: ");
			System.out.println(listaTarifa_fijo);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de fijo: "+e.getMessage());
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

		
		return listaTarifa_fijo;
	}

	@Override
	public Tarifa_fijo getTarifa_fijo(int id_tarifa_fijo) {
		Connection con = conexion.getConexion();
		Tarifa_fijo tarifa_fijo = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from tarifas_fijo"
					+ " where id_tarifa_fijo = ?");
			consultaPreparada.setInt(1, id_tarifa_fijo);
			resultado=consultaPreparada.executeQuery();
			if (resultado.next()) {
				
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				String minutos_nacionales = resultado.getString("minutos_nacionales");
				String minutos_internacionales = resultado.getString("minutos_internacionales");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				
				
				tarifa_fijo = new Tarifa_fijo(id_tarifa_fijo, tipo_tarifa, nombre_tarifa, id_operador,
						minutos_nacionales, minutos_internacionales, precio, precio_promocion, precio_pack, 
						duracion_promocion);

				 System.out.println("Tarifa de fijo encontrada: "+tarifa_fijo );
			}
		
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de fijo: "+e.getMessage());
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

		
		return tarifa_fijo;
		
	
	}

	@Override
	public int eliminarTarifa_fijo(int id_tarifa_fijo) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM tarifas_fijo\r\n"
					+ "WHERE id_tarifa_fijo = ?");
			
			consultaPreparada.setInt(1, id_tarifa_fijo);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa fijo borrada correctamente: "+id_tarifa_fijo);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de la Tarifa de Fijo: "+e.getMessage());
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
	public int insertarTarifa_fijo(Tarifa_fijo tarifa_fijo) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO tarifas_fijo ("
					+ " tipo_tarifa, nombre_tarifa, id_operador,\r\n"
					+ "	minutos_nacionales, minutos_internacionales, precio,"
					+ " precio_promocion, precio_pack, \r\n"
					+ "	duracion_promocion)"
					+ "VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, tarifa_fijo.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_fijo.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_fijo.getId_operador());
			consultaPreparada.setString(4, tarifa_fijo.getMinutos_nacionales());
			consultaPreparada.setString(5, tarifa_fijo.getMinutos_internacionales());
			consultaPreparada.setFloat(6, tarifa_fijo.getPrecio());
			consultaPreparada.setFloat(7, tarifa_fijo.getPrecio_promocion());
			consultaPreparada.setFloat(8, tarifa_fijo.getPrecio_pack());
			consultaPreparada.setString(9, tarifa_fijo.getDuracion_promocion());
			
	
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa de fijo insertada: ");
			System.out.println(tarifa_fijo);

		} catch (SQLException e) {
			System.out.println("Error al realizar la insercion de la tarifa fijo: " + tarifa_fijo
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
	public int actualizarTarifa_fijo(Tarifa_fijo tarifa_fijo) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE tarifas_fijo \r\n"
					+ "SET tipo_tarifa=?,\r\n"
					+ "    nombre_tarifa=? \r\n"
					+ "    id_operador=?, \r\n"
					+ "    minutos_nacionales=?, \r\n"
					+ "    minutos_internacionales=?, \r\n"
					+ "    precio=? \r\n"
					+ "    precio_promocion=?, \r\n"
					+ "    precio_pack=?, \r\n"
					+ "    duracion_promocion=? \r\n"
					+ "WHERE id_tarifa_fijo=?");
			
			consultaPreparada.setString(1, tarifa_fijo.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_fijo.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_fijo.getId_operador());
			consultaPreparada.setString(4, tarifa_fijo.getMinutos_nacionales());
			consultaPreparada.setString(5, tarifa_fijo.getMinutos_internacionales());
			consultaPreparada.setFloat(6, tarifa_fijo.getPrecio());
			consultaPreparada.setFloat(7, tarifa_fijo.getPrecio_promocion());
			consultaPreparada.setFloat(8, tarifa_fijo.getPrecio_pack());
			consultaPreparada.setString(9, tarifa_fijo.getDuracion_promocion());
			consultaPreparada.setInt(10, tarifa_fijo.getId_tarifa_fijo());
			
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Tarifa de fijo actualizado: ");
			System.out.println(tarifa_fijo);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la Tarifa de fijo: "+consultaPreparada
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
