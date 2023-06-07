package br.unibh.sdm.backend_avaliar.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unibh.sdm.backend_avaliar.entidades.Avaliar;
import br.unibh.sdm.backend_avaliar.persistencia.AvaliarRepository;

/**
 * Classe de testes para a entidade Cliente.
 *  <br>
 * Para rodar, antes sete a seguinte variavel de ambiente: -Dspring.config.location=C:/Users/jhcru/sdm/backend-cliente/
 *  <br>
 * Neste diretoio, criar um arquivo application.properties contendo as seguitnes variaveis:
 * <br>
 * # Connection parameters<br>
 * spring.datasource.url= jdbc:postgresql://HOST:5432/DBNAME<br>
 * spring.datasource.username=USER<br>
 * spring.datasource.password=PASSWORD<br>
 * <br>
 * spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true<br>
 * spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect<br>
 * <br>
 * # Hibernate ddl auto (create, create-drop, validate, update)<br>
 * spring.jpa.hibernate.ddl-auto=create<br>
 * @author jhcru
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AvaliarTests {

    private static Logger LOGGER = LoggerFactory.getLogger(AvaliarTests.class);
    
	@Autowired
	private AvaliarRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {
		LOGGER.info("Criando Avaliações...");
		Avaliar c1 = new Avaliar(null,"lucas","òtima loja virtual","Baixa latencia","pouca demanda","123@gmail.com","123senha");
		repository.save(c1);

		Avaliar c2 = new Avaliar(null,"maike","pésima loja virtual","muita latencia","pessima gestão","456@gmail.com","456senha");
		repository.save(c2);

		Avaliar c3 = new Avaliar(null,"arthur","loja razoavel","caiu algumas vezes","demora para finalizar compra","789@gmail.com","789senha");
		repository.save(c3);
		
		LOGGER.info("Pesquisado todas Avaliações ");
		Iterable<Avaliar> lista = repository.findAll();
		assertNotNull(lista.iterator());

		for (Avaliar avaliar : lista) {
			LOGGER.info(avaliar.toString());
		}

		List<Avaliar> avaliar = IteratorUtils.toList(lista.iterator());

		assertEquals(avaliar.size(), 5);
		LOGGER.info("Encontrado: {}", avaliar.size());
	}
	
	
	@Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo Avaliações...");

		Iterable<Avaliar> resultAntesDeDeletar = repository.findAll();

		for (Avaliar avaliar : resultAntesDeDeletar) {
			LOGGER.info("Excluindo avaliação com id  = " + avaliar.getId());
			repository.delete(avaliar);
		}

		List<Avaliar> resultDepoisDeDeletar = IteratorUtils.toList(repository.findAll().iterator());

		assertEquals(resultDepoisDeDeletar.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
	
	
}
