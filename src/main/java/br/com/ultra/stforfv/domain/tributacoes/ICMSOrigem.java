package br.com.ultra.stforfv.domain.tributacoes;

import br.com.ultra.stforfv.domain.entidades.ClassificacaoTributaria;
import br.com.ultra.stforfv.domain.entidades.Tributacao;

public class ICMSOrigem implements ICalculoICMS {

    private Params params;

    public ICMSOrigem(Params params) {
        this.params = params;
    }

    @Override
    public Double getBaseICMS() {
        if (params.getCt().isUsoConsumo() && params.getSimples()) {
            return (params.getTotalProdutos() - (params.getTotalProdutos() * params.getTrib().getPercStEstSimples())) / (1 - params.getTrib().getPercST());
        }


        if (params.getCt().isUsoConsumo() && !params.getSimples()) {
            return (params.getTotalProdutos() - (params.getTotalProdutos() * params.getTrib().getPercICMSEfetivo())) / (1 - params.getTrib().getPercST());
        }

        Double valorIpi = params.getTotalProdutos() * params.getTrib().getPerIpi();

        return (params.somaValores() + valorIpi) * ((1 + params.getCt().getMargemST()) * params.getTrib().getPercBaseST());
    }

    @Override
    public Double getValorICMS(Double base) {
        return base * params.getTrib().getPercST();
    }
}
