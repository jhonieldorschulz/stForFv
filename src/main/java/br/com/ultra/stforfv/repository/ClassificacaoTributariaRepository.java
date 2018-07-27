package br.com.ultra.stforfv.repository;

import br.com.ultra.stforfv.domain.entidades.ClassTributariaPK;
import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificacaoTributariaRepository extends JpaRepository<ClassificacaoTributaria, ClassTributariaPK> {

    @Query(value = "select first 1\n" +
            "    ct.seq_pesquisa,\n" +
            "    ct.codtributacao,\n" +
            "    ct.grupo_fiscal,\n" +
            "    ct.codoper,\n" +
            "    ct.regime_estadual,\n" +
            "    ct.uf_emitente,\n" +
            "    ct.uf_destino,\n" +
            "    ct.pessoa_fj,\n" +
            "    ct.codfilial_emitente,\n" +
            "    ct.perc_ctm_st,\n" +
            "    ct.margem_calculo_st,\n" +
            "    ct.idn_st_uso_consumo,\n" +
            "    ct.idnipi_tributado\n" +
            "    from classificacao_tributaria ct where\n" +
            "    ct.grupo_fiscal = :grupo_fiscal\n" +
            "    and ct.codoper = :codoper\n" +
            "    and (ct.codfilial_emitente = :codfilial or ct.codfilial_emitente is null)\n" +
            "    and (ct.uf_emitente = :uf_emit)\n" +
            "    and  (ct.uf_destino = :uf_dest  or ct.uf_destino is null)\n" +
            "    and  (ct.pessoa_fj = :pessoa_fj or ct.pessoa_fj is null or ct.pessoa_fj = '')\n" +
            "    and  (ct.regime_estadual = :regime_estadual or ct.regime_estadual is null)\n" +
            "    order by ct.seq_pesquisa\n", nativeQuery = true)
    ClassificacaoTributaria findByFilters(@Param("grupo_fiscal") Integer grupoFiscal,
                                                                 @Param("codoper") Integer operacao,
                                                                 @Param("codfilial") Integer filial,
                                                                 @Param("uf_emit") String ufEmitente,
                                                                 @Param("uf_dest") String ufDestino,
                                                                 @Param("pessoa_fj") String pessoaPJ,
                                                                 @Param("regime_estadual") String regimeEstadual);
}
