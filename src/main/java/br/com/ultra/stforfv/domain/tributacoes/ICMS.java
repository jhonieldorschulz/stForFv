package br.com.ultra.stforfv.domain.tributacoes;

import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;

public class ICMS {

    private Estado estado;

//    private ClassificacaoTributaria ct;

    private Double percentual;

    private Double percentualBase;

    private Double valor;

    private Double valorBase;

    private ICalculoICMS calculoICMS;


    public ICMS(Estado estado, Params params) {
        this.estado = estado;

        if (estado.equals(Estado.ORIGEM)) {
            calculoICMS = new ICMSOrigem(params);
        } else {
            calculoICMS = new ICMSDestino(params);
        }

        valorBase = calculoICMS.getBaseICMS();
        valor = calculoICMS.getValorICMS(valorBase);


    }

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getPercentualBase() {
        return percentualBase;
    }

    public void setPercentualBase(Double percentualBase) {
        this.percentualBase = percentualBase;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public ICalculoICMS getCalculoICMS() {
        return calculoICMS;
    }
}
