package net.itinajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.itinajero.model.OrdenTacos;

public interface IOrdenesTacosRepository extends JpaRepository<OrdenTacos, Long> {

}
