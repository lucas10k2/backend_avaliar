package br.unibh.sdm.backend_avaliar.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.backend_avaliar.entidades.Avaliar;
import br.unibh.sdm.backend_avaliar.persistencia.AvaliarRepository;

/**
 * Classe contendo a logica de negocio para Cliente
 * @author jhcru
 *
 */
@Service
public class AvaliarService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final AvaliarRepository avaliarRepo;

    public AvaliarService(AvaliarRepository avaliarRepository){
        this.avaliarRepo=avaliarRepository;
    }
    
    public List<Avaliar> getAvaliacoes(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todas as avaliações");
        }
        Iterable<Avaliar> lista = this.avaliarRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Avaliar>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    

    public Avaliar getAvaliarById(Long id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando avaliação especifica de id = {}",id);
        }
        Optional<Avaliar> retorno = this.avaliarRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Avaliação com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }
    
    
    public List<Avaliar> getAvaliarByNome(String nome){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando avaliações");
        }
        Iterable<Avaliar> lista = this.avaliarRepo.findByNome(nome);
        if (lista == null) {
        	return new ArrayList<Avaliar>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
    
    public Avaliar saveAvaliar(Avaliar avaliar){
        if(logger.isInfoEnabled()){
            logger.info("Salvando avaliação com os detalhes {}",avaliar.toString());
        }
        return this.avaliarRepo.save(avaliar);
    }
    
    public void deleteAvaliar(Long id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo avaliação com id {}",id);
        }
        this.avaliarRepo.deleteById(id);
    }

    public boolean isAvaliarExists(Avaliar avaliar){
    	Optional<Avaliar> retorno = this.avaliarRepo.findById(avaliar.getId());
        return retorno.isPresent() ? true:  false;
    }

}