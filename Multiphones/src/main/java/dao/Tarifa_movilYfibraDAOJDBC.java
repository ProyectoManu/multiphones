package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Tarifa_fibra;
import modelo.Tarifa_movil;
import modelo.Tarifa_movilYfibra;
import utilidades.ConexionBD;

public class Tarifa_movilYfibraDAOJDBC implements Tarifa_movilYfibraDAO {
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	
	public Tarifa_movilYfibraDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Tarifa_movilYfibra> getTarifa_movilYfibra() {
		List<Tarifa_movilYfibra> listaTarifa_movilYfibra = new ArrayList<Tarifa_movilYfibra>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from tarifas_movilYfibra");
			while (resultado.next()) {
				int id_tarifa_movilYfibra = resultado.getInt("id_tarifa_movilYfibra");
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				String gigas = resultado.getString("gigas");
				String minutos = resultado.getString("minutos");
				int velocidad_fibra = resultado.getInt("velocidad_fibra");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				boolean acumula = resultado.getBoolean("acumula");
				boolean comparte = resultado.getBoolean("comparte");
				boolean fijo = resultado.getBoolean("fijo");
				
				Tarifa_movilYfibra tarifa_movilYfibra = new Tarifa_movilYfibra(id_tarifa_movilYfibra,
						tipo_tarifa, nombre_tarifa, id_operador, gigas, minutos, velocidad_fibra, 
						precio, precio_promocion, precio_pack, duracion_promocion, acumula, comparte,
						fijo);
				
			
				listaTarifa_movilYfibra.add(tarifa_movilYfibra);
			}
			System.out.println("Añadiendo Tarifa de móvil + fibra: ");
			System.out.println(listaTarifa_movilYfibra);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de móvil + fibra: "+e.getMessage());
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

		
		return listaTarifa_movilYfibra;
	}

	@Override
	public Tarifa_movilYfibra getTarifa_movilYfibra(int id_tarifa_movilYfibra) {
		Connection con = conexion.getConexion();
		Tarifa_movilYfibra tarifa_movilYfibra = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from tarifas_movilYfibra"
					+ " where id_tarifa_movilYfibra = ?");
			consultaPreparada.setInt(1, id_tarifa_movilYfibra);
			resultado=consultaPreparada.executeQuery();
			if (resultado.next()) {
				
				String tipo_tarifa = resultado.getString("tipo_tarifa");
				String nombre_tarifa = resultado.getString("nombre_tarifa");
				int id_operador = resultado.getInt("id_operador");
				String gigas = resultado.getString("gigas");
				String minutos = resultado.getString("minutos");
				int velocidad_fibra = resultado.getInt("velocidad_fibra");
				float precio = resultado.getFloat("precio");
				float precio_promocion= resultado.getFloat("precio_promocion");
				float precio_pack = resultado.getFloat("precio_pack");
				String duracion_promocion = resultado.getString("duracion_promocion");
				boolean acumula = resultado.getBoolean("acumula");
				boolean comparte = resultado.getBoolean("comparte");
				boolean fijo = resultado.getBoolean("fijo");
				
				 tarifa_movilYfibra = new Tarifa_movilYfibra(id_tarifa_movilYfibra,
						tipo_tarifa, nombre_tarifa, id_operador, gigas, minutos, velocidad_fibra, 
						precio, precio_promocion, precio_pack, duracion_promocion, acumula, comparte,
						fijo);
				 System.out.println("Tarifa de movil + fibra encontrada: "+tarifa_movilYfibra );
	
			}
		
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Tarifas de móvil + fibra: "+e.getMessage());
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

		
		return tarifa_movilYfibra;
	}

	@Override
	public int eliminarTarifa_movilYfibra(int id_tarifa_movilYfibra) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM tarifas_movilYfibra\r\n"
					+ "WHERE id_tarifa_movilYfibra = ?");
			
			consultaPreparada.setInt(1, id_tarifa_movilYfibra);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa Móvil + Fibra borrada correctamente: "+id_tarifa_movilYfibra);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de la Tarifa de Móvil + Fibra: "+e.getMessage());
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
	public int insertarTarifa_movilYfibra(Tarifa_movilYfibra tarifa_movilYfibra) {
	
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO tarifas_movilYfibra (tipo_tarifa,\r\n"
					+ "						nombre_tarifa, id_operador,gigas,minutos, velocidad_fibra"
					+ "						precio, precio_promocion, precio_pack, duracion_promocion, acumula,"
					+ "						comparte, fijo)"
					+ "VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, tarifa_movilYfibra.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_movilYfibra.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_movilYfibra.getId_operador());
			consultaPreparada.setString(4, tarifa_movilYfibra.getGigas());
			consultaPreparada.setString(5, tarifa_movilYfibra.getMinutos());
			consultaPreparada.setInt(6, tarifa_movilYfibra.getVelocidad_fibra());
			consultaPreparada.setFloat(7, tarifa_movilYfibra.getPrecio());
			consultaPreparada.setFloat(8, tarifa_movilYfibra.getPrecio_promocion());
			consultaPreparada.setFloat(9, tarifa_movilYfibra.getPrecio_pack());
			consultaPreparada.setString(10, tarifa_movilYfibra.getDuracion_promocion());
			consultaPreparada.setBoolean(11, tarifa_movilYfibra.isAcumula());
			consultaPreparada.setBoolean(12, tarifa_movilYfibra.isComparte());
			consultaPreparada.setBoolean(13, tarifa_movilYfibra.isFijo());
	
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Tarifa de móvil y fibra insertada: ");
			System.out.println(tarifa_movilYfibra);

		} catch (SQLException e) {
			System.out.println("Error al realizar la insercion de la tarifa de móvil y fibra: " + tarifa_movilYfibra
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
	public int actualizarTarifa_movilYfibra(Tarifa_movilYfibra tarifa_movilYfibra) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE tarifas_movilYfibra \r\n"
					+ "SET tipo_tarifa=?,\r\n"
					+ "    nombre_tarifa=? \r\n"
					+ "    id_operador=?, \r\n"
					+ "    gigas=?, \r\n"
					+ "    minutos=?, \r\n"
					+ "    velocidad_fibra=?, \r\n"
					+ "    precio=? \r\n"
					+ "    precio_promocion=?, \r\n"
					+ "    precio_pack=?, \r\n"
					+ "    duracion_promocion=? \r\n"
					+ "    acumula=?, \r\n"
					+ "    comparte=?, \r\n"
					+ "    fijo=?, \r\n"
					+ "WHERE id_tarifa_movilYfibra=?");
			
			consultaPreparada.setString(1, tarifa_movilYfibra.getTipo_tarifa());
			consultaPreparada.setString(2,tarifa_movilYfibra.getNombre_tarifa());
			consultaPreparada.setInt(3, tarifa_movilYfibra.getId_operador());
			consultaPreparada.setString(4, tarifa_movilYfibra.getGigas());
			consultaPreparada.setString(5, tarifa_movilYfibra.getMinutos());
			consultaPreparada.setInt(6, tarifa_movilYfibra.getVelocidad_fibra());
			consultaPreparada.setFloat(7, tarifa_movilYfibra.getPrecio());
			consultaPreparada.setFloat(8, tarifa_movilYfibra.getPrecio_promocion());
			consultaPreparada.setFloat(9, tarifa_movilYfibra.getPrecio_pack());
			consultaPreparada.setString(10, tarifa_movilYfibra.getDuracion_promocion());
			consultaPreparada.setBoolean(11, tarifa_movilYfibra.isAcumula());
			consultaPreparada.setBoolean(12, tarifa_movilYfibra.isComparte());
			consultaPreparada.setBoolean(13, tarifa_movilYfibra.isFijo());
			consultaPreparada.setInt(14,tarifa_movilYfibra.getId_tarifa_movilYfibra());
			
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Tarifa de móvil + fibra actualizada: ");
			System.out.println(tarifa_movilYfibra);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la Tarifa de móvil + fibra: "+consultaPreparada
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
