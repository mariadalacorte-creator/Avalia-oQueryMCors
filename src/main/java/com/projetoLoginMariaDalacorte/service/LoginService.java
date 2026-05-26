package com.projetoLoginMariaDalacorte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoLoginMariaDalacorte.entity.Login;
import com.projetoLoginMariaDalacorte.repository.LoginRepository;

@Service
public class LoginService {
	private final LoginRepository LoginRepository;
	
	public LoginService (LoginRepository loginRepository) {
		this.LoginRepository = loginRepository;
	}
	
	public List <Login> buscarTodosLogin (){
		return LoginRepository.findAll();
	}
	
	public Login buscarLoginPorId (Long id) {
		Optional <Login> login = LoginRepository.findById(id);
		return login.orElse (null);
	}
	
	public Login salvarLogin (Login atLogin) {
		return LoginRepository.save(atLogin);
	}
	
	public Login atualizarLogin (Long id, Login atLogin) {
		Optional <Login> exeLogin = LoginRepository.findById(id);
		if (exeLogin.isPresent()) {
			atLogin.setId(id);
			return LoginRepository.save(atLogin);
		}else {
			return null;
		}
	}
	
	public boolean deletarLogin (Long id) {
		Optional <Login> exeLogin = LoginRepository.findById(id);
		if (exeLogin.isEmpty()) {
			LoginRepository.deleteById(id);
			return true;
		}return false;
	}
	
	public Login authenticate(String username, String password) {
		Login user = LoginRepository.findByUsername(username);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}return null;
	}

}
