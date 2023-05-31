package net.itinajero.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import net.itinajero.forms.RegistrationForm;
import net.itinajero.repository.IUsuariosRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private IUsuariosRepository usuariosRepo;
	private PasswordEncoder passwordEncoder;

	public RegistrationController(IUsuariosRepository usuariosRepo, PasswordEncoder passwordEncoder) {
		this.usuariosRepo = usuariosRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	public String registerForm() {
		return "registration";
	}

	@PostMapping
	public String processRegistration(RegistrationForm form) {
		usuariosRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login";
	}

}
