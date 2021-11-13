package br.com.softblue.bluefood.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.cliente.ClienteRepository;
import br.com.softblue.bluefood.domain.restaurante.Restaurante;
import br.com.softblue.bluefood.domain.restaurante.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired //to provide an instance when I use this class
	private RestauranteRepository restauranteRepository;

	public void saveRestaurente(Restaurante restaurente) throws ValidationException {
		
		if (!validateEmail(restaurente.getEmail(), restaurente.getId())) {
			throw new ValidationException("O e-mail está duplicado");
		}
		
		
		restauranteRepository.save(restaurente);
	}
	
	private boolean validateEmail(String email, Integer id){
		Restaurante restaurante = restauranteRepository.findByEmail(email);
		
	if (restaurante != null) {
		if(id == null) {
			return false;
		}
		if(!restaurante.getId().equals(id)) {
			return false;
		}
	}
	return true;
	}
}
