package net.itinajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import net.itinajero.service.IOrdenesTacosService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private IOrdenesTacosService ordenesService;
	
	public AdminController(IOrdenesTacosService ordenesService) {
		this.ordenesService = ordenesService;
	}
	
	@GetMapping("/deleteOrders")
	public String deleteAllOrders() {
		ordenesService.borrarOrdenesTacos();
		return "redirect:/";
	}
	
	@GetMapping("/buscarPorId/{idOrdenTacos}")
	public String findById(@PathVariable("idOrdenTacos") long idOrdenTacos) {
		ordenesService.buscarPorId(idOrdenTacos);
		return "redirect:/";
	}
}
