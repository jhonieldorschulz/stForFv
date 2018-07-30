package br.com.ultra.stforfv;

import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;
import br.com.ultra.stforfv.domain.entidades.GrupoFiscal;
import br.com.ultra.stforfv.domain.entidades.Tributacao;
import br.com.ultra.stforfv.domain.tributacoes.Estado;
import br.com.ultra.stforfv.domain.tributacoes.ICMS;
import br.com.ultra.stforfv.domain.tributacoes.Params;
import br.com.ultra.stforfv.domain.tributacoes.ST;
import br.com.ultra.stforfv.repository.ClassificacaoTributariaRepository;
import br.com.ultra.stforfv.repository.GrupoFiscalRepository;
import br.com.ultra.stforfv.repository.TributacaoRepository;
import br.com.ultra.stforfv.service.DBService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StforfvApplicationTests {

    @Autowired
    private ClassificacaoTributariaRepository classificacaoTributariaRepository;

    @Autowired
    private TributacaoRepository tributacaoRepository;

    @Autowired
    private GrupoFiscalRepository grupoFiscalRepository;

    @Autowired
    private DBService dbService;

//    @Test
//    public void contextLoads() {
//    }

    @Test
    public void testeCalculoST_PROVINA() {
//		ClassificacaoTributaria CT = classificacaoTributariaRepository
//				.findByFilters(12, 100, 1, "PR", "PR", "J", null);

        dbService.setDB("PROVINA");

        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("PROVINA\n");

        /**
         * Cenário 1
         */
        System.out.println("Cenário 1");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        processaST(12, 100, 1, "PR", "PR", "J", null, false, true, 348.6, 0.0);

        System.out.println("---------------------------------------------------------------------------------------------------------\n");

        /**
         * Cenário 2
         */
        System.out.println("Cenário 2");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        processaST(12, 100, 1, "PR", "MS", "J", null, false, true, 348.6,0.0);
        System.out.println("---------------------------------------------------------------------------------------------------------");

        /**
         * Cenário 3
         */
        System.out.println("Cenário 3");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        processaST(12, 100, 1, "PR", "SP", "J", null, false, true, 348.6, 0.0);
        System.out.println("---------------------------------------------------------------------------------------------------------");


        System.out.println("________________________________________________________________________________________________________________________");
    }

    @Test
    public void testeCalculoST_KGEPEL() {
        dbService.setDB("KGEPEL");
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("KGEPEL\n");

        System.out.println("Cenário 5");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        processaST(15, 100, 1, "PR", "SC", "J", "CONSUMO CONTRIBUINTE", false, true, 88.84, 0.0);

        System.out.println("________________________________________________________________________________________________________________________");

        System.out.println("Cenário 8");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        processaST(15, 100, 1, "PR", "SC", "J", "CONSUMO CONTRIBUINTE", false, true, 138.0, 0.0);

        System.out.println("________________________________________________________________________________________________________________________");
    }

    @Test
    public void testeCalculoST_TOPVET() {
        dbService.setDB("TOPVET");

        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("TOPVET\n");

        System.out.println("Cenário 6");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        processaST(2, 100, 1, "PR", "MS", "J", null, true, true, 100.0, 0.0);

        System.out.println("Cenário 7");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        processaST(6, 100, 1, "PR", "MS", "J", null, true, true, 118.0, 0.0);

        System.out.println("________________________________________________________________________________________________________________________");
    }

    @Test
    public void testeCalculoST_SCHUMACHER(){
        dbService.setDB("SCHUMACHER");

        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("SCHUMACHER\n");

        System.out.println("Cenário 9");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        processaST(5, 100, 1, "PR", "MG", "J", "REVENDA", false, true, 300.0, 0.0);

    }


    public void processaST(Integer grupoFiscal, Integer operacao, Integer filial, String ufEmitente, String ufDestino, String tipoPessoa,
                           String regimeEstadual, Boolean simples, Boolean consideraDescontoIPI, Double totalProdutos, Double desconto) {

        ClassificacaoTributaria ctOrigem = classificacaoTributariaRepository
                .findByFilters(grupoFiscal, operacao, filial, ufEmitente, ufDestino, tipoPessoa, regimeEstadual);

//        assertNotNull(ctOrigem);

        System.out.println(ctOrigem.toString());

        Tributacao tribOrigem = tributacaoRepository.findByCodigo(ctOrigem.getTributacao());

//        assertNotNull(tribOrigem);

        Params paramsOrigem = new Params(simples, consideraDescontoIPI, totalProdutos, desconto, ctOrigem, tribOrigem);

        System.out.println(paramsOrigem.toString());

        ICMS origem = new ICMS(Estado.ORIGEM, paramsOrigem);

        String ufParam = (simples ? ufDestino : ufEmitente);
        System.out.println("ufParam: " + ufParam);
        ClassificacaoTributaria ctDestino = classificacaoTributariaRepository
                .findByFilters(grupoFiscal, operacao, filial, ufParam, ufDestino, tipoPessoa, regimeEstadual);

//        assertNotNull(ctDestino);

//        System.out.println(ctDestino.toString());

        if (ctDestino == null) {
            ctDestino = new ClassificacaoTributaria(ufEmitente, ufDestino);
        }

        Tributacao tribDestino = ctDestino != null && ctDestino.getTributacao() != null ? tributacaoRepository.findByCodigo(ctDestino.getTributacao()) : null;

//        assertNotNull(tribDestino);

//        System.out.println("tribDestino:" + tribDestino.toString());

        Params paramsDestino = new Params(simples, consideraDescontoIPI, totalProdutos, desconto, ctDestino, tribDestino);

        System.out.println(paramsDestino.toString());

        ICMS destino = new ICMS(Estado.DESTINO, paramsDestino);


        System.out.println("Base ICMS na Origem: " + origem.getValorBase());
        System.out.println("Valor ICMS na Origem: " + origem.getValor());
        System.out.println("-----------------------------------------");
        System.out.println("Base ICMS no Destino: " + destino.getValorBase());
        System.out.println("Valor ICMS no Destino: " + destino.getValor());

        ST st = new ST(origem, destino, paramsDestino);

        System.out.println("Valor ST: " + st.getValor());
        System.out.println("Valor Base ST: " + st.getValorBase());

    }

//    @Test
    public void getGruposFiscaisTest() {
        List<GrupoFiscal> gruposFiscais = grupoFiscalRepository.getGruposFiscais();

        assertNotNull(gruposFiscais);

        gruposFiscais.forEach(g -> {
            System.out.println(g.toString());
        });
    }


}
