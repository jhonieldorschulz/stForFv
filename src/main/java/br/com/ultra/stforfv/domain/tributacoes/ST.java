package br.com.ultra.stforfv.domain.tributacoes;

public class ST {

    private ICMS icmsOrigem;

    private ICMS icmsDestino;

    private Double valorBase;

    private Double valor;


    public ST(ICMS icmsOrigem, ICMS icmsDestino, Params params) {
        this.icmsOrigem = icmsOrigem;
        this.icmsDestino = icmsDestino;
        this.valorBase = this.icmsOrigem.getValorBase();
        this.valor = this.icmsOrigem.getValor() - this.getIcmsDestino().getValor();
        this.valor = valor < 0 ? 0.0 : valor;

        if(params.getCt().getPercCtmST() > 0){
            valorBase = (this.icmsDestino.getValor() + (params.getTotalProdutos() * params.getCt().getPercCtmST())) / (params.getTrib().getPercST());
            valor = params.getTotalProdutos() * params.getCt().getPercCtmST();
        }
    }


    public ST() {
    }

    public ICMS getIcmsOrigem() {
        return icmsOrigem;
    }

    public ICMS getIcmsDestino() {
        return icmsDestino;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public Double getValor() {
        return valor;
    }



}
