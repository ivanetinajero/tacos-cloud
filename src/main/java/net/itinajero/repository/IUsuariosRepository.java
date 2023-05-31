package net.itinajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.itinajero.model.Usuario;

public interface IUsuariosRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}
