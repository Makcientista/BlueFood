package br.com.softblue.bluefood.domain.restaurante;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@SuppressWarnings("serial")
@Table(name = "restaurante")

public class Restaurante extends Usuario {

	
	@NotBlank(message = "O CPF não pode ser vazio")
	@Pattern(regexp = "[0-9]{10,14}", message = "O CNPJ possui formato inválido")
	@Column(length = 11, nullable = false)
	private String cnpj;
	
	@Size(max=80)
	private String logotipo;
	
	@NotNull(message = "A taxa de entrega não pode ser vazia")
	@Min(0)
	@Max(99)
	private BigDecimal taxaEntrega;
	
	@NotNull(message = " O tempo de entrega não pode ser vazia")
	@Min(0)
	@Max(120)
	private Integer tempoEntregaBase; 
	
	
	
	
	
}
