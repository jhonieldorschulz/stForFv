package br.com.ultra.stforfv.repository;

import br.com.ultra.stforfv.domain.entidades.GrupoFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoFiscalRepository extends JpaRepository<GrupoFiscal, Integer> {

//    @Query(value = "SELECT CAST(1 AS SMALLINT) AS PRIOR, GRUPO_FISCAL\n" +
//            "          FROM GRUPOS_FISCAIS_FORNEC_PROD\n" +
//            "          WHERE PARCEIRO = :PARCEIRO\n" +
//            "          AND CODPRODUTO = :CODPRODUTO\n" +
//            "          AND CODPRODUTO_CLAS = :CODPRODUTO_CLAS\n" +
//            "    \n" +
//            "          UNION\n" +
//            "    \n" +
//            "          SELECT CAST(2 AS SMALLINT), P.GRUPO_FISCAL\n" +
//            "          FROM PARCEIROS P\n" +
//            "          WHERE P.PARCEIRO = :PARCEIRO\n" +
//            "          AND P.GRUPO_FISCAL IS NOT NULL\n" +
//            "    \n" +
//            "          UNION\n" +
//            "    \n" +
//            "          SELECT CAST(3 AS SMALLINT), COALESCE(C.GRUPO_FISCAL, P.GRUPO_FISCAL)\n" +
//            "          FROM PRODUTOS_CLAS C\n" +
//            "          LEFT JOIN PRODUTOS P ON P.CODPRODUTO = C.CODPRODUTO\n" +
//            "          WHERE C.CODPRODUTO = :CODPRODUTO\n" +
//            "          AND   C.CODPRODUTO_CLAS = :CODPRODUTO_CLAS\n" +
//            "          AND :PARCEIRO IS NULL", nativeQuery = true)
//    GrupoFiscal findGrupoFiscal(@Param("parceiro") Integer parceiro,
//                                @Param("codproduto") Integer codProduto,
//                                @Param("codproduto_clas") Integer codClassificacao);

    @Query(value = "SELECT X.GRUPO_FISCAL, X.ORIGEM FROM\n" +
            "      (\n" +
            "          SELECT DISTINCT GRUPO_FISCAL, 'GRUPOS_FISCAIS_FORNEC_PROD' as ORIGEM\n" +
            "          FROM GRUPOS_FISCAIS_FORNEC_PROD GFPROD WHERE GRUPO_FISCAL IS NOT NULL\n" +
            "    \n" +
            "          UNION\n" +
            "    \n" +
            "          SELECT DISTINCT P.GRUPO_FISCAL, 'PARCEIROS' as ORIGEM\n" +
            "          FROM PARCEIROS P INNER JOIN GRUPOS_FISCAIS GF ON P.GRUPO_FISCAL = GF.GRUPO_FISCAL\n" +
            "          WHERE\n" +
            "          P.GRUPO_FISCAL IS NOT NULL\n" +
            "    \n" +
            "          UNION\n" +
            "    \n" +
            "          SELECT DISTINCT COALESCE(C.GRUPO_FISCAL, P.GRUPO_FISCAL), 'PRODUTOS' AS ORIGEM\n" +
            "          FROM PRODUTOS_CLAS C\n" +
            "          LEFT JOIN PRODUTOS P ON P.CODPRODUTO = C.CODPRODUTO\n" +
            "          INNER JOIN GRUPOS_FISCAIS GF ON GF.grupo_fiscal = COALESCE(C.GRUPO_FISCAL, P.GRUPO_FISCAL)\n" +
            "      ) X\n" +
            "      ORDER BY X.GRUPO_FISCAL", nativeQuery = true)
    List<GrupoFiscal> getGruposFiscais();
}
