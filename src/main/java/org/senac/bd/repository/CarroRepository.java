package org.senac.bd.repository;

import java.math.BigDecimal;
import java.util.List;

import org.senac.bd.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * https://docs.spring.io/spring-data/jpa/docs/2.2.2.RELEASE/reference/html/#jpa.query-methods
 * @author fabiano
 *
 */
public interface CarroRepository extends JpaRepository<Carro, Integer>{
	
	public Carro findByNome(String nome);
	
	@Query("select c from Carro c "
			+ "where lower(c.nome) = lower(?1) "
			+ "and c.marca.id = ?2")
	public Carro findByNomeAndMarca(String nome, Integer marcaId);
	
	public List<Carro> findByNomeStartsWith(String nome);
	
	public List<Carro> findByNomeEndsWith(String nome);
	
	public List<Carro> findByNomeContaining(String nome);
	
	public List<Carro> findByPrecoLessThan(BigDecimal preco);
	
	public List<Carro> findByPrecoGreaterThan(BigDecimal preco);
	
	
	
	

}
