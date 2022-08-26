package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Operador;
import utilidades.ConexionBD;

public class OperadorDAOJDBC implements OperadorDAO {

	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;

	
	public OperadorDAOJDBC() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Operador> getOperador() {
		List<Operador> listaOperadores = new ArrayList<Operador>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from operadores");
			while (resultado.next()) {
				int id_operador = resultado.getInt("id_operador");
				String nombre_operador = resultado.getString("nombre_operador");
				String red_movil = resultado.getString("red_movil");
				String red_fija = resultado.getString("red_fija");
				
				
				Operador operador = new Operador(id_operador, nombre_operador, red_movil, red_fija);

				listaOperadores.add(operador);
			}
			System.out.println("Añadiendo Operadores: ");
			System.out.println(listaOperadores);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Operadores: "+e.getMessage());
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

		
		return listaOperadores;
		
	}

	@Override
	public int eliminarOperador(int id_operador) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM operadores\r\n"
					+ "WHERE id_operador = ?");
			
			consultaPreparada.setInt(1, id_operador);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Operador borrado correctamente: "+id_operador);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado del operador: "+e.getMessage());
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
	public Operador getOperador(int id_operador) {
		Connection con = conexion.getConexion();
		Operador operador = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from operadores"
					+ " where id_operador = ?");
			consultaPreparada.setInt(1, id_operador);
			resultado=consultaPreparada.executeQuery();
			if (resultado.next()) {
				String nombre_operador = resultado.getString("nombre_operador");
				String red_movil = resultado.getString("red_movil");
				String red_fija = resultado.getString("red_fija");
				
				
				 operador = new Operador(id_operador, nombre_operador, red_movil, red_fija);

				 System.out.println("Operador encontrado: "+operador);
			}
		
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Operadores: "+e.getMessage());
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

		
		return operador;
	}

	@Override
	public int insertarOperador(Operador operador) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("INSERT INTO operadores (nombre_operador, red_movil, red_fija)"
					+ "VALUES "
					+ "(?,?,?)");
			
			consultaPreparada.setString(1, operador.getNombre_operador());
			consultaPreparada.setString(2, operador.getRed_movil());
			consultaPreparada.setString(3, operador.getRed_fija());
			
			
			
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Operador insertado: ");
			System.out.println(operador);

		} catch (SQLException e) {
			System.out.println("Error al realizar la insercion del operador: " + operador
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
	public int actualizarOperador(Operador operador) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE operadores \r\n"
					+ "SET nombre_operador=?,\r\n"
					+ "    red_movil=? \r\n"
					+ "    red_fija=?, \r\n"
					+ "WHERE id_operador=?");
			
			consultaPreparada.setString(1, operador.getNombre_operador());
			consultaPreparada.setString(2, operador.getRed_movil());
			consultaPreparada.setString(3, operador.getRed_fija());
			consultaPreparada.setInt(4, operador.getId_operador());
			
			resultado=consultaPreparada.executeUpdate();
			
			System.out.println("Operador actualizado: ");
			System.out.println(operador);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion del operador: "+consultaPreparada
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
