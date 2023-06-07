package br.unibh.sdm.backend_avaliar.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.backend_avaliar.entidades.Avaliar;
import br.unibh.sdm.backend_avaliar.negocio.AvaliarService;

/**
 * Classe contendo as definicoes de servicos REST/JSON para Cliente
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "avaliacao")
public class AvaliarController {
   
    private final AvaliarService avaliarService;

    public AvaliarController(AvaliarService avaliarService){
        this.avaliarService=avaliarService;
    }

    @GetMapping(value = "")
    public List<Avaliar> getAvaliar(){
        return avaliarService.getAvaliacoes();
    }
    
    @GetMapping(value="{id}")
    public Avaliar getAvaliarById(@PathVariable Long id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return avaliarService.getAvaliarById(id);
        }
        throw new Exception("Avaliação com id "+id+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Avaliar createAvaliar(@RequestBody @NotNull Avaliar avaliar) throws Exception {
         return avaliarService.saveAvaliar(avaliar);
    }
    
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Avaliar updateAvaliar(@PathVariable Long id, 
    		@RequestBody @NotNull Avaliar avaliar) throws Exception {
         return avaliarService.saveAvaliar(avaliar);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean updateAvaliar(@PathVariable Long id) throws Exception {
         avaliarService.deleteAvaliar(id);
         return true;
    }
    
}