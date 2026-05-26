package com.projetoLoginMariaDalacorte.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLoginMariaDalacorte.entity.Login;
import com.projetoLoginMariaDalacorte.service.LoginService;

@RestController
@RequestMapping("/users")
public class LoginController {
private final LoginService loginService;
	
	public LoginController (LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Login>> buscarTodosLogin() {
	List<Login> login = loginService.buscarTodosLogin();
	return ResponseEntity.ok(login);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Login> buscarLoginPorId(@PathVariable Long id) {
	Login login = loginService.buscarLoginPorId(id);
	if (login != null) {
	return ResponseEntity.ok(login);
	} else {
	return ResponseEntity.notFound().build();
	}
	}		

	@PostMapping("/")
	public ResponseEntity<Login> salvarLogin(@RequestBody Login login) {
	Login salvarLogin = loginService.salvarLogin(login);
	return ResponseEntity.status(HttpStatus.CREATED).body(salvarLogin);
	}
	
	@PostMapping("/auth")
	public ResponseEntity <Login> authenticate (@RequestBody Login loginDetails){
		Login authenticatedUser = loginService.authenticate (loginDetails.getUsername(), loginDetails.getPassword());
		
		if (authenticatedUser !=null) {
			authenticatedUser.setPassword(null);
			return ResponseEntity.ok(authenticatedUser);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Login> atualizarLogin(@PathVariable Long id, @RequestBody Login login) {
	Login atualizarLogin = loginService.atualizarLogin(id, login);
	if (atualizarLogin != null) {
	return ResponseEntity.ok(atualizarLogin);
	} else {
	return ResponseEntity.notFound().build();
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Login> deletarLogin(@PathVariable Long id) {
	boolean apagar = loginService.deletarLogin(id);
	if (apagar) {
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	} else {
	return ResponseEntity.notFound().build();
	}
	}

}
