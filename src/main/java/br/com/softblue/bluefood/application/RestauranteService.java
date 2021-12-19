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
	
	@Autowired
	private ImageService imageService;

	public void saveRestaurante(Restaurante restaurante) throws ValidationException {		
		if (!validateEmail(restaurante.getEmail(), restaurante.getId())) {
			throw new ValidationException("O e-mail está duplicado");
		}
		
		
		if(restaurante.getId() != null) {
			Restaurante restauranteDB = restauranteRepository.findById(restaurante.getId()).orElseThrow();
			restaurante.setSenha(restauranteDB.getSenha());
			
		}else {
			restaurante.encryptPassword();			
			restaurante = restauranteRepository.save(restaurante);
			restaurante.setLogotipoFileName();
			imageService.uploadLogotipo(restaurante.getLogotipoFile(), restaurante.getLogotipo());
			//TODO: Upload
		}
		
		
		
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
