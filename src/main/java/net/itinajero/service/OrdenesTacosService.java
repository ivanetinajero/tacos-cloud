package net.itinajero.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import net.itinajero.model.OrdenTacos;
import net.itinajero.repository.IOrdenesTacosRepository;

@Service
public class OrdenesTacosService implements IOrdenesTacosService {

	@Autowired
	private IOrdenesTacosRepository ordenesRepo;
	
	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public void borrarOrdenesTacos() {
		ordenesRepo.deleteAll();
	}

	/**
	 * The @PostAuthorize annotation provides the ability to access the method result.
	 * In this case, the returnObject is the OrdenTacos returned from the method. If its usuario property has a username that is equal to the authentication’s name property, 
	 * then it will be allowed. To know that, though, the method will need to be executed so that it can return the OrdenTacos object for consideration.
	 */
	@Override	
	@PostAuthorize("hasRole('ADMIN') || returnObject.usuario.username == authentication.name")
	//@PostAuthorize("returnObject.usuario.username == authentication.name")
	//@PostAuthorize("hasRole('ADMIN') || returnObject.cvvTarjeta == '365'")
	public OrdenTacos buscarPorId(long idOrdenTacos) {
		Optional<OrdenTacos> optional = ordenesRepo.findById(idOrdenTacos);
		if (optional.isPresent()) {
			System.out.println("@PostAuthorize buscarPorId:" + optional.get());
			return optional.get();
		}	
		return null;
	}

}
