package com.projetoLoginMariaDalacorte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoLoginMariaDalacorte.entity.Login;
import com.projetoLoginMariaDalacorte.repository.LoginRepository;

@Service
public class LoginService {
	private final LoginRepository loginRepository;
	
	public LoginService (LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	public List <Login> buscarTodosLogin (){
		return loginRepository.findAll();
	}
	
	public Login buscarLoginPorId (Long id) {
		Optional <Login> login = loginRepository.findById(id);
		return login.orElse (null);
	}
	
	public Login salvarLogin (Login atLogin) {
		return loginRepository.save(atLogin);
	}
	
	public Login atualizarLogin (Long id, Login atLogin) {
		Optional <Login> exeLogin = loginRepository.findById(id);
		if (exeLogin.isPresent()) {
			atLogin.setId(id);
			return loginRepository.save(atLogin);
		}else {
			return null;
		}
	}
	
	public boolean deletarLogin (Long id) {
		Optional <Login> exeLogin = loginRepository.findById(id);
		if (exeLogin.isEmpty()) {
			loginRepository.deleteById(id);
			return true;
		}return false;
	}
	
	public Login authenticate(String username, String password) {
		Login user = loginRepository.findByUsername(username);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}return null;
	}

}
