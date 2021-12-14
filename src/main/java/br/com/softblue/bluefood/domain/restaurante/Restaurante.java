package br.com.softblue.bluefood.domain.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@SuppressWarnings("serial")
@Table(name = "restaurante")

public class Restaurante extends Usuario {

	
	@NotBlank(message = "O CPF n�o pode ser vazio")
	@Pattern(regexp = "[0-9]{10,14}", message = "O CNPJ possui formato inv�lido")
	@Column(length = 14, nullable = false)
	private String cnpj;
	
	@Size(max=80)
	private String logotipo;
	
	private transient MultipartFile logotipoFile;
	
	@NotNull(message = "A taxa de entrega n�o pode ser vazia")
	@Min(0)
	@Max(99)
	private BigDecimal taxaEntrega;
	
	@NotNull(message = " O tempo de entrega n�o pode ser vazia")
	@Min(0)
	@Max(120)
	private Integer tempoEntregaBase; 
	
	@ManyToMany
	@JoinTable(
			name = "restaurante_has_categoria",
			joinColumns = @JoinColumn(name = "restaurante_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_restaurante_id")
			)
	@Size(min = 1, message = "O restaurante precisa ter pelo menos uma categoria")
	@ToString.Exclude
	private Set<CategoriaRestaurante> categorias = new HashSet<>(0);
	
	public void setLogotipoFileName() {
	if(getId() == null) {
		throw  new IllegalStateException("� preciso primeiro gravar o registro");
	}
	//TODO: Trocar forma de ler a extens�o
	this.logotipo = String.format("%04d-logo.%s", getId(), ".png");
	
	}
		
}
