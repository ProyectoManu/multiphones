package dao;

import java.util.List;


import modelo.Tarifa_movilYfibra;

public interface Tarifa_movilYfibraDAO {
	
	List<Tarifa_movilYfibra>getTarifa_movilYfibra();
	Tarifa_movilYfibra getTarifa_movilYfibra(int id_tarifa_movilYfibra);
	int eliminarTarifa_movilYfibra(int id_tarifa_movilYfibra);
	int insertarTarifa_movilYfibra(Tarifa_movilYfibra tarifa_movilYfibra);
	int actualizarTarifa_movilYfibra(Tarifa_movilYfibra tarifa_movilYfibra);
}
