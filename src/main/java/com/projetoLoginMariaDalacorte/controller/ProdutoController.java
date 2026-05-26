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

import com.projetoLoginMariaDalacorte.entity.Produtos;
import com.projetoLoginMariaDalacorte.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Produtos>> buscarTodosProdutos() {
		List<Produtos> produtos = produtoService.buscarTodosProdutos();
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> buscarProdutosPorId(@PathVariable Long id) {
		Produtos produtos = produtoService.buscarProdutosPorId(id);
		if (produtos != null) {
			return ResponseEntity.ok(produtos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Produtos> salvarProdutos(@RequestBody Produtos produtos) {
		Produtos salvarProdutos = produtoService.salvarProdutos(produtos);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvarProdutos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produtos> atualizarProdutos(@PathVariable Long id, @RequestBody Produtos produtos) {
		Produtos atualizarProdutos = produtoService.atualizarProdutos(id, produtos);
		if (atualizarProdutos != null) {
			return ResponseEntity.ok(atualizarProdutos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produtos> deletarProdutos(@PathVariable Long id) {
		boolean apagar = produtoService.deletarProdutos(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}