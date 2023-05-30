package net.itinajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.itinajero.model.Ingrediente;

public interface IIngredientesRepository extends JpaRepository<Ingrediente, String> {

}
