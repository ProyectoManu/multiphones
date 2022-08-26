package dao;

import java.util.List;

import modelo.Tarifa_movilYfibra;

public interface Tarifa_movilYfibraDAO {
	
	List<Tarifa_movilYfibra>getTarifa_movilYfibra();
	Tarifa_movilYfibra getTarifa_fibra(int id_tarifa_movilYfibra);

}
