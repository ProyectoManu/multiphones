package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Tarifa_fibra;
import utilidades.ConexionBD;

public class Tarifa_fibraDAOJDBC implements Tarifa_fibraDAO {
	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	
	public Tarifa_fibraDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Tarifa_fibra> getTarifa_fibra() {
		List<Tarifa_fibra> listaTarifa_fibra = new ArrayList<Tarifa_fibra>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from tarifas_fibra");
			while (resultado.next()) {
				int id_tarifa_fibra = resultado.getInt("id_tarifa_fibra");
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				int velocidad_fibra = resultado.getInt("velocidad_fibra");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				boolean fijo = resultado.getBoolean("fijo");
				
				
				Tarifa_fibra tarifa_fibra = new Tarifa_fibra(id_tarifa_fibra, tipo_tarifa,
						nombre_tarifa, id_operador, velocidad_fibra, precio,
						precio_promocion, precio_pack, duracion_promocion, fijo);
				
			
				listaTarifa_fibra.add(tarifa_fibra);
			}
			System.out.println("Añadiendo Tarifa de fibra: ");
			System.out.println(listaTarifa_fibra);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de fibra: "+e.getMessage());
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

		
		return listaTarifa_fibra;
	}

	@Override
	public Tarifa_fibra getTarifa_fibra(int id_tarifa_fibra) {
		Connection con = conexion.getConexion();
		Tarifa_fibra tarifa_fibra = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from tarifas_fibra"
					+ " where id_tarifa_fibra = ?");
			consultaPreparada.setInt(1, id_tarifa_fibra);
			resultado=consultaPreparada.executeQuery();
			if (resultado.next()) {
				
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				int velocidad_fibra = resultado.getInt("velocidad_fibra");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				boolean fijo = resultado.getBoolean("fijo");
				
				 tarifa_fibra = new Tarifa_fibra(id_tarifa_fibra, tipo_tarifa,
						nombre_tarifa, id_operador, velocidad_fibra, precio,
						precio_promocion, precio_pack, duracion_promocion, fijo);

				 System.out.println("Tarifa de fibra encontrada: "+tarifa_fibra );
			}
		
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de fibra: "+e.getMessage());
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

		
		return tarifa_fibra;
	}

	@Override
	public int eliminarTarifa_fibra(int id_tarifa_fibra) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM tarifas_fibra\r\n"
					+ "WHERE id_tarifa_fibra = ?");
			
			consultaPreparada.setInt(1, id_tarifa_fibra);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa fibra borrada correctamente: "+id_tarifa_fibra);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de la Tarifa de Fibra: "+e.getMessage());
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
	public int insertarTarifa_fibra(Tarifa_fibra tarifa_fibra) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO tarifas_fibra (tipo_tarifa,\r\n"
					+ "						nombre_tarifa, id_operador, velocidad_fibra, precio,\r\n"
					+ "						precio_promocion, precio_pack, duracion_promocion, fijo)"
					+ "VALUES "
					+ "(?,?,?,?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, tarifa_fibra.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_fibra.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_fibra.getId_operador());
			consultaPreparada.setInt(4, tarifa_fibra.getVelocidad_fibra());
			consultaPreparada.setFloat(5, tarifa_fibra.getPrecio());
			consultaPreparada.setFloat(6, tarifa_fibra.getPrecio_promocion());
			consultaPreparada.setFloat(7, tarifa_fibra.getPrecio_pack());
			consultaPreparada.setString(8, tarifa_fibra.getDuracion_promocion());
			consultaPreparada.setBoolean(9, tarifa_fibra.isFijo());
	
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa de fibra insertada: ");
			System.out.println(tarifa_fibra);

		} catch (SQLException e) {
			System.out.println("Error al realizar la insercion de la tarifa fibra: " + tarifa_fibra
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
	public int actualizarTarifa_fibra(Tarifa_fibra tarifa_fibra) {

		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE tarifas_fibra \r\n"
					+ "SET tipo_tarifa=?,\r\n"
					+ "    nombre_tarifa=? \r\n"
					+ "    id_operador=?, \r\n"
					+ "    velocidad_fibra=?, \r\n"
					+ "    precio=? \r\n"
					+ "    precio_promocion=?, \r\n"
					+ "    precio_pack=?, \r\n"
					+ "    duracion_promocion=? \r\n"
					+ "    fijo=?, \r\n"
					+ "WHERE id_tarifa_fibra=?");
			
			consultaPreparada.setString(1, tarifa_fibra.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_fibra.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_fibra.getId_operador());
			consultaPreparada.setInt(4, tarifa_fibra.getVelocidad_fibra());
			consultaPreparada.setFloat(5, tarifa_fibra.getPrecio());
			consultaPreparada.setFloat(6, tarifa_fibra.getPrecio_promocion());
			consultaPreparada.setFloat(7, tarifa_fibra.getPrecio_pack());
			consultaPreparada.setString(8, tarifa_fibra.getDuracion_promocion());
			consultaPreparada.setBoolean(9, tarifa_fibra.isFijo());
			consultaPreparada.setInt(10, tarifa_fibra.getId_tarifa_fibra());
			
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Tarifa de fibra actualizado: ");
			System.out.println(tarifa_fibra);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la Tarifa de fibra: "+consultaPreparada
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
