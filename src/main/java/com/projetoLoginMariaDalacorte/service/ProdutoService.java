package com.projetoLoginMariaDalacorte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoLoginMariaDalacorte.entity.Produtos;
import com.projetoLoginMariaDalacorte.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
	public ProdutoService (ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List <Produtos> buscarTodosProdutos (){
		return produtoRepository.findAll();
	}
	
	public Produtos buscarProdutosPorId (Long id) {
		Optional <Produtos> produtos = produtoRepository.findById(id);
		return produtos.orElse (null);
	}
	
	public Produtos salvarProdutos (Produtos atProdutos) {
		return produtoRepository.save(atProdutos);
	}
	
	public Produtos atualizarProdutos (Long id, Produtos atProdutos) {
		Optional <Produtos> exeProdutos = produtoRepository.findById(id);
		if (exeProdutos.isPresent()) {
			atProdutos.setId(id);
			return produtoRepository.save(atProdutos);
		}else {
			return null;
		}
	}
	
	public boolean deletarProdutos (Long id) {
		Optional <Produtos> exeProdutos = produtoRepository.findById(id);
		if (exeProdutos.isEmpty()) {
			produtoRepository.deleteById(id);
			return true;
		}return false;
	}

}
