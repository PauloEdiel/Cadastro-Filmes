package br.com.paulocavalcante.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulocavalcante.model.FilmeModel;
import br.com.paulocavalcante.model.ResponseModel;
import br.com.paulocavalcante.repository.FilmeRepository;

@RestController
@RequestMapping("/service")
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	// SALVAR UM NOVO REGISTRO
	@RequestMapping(value = "/filme", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody FilmeModel filme) {

		try {

			this.filmeRepository.save(filme);

			return new ResponseModel(1, "Registro salvo com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	// ATUALIZAR A DESCRICAO DO FILME
	@RequestMapping(value = "/filme", method = RequestMethod.PUT, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody FilmeModel filme) {

		try {

			this.filmeRepository.save(filme);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	// CONSULTAR TODOS OS FILMES
	@RequestMapping(value = "/filme", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Iterable<FilmeModel> consultar() {

		return this.filmeRepository.findAll();
	}

	// BUSCAR UM FILME PELO CÓDIGO
	@RequestMapping(value = "/filme/{codigo}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Optional<FilmeModel> buscar(@PathVariable("codigo") Long codigo) {

		return this.filmeRepository.findById(codigo);
	}

	// EXCLUIR UM FILME PELO CÓDIGO
	@RequestMapping(value = "/filme/{codigo}", method = RequestMethod.DELETE, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Long codigo) {
		// Optional<FilmeModel> filmeModel = filmeRepository.findById(codigo);
		try {

			filmeRepository.deleteById(codigo);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
}
