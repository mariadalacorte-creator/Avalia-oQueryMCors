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

import com.projetoLoginMariaDalacorte.entity.Estoque;
import com.projetoLoginMariaDalacorte.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	private final EstoqueService estoqueService;

	public EstoqueController(EstoqueService estoqueService) {
		this.estoqueService = estoqueService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Estoque>> buscarTodosEstoque() {
		List<Estoque> estoque = estoqueService.buscarTodosEstoque();
		return ResponseEntity.ok(estoque);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estoque> buscarEstoquePorId(@PathVariable Long id) {
		Estoque estoque = estoqueService.buscarEstoquePorId(id);
		if (estoque != null) {
			return ResponseEntity.ok(estoque);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Estoque> salvarEstoque(@RequestBody Estoque estoque) {
		Estoque salvarEstoque = estoqueService.salvarEstoque(estoque);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvarEstoque);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estoque> atualizarEstoque(@PathVariable Long id, @RequestBody Estoque estoque) {
		Estoque atualizarEstoque = estoqueService.atualizarEstoque(id, estoque);
		if (atualizarEstoque != null) {
			return ResponseEntity.ok(atualizarEstoque);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Estoque> deletarEstoque(@PathVariable Long id) {
		boolean apagar = estoqueService.deletarEstoque(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
