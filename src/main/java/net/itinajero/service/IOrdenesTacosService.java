package net.itinajero.service;

import net.itinajero.model.OrdenTacos;

public interface IOrdenesTacosService {
	void borrarOrdenesTacos();
	OrdenTacos buscarPorId(long idOrdenTacos);
}
