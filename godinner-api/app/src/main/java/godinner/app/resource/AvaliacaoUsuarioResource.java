package godinner.app.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import godinner.app.model.AvaliacaoUsuario;
import godinner.app.repository.AvaliacaoUsuarioRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/avaliacao")
public class AvaliacaoUsuarioResource {
	
	@Autowired
	AvaliacaoUsuarioRepository avaliacaoUsuarioRepository;
	
	@GetMapping("/todas")
	public List<AvaliacaoUsuario> getAvaliacoesUsuario(){
		return avaliacaoUsuarioRepository.findAll();
	}
	
}
