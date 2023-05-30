package net.itinajero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;
import net.itinajero.model.OrdenTacos;
import net.itinajero.repository.IOrdenesTacosRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("ordenTacos")
public class OrderController {
	
	private IOrdenesTacosRepository ordenesTacosRepo;
	
	public OrderController(IOrdenesTacosRepository ordenesTacosRepo) {
		this.ordenesTacosRepo = ordenesTacosRepo;
	}
	
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid OrdenTacos order, Errors errors, SessionStatus sessionStatus) {
		
		if (errors.hasErrors()) {
			return "orderForm";
		}
		
		System.out.println("Order submitted: " + order);
		System.out.println("Total Tacos: " + order.getTacos().size());
		ordenesTacosRepo.save(order);
		/**
		 * By calling setComplete(), we are ensuring that the session is cleaned up and ready for a new order 
		 * the next time the user creates a taco
		 */
		sessionStatus.setComplete();
		return "redirect:/";
	}

}
