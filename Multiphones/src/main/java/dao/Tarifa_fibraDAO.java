package dao;

import java.util.List;


import modelo.Tarifa_fibra;

public interface Tarifa_fibraDAO {
	
	List<Tarifa_fibra>getTarifa_fibra();
	Tarifa_fibra getTarifa_fibra(int id_tarifa_fibra);
	int eliminarTarifa_fibra(int id_tarifa_fibra);
	int insertarTarifa_fibra(Tarifa_fibra tarifa_fibra);
	int actualizarTarifa_fibra(Tarifa_fibra tarifa_fibra);
}
