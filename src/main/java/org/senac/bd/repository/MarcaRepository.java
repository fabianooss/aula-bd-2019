package org.senac.bd.repository;

import java.util.List;

import org.senac.bd.domain.Marca;
import org.senac.bd.vo.MarcaTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

/*select m.nome, sum(c.preco)   from carro c
inner join marca m on c.marca_id = m.id
group by m.nome */

	@Query("select new org.senac.bd.vo.MarcaTotal(m.nome, sum(c.preco)) "
			+ " from Carro c "
			+ " inner join c.marca m "
			+ " group by m.nome")
	List<MarcaTotal> findMarcaTotal();
	

}
