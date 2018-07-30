package br.com.ultra.stforfv.domain.tributacoes;

import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;
import br.com.ultra.stforfv.domain.entidades.Tributacao;

public class Params {

    private Double totalProdutos;

    private Double desconto;

    private Double despesasAcessorias = 0.0;

    private Double frete = 0.0;

    private Double seguro = 0.0;

    private Boolean simples;

//    private Boolean ipiTributado = false;

//    private Integer codigoTributacao;
    private Boolean consideraDescontoIPI;

    private ClassificacaoTributaria ct;

    private Tributacao trib;

    private IPI ipi;

    public Params() {
    }

    public Params(Boolean simples, Double totalProdutos, Double despesasAcessorias, Double frete, Double seguro, Boolean ipiTributado,  ClassificacaoTributaria ct, Tributacao trib) {
        this.simples = simples;
        this.totalProdutos = totalProdutos;
        this.despesasAcessorias = despesasAcessorias;
        this.frete = frete;
        this.seguro = seguro;
//        this.ipiTributado = ipiTributado;
//        this.valorIpi = valorIpi;
        this.ct = ct;
        this.trib = trib;


    }

    public Params(Boolean simples, Boolean consideraDescontoIPI, Double totalProdutos, Double desconto, ClassificacaoTributaria ct, Tributacao trib) {
        this.simples = simples;
        this.totalProdutos = totalProdutos;
        this.desconto = desconto;
        this.ct = ct != null ? ct : new ClassificacaoTributaria();
        this.trib = trib != null ? trib : new Tributacao();
        this.ipi = new IPI(this.trib, (totalProdutos - desconto), totalProdutos, consideraDescontoIPI);
    }


    public Params(Double totalProdutos, ClassificacaoTributaria ct, Tributacao tributacao) {
        this.totalProdutos = totalProdutos;
        this.ct = ct;
        this.trib = tributacao;

    }

    public Double getTotalProdutos() {
        return totalProdutos;
    }

//    public Boolean getIpiTributado() {
//        return ipiTributado;
//    }


    public ClassificacaoTributaria getCt() {
        return ct;
    }

    public Tributacao getTrib() {
        return trib;
    }

    public Boolean getSimples() {
        return simples;
    }

    public Double somaValores(){
        return totalProdutos + despesasAcessorias + frete + seguro;
    }

    public IPI getIpi() {
        return ipi;
    }

    @Override
    public String toString() {
        return "Params{" +
                "totalProdutos=" + totalProdutos +
                ", desconto=" + desconto +
                ", despesasAcessorias=" + despesasAcessorias +
                ", frete=" + frete +
                ", seguro=" + seguro +
                ", simples=" + simples +
                ", consideraDescontoIPI=" + consideraDescontoIPI +
                ", ct=" + ct.toString() +
                ", trib=" + trib.toString() +
                ", ipi=" + ipi.toString() +
                '}';
    }
}
