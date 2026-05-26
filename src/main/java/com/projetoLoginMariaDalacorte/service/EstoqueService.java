package com.projetoLoginMariaDalacorte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoLoginMariaDalacorte.entity.Estoque;
import com.projetoLoginMariaDalacorte.repository.EstoqueRepository;

@Service
public class EstoqueService {
	private final EstoqueRepository estoqueRepository;

	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	public List<Estoque> buscarTodosEstoque() {
		return estoqueRepository.findAll();
	}

	public Estoque buscarEstoquePorId(Long id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return estoque.orElse(null);
	}

	public Estoque salvarEstoque(Estoque atEstoque) {
		return estoqueRepository.save(atEstoque);
	}

	public Estoque atualizarEstoque(Long id, Estoque atEstoque) {
		Optional<Estoque> exeEstoque = estoqueRepository.findById(id);
		if (exeEstoque.isPresent()) {
			atEstoque.setId(id);
			return estoqueRepository.save(atEstoque);
		} else {
			return null;
		}
	}

	public boolean deletarEstoque(Long id) {
		Optional<Estoque> exeEstoque = estoqueRepository.findById(id);
		if (exeEstoque.isPresent()) {
			estoqueRepository.deleteById(id);
			return true;
		}return false;
	}
}
