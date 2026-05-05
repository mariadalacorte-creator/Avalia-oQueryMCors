package com.projetoLoginMariaDalacorte.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "produtos")
public class Produtos {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Column
	private String descricao;
	
	@NotBlank
	@NotNull
	@Column
	private String nome;
	
	@NotNull
	@NotBlank
	@Column
	private double preco;
	
	@NotNull
	@NotBlank
	@Column
	private String url;

}
