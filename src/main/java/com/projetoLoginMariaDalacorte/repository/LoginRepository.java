package com.projetoLoginMariaDalacorte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoLoginMariaDalacorte.entity.Login;

public interface LoginRepository extends JpaRepository <Login, Long>{
	Login findByUsername(String username);
}
