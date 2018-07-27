package br.com.ultra.stforfv.domain.tributacoes;

import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;
import br.com.ultra.stforfv.domain.entidades.Tributacao;

public class Params {

    private Double totalProdutos;

    private Double despesasAcessorias = 0.0;

    private Double frete = 0.0;

    private Double seguro = 0.0;

    private Boolean simples;

    private Boolean ipiTributado = false;

//    private Double valorIpi = 0.0;

    private Integer codigoTributacao;

//    private Boolean vendaForaDaUF;

//    private Boolean usoConsumo;

    private ClassificacaoTributaria ct;

    private Tributacao trib;
//    private Double percIcmsUF;
//
//    private Double percBaseIcms;
//
//    private Double percEstSimples;
//
//    private Double percIcmsEfetivo;
//
//    private Double margemST;
//
//    private Double percBaseST;
//
//    private Double percCTM;

    public Params() {
    }

    public Params(Boolean simples, Double totalProdutos, Double despesasAcessorias, Double frete, Double seguro, Boolean ipiTributado,  ClassificacaoTributaria ct, Tributacao trib) {
        this.simples = simples;
        this.totalProdutos = totalProdutos;
        this.despesasAcessorias = despesasAcessorias;
        this.frete = frete;
        this.seguro = seguro;
        this.ipiTributado = ipiTributado;
//        this.valorIpi = valorIpi;
        this.ct = ct;
        this.trib = trib;
    }

    public Params(Boolean simples, Double totalProdutos, ClassificacaoTributaria ct, Tributacao trib) {
        this.simples = simples;
        this.totalProdutos = totalProdutos;
        this.ct = ct != null ? ct : new ClassificacaoTributaria();
        this.trib = trib != null ? trib : new Tributacao();
    }

//    public Params(Boolean simples, Double totalProdutos, ClassificacaoTributaria ct, Tributacao trib) {
//        this.simples = simples;
//        this.totalProdutos = totalProdutos;
//        this.ct = ct != null ? ct : new ClassificacaoTributaria();
//        this.trib = trib != null ? trib : new Tributacao();
//    }

    public Params(Double totalProdutos, ClassificacaoTributaria ct, Tributacao tributacao) {
        this.totalProdutos = totalProdutos;

        this.ct = ct;
        this.trib = tributacao;

//        this.vendaForaDaUF = ct.isVendaForaUF();
//        this.usoConsumo = ct.get

//        this.usoConsumo = trib.get
//        this.percCTM = ct.getPercCtmST();
//        this.vendaForaDaUF = ct.isVendaForaUF();
//        this

    }

    public Double getTotalProdutos() {
        return totalProdutos;
    }

//    public Boolean getSimples() {
//        return simples;
//    }

    public Boolean getIpiTributado() {
        return ipiTributado;
    }

//    public Double getValorIpi() {
//        return valorIpi;
//    }

//    public Boolean getVendaForaDaUF() {
//        return vendaForaDaUF;
//    }


//    public Double getPercEstSimples() {
//        return percEstSimples / 100;
//    }
//
//    public Double getPercIcmsEfetivo() {
//        return percIcmsEfetivo / 100;
//    }
//
//    public Double getPercBaseIcms() {
//        return percBaseIcms / 100;
//    }
//
//    public Double getPercIcmsUF() {
//        return percIcmsUF / 100;
//    }
//
//
//    public Double getMargemST() {
//        return margemST / 100;
//    }

//    public Double getBaseIcms() {
//
//        Estado estado = null;
//
//        Double base = 0.0;
//
//        switch (estado){
//            case ORIGEM:{
//               base = getBaseOrigem();
//            }
//
//            case DESTINO:{
//                base = getBaseDestino();
//            }
//        }
//
//        return base;
//    }

//    private Double getBaseOrigem(){
//        if (usoConsumo && simples) {
//            return (totalProdutos - (totalProdutos * getPercEstSimples())) / (1 - getPercIcmsUF());
//        }
//
//        if(usoConsumo && !simples){
//            return  (totalProdutos - (totalProdutos * getPercIcmsEfetivo())) / (1 - getPercIcmsUF());
//        }
//
//        return somaValores() * ( 1 + getMargemST()) * getPercIcmsUF();
//    }

//    private Double getBaseDestino(){
//        if(usoConsumo){
//            return totalProdutos;
//        }
//
//        if(!usoConsumo && simples){
//            //percBaseST deverá vir do obj CT instanciado de ClassificacaoTributaria
//            return somaValores()  * (percBaseST / 100.0);
//        }
//
//        return somaValores()  * (percBaseIcms / 100.0);
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
}
