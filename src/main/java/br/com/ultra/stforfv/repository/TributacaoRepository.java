package br.com.ultra.stforfv.repository;

import br.com.ultra.stforfv.domain.entidades.Tributacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TributacaoRepository extends JpaRepository<Tributacao, Integer>{

    @Query(value = "select codtributacao, dsctributacao, per_st, per_base_st, per_st_est_simples, per_ICMS_efetiva, per_base_icms " +
            "from tributacoes where codtributacao = :codtributacao", nativeQuery = true)
    Tributacao findByCodigo(@Param("codtributacao") Integer codigo);
}
