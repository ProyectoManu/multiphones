package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modelo.Tarifa_movil;
import utilidades.ConexionBD;

public class Tarifa_movilDAOJDBC implements Tarifa_movilDAO {
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	
	public Tarifa_movilDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Tarifa_movil> getTarifa_movil() {
		List<Tarifa_movil> listaTarifa_movil = new ArrayList<Tarifa_movil>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from tarifas_movil");
			while (resultado.next()) {
				int id_tarifa_movil = resultado.getInt("id_tarifa_movil");
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				String gigas = resultado.getString("gigas");
				String minutos = resultado.getString("minutos");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				boolean acumula = resultado.getBoolean("acumula");
				boolean comparte = resultado.getBoolean("comparte");
				
				Tarifa_movil tarifa_movil = new Tarifa_movil(id_tarifa_movil, tipo_tarifa, 
						nombre_tarifa, id_operador, gigas, minutos, precio, precio_promocion,
						precio_pack, duracion_promocion, acumula, comparte);
				
			
				listaTarifa_movil.add(tarifa_movil);
			}
			System.out.println("Añadiendo Tarifa de móvil: ");
			System.out.println(listaTarifa_movil);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de móvil: "+e.getMessage());
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

		
		return listaTarifa_movil;
	}

	@Override
	public Tarifa_movil getTarifa_movil(int id_tarifa_movil) {
		Connection con = conexion.getConexion();
		Tarifa_movil tarifa_movil = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from tarifas_movil"
					+ " where id_tarifa_movil = ?");
			consultaPreparada.setInt(1, id_tarifa_movil);
			resultado=consultaPreparada.executeQuery();
			if (resultado.next()) {
				
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				String gigas = resultado.getString("gigas");
				String minutos = resultado.getString("minutos");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				boolean acumula = resultado.getBoolean("acumula");
				boolean comparte = resultado.getBoolean("comparte");
				
				tarifa_movil = new Tarifa_movil(id_tarifa_movil, tipo_tarifa, 
						nombre_tarifa, id_operador, gigas, minutos, precio, precio_promocion,
						precio_pack, duracion_promocion, acumula, comparte);

				 System.out.println("Tarifa de fibra encontrada: "+tarifa_movil );
			}
		
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de movil: "+e.getMessage());
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

		
		return tarifa_movil;
	}

	@Override
	public int eliminarTarifa_movil(int id_tarifa_movil) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM tarifas_movil\r\n"
					+ "WHERE id_tarifa_movil = ?");
			
			consultaPreparada.setInt(1, id_tarifa_movil);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa fibra borrada correctamente: "+id_tarifa_movil);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de la Tarifa de Móvil: "+e.getMessage());
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
	public int insertarTarifa_movil(Tarifa_movil tarifa_movil) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO tarifas_movil (tipo_tarifa,\r\n"
					+ "						nombre_tarifa, id_operador,gigas,minutos, precio,\r\n"
					+ "						precio_promocion, precio_pack, duracion_promocion, acumula,"
					+ "						comparte)"
					+ "VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, tarifa_movil.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_movil.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_movil.getId_operador());
			consultaPreparada.setString(4, tarifa_movil.getGigas());
			consultaPreparada.setString(5, tarifa_movil.getMinutos());
			consultaPreparada.setFloat(6, tarifa_movil.getPrecio());
			consultaPreparada.setFloat(7, tarifa_movil.getPrecio_promocion());
			consultaPreparada.setFloat(8, tarifa_movil.getPrecio_pack());
			consultaPreparada.setString(9, tarifa_movil.getDuracion_promocion());
			consultaPreparada.setBoolean(10, tarifa_movil.isAcumula());
			consultaPreparada.setBoolean(11, tarifa_movil.isComparte());
	
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa de móvil insertada: ");
			System.out.println(tarifa_movil);

		} catch (SQLException e) {
			System.out.println("Error al realizar la insercion de la tarifa de móvil: " + tarifa_movil
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
	public int actualizarTarifa_movil(Tarifa_movil tarifa_movil) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE tarifas_movil \r\n"
					+ "SET tipo_tarifa=?,\r\n"
					+ "    nombre_tarifa=? \r\n"
					+ "    id_operador=?, \r\n"
					+ "    gigas=?, \r\n"
					+ "    minutos=?, \r\n"
					+ "    precio=? \r\n"
					+ "    precio_promocion=?, \r\n"
					+ "    precio_pack=?, \r\n"
					+ "    duracion_promocion=? \r\n"
					+ "    acumula=?, \r\n"
					+ "    comparte=?, \r\n"
					+ "WHERE id_tarifa_movil=?");
			
			consultaPreparada.setString(1, tarifa_movil.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_movil.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_movil.getId_operador());
			consultaPreparada.setString(4, tarifa_movil.getGigas());
			consultaPreparada.setString(5, tarifa_movil.getMinutos());
			consultaPreparada.setFloat(6, tarifa_movil.getPrecio());
			consultaPreparada.setFloat(7, tarifa_movil.getPrecio_promocion());
			consultaPreparada.setFloat(8, tarifa_movil.getPrecio_pack());
			consultaPreparada.setString(9, tarifa_movil.getDuracion_promocion());
			consultaPreparada.setBoolean(10, tarifa_movil.isAcumula());
			consultaPreparada.setBoolean(11, tarifa_movil.isComparte());
			consultaPreparada.setInt(12, tarifa_movil.getId_tarifa_movil());
			
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Tarifa de móvil actualizado: ");
			System.out.println(tarifa_movil);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la Tarifa de móvil: "+consultaPreparada
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
