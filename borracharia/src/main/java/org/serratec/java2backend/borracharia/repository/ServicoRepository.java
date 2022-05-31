package org.serratec.java2backend.borracharia.repository;

import java.util.List;

import org.serratec.java2backend.borracharia.dto.RelatorioDTO;
import org.serratec.java2backend.borracharia.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	
	@Query(value="select \r\n"
			+ "c2.CLIENTE_TX_NOME as cliente,\r\n"
			+ "c.CARRO_TX_MODELO as modelo,\r\n"
			+ "s.SERVICO_TX_TIPO as descricaoServico,\r\n"
			+ "s.SERVICO_NUM_VALOR  as valor\r\n"
			+ "from servico s join carro c on(s.CARRO_ID=c.carro_cd_id)\r\n"
			+ "join cliente c2 on(c2.cliente_cd_id=c.CLIENTE_ID)\r\n"
			+ "order by s.SERVICO_CD_ID \r\n"
			+ "desc\r\n"
			+ "limit 3", nativeQuery=true)
	
	List<RelatorioDTO> relatorio();

}
