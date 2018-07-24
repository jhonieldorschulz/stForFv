package br.com.ultra.stforfv.domain.tributacoes;

import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;
import br.com.ultra.stforfv.domain.entidades.Tributacao;

public class ICMSOrigem implements ICalculoICMS{

    private Params params;

    public ICMSOrigem(Params params) {
        this.params = params;
    }

    @Override
    public Double getBaseICMS() {
        if(params.getCt().isUsoConsumo() && params.getSimples()){
            return (params.getTotalProdutos() - (params.getTotalProdutos() * params.getTrib().getPercStEstSimples())) / (1 - params.getTrib().getPercST());
        }


        if(params.getCt().isUsoConsumo() && !params.getSimples()){
            return (params.getTotalProdutos() - (params.getTotalProdutos() * params.getTrib().getPercICMSEfetivo())) /  (1 - params.getTrib().getPercST());
        }

        return params.somaValores() * ((1 + params.getCt().getMargemST()) * params.getTrib().getPercBaseST());
    }

    @Override
    public Double getValorICMS(Double base) {
        return base * params.getTrib().getPercST();
    }
}
