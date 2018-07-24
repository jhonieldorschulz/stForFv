package br.com.ultra.stforfv.domain.tributacoes;

public class ICMSDestino implements ICalculoICMS {

    private Params params;

    public ICMSDestino(Params params) {
        this.params = params;
    }

    @Override
    public Double getBaseICMS() {
        if (params.getCt().isUsoConsumo()) {
            return params.getTotalProdutos();
        }

        if (!params.getCt().isUsoConsumo() && params.getSimples()) {
            return params.somaValores() * (params.getTrib().getPercBaseST());
        }

        return params.somaValores() * (params.getTrib().getPercBaseICMS());
    }

    @Override
    public Double getValorICMS(Double base) {

        Double valorICMS = 0.0;
        if (params.getCt().isUsoConsumo()) {
            /**
             * SE Filial é do Simples e venda na mesma UF em Uso e Consumo
             */
            if (params.getSimples() && !params.getCt().isVendaForaUF()) {
                valorICMS = base * params.getTrib().getPercStEstSimples();
            }

            /**
             * SE Filial é do Simples e venda fora da UF em Uso e Consumo
             */
            if (params.getSimples() && params.getCt().isVendaForaUF()) {
                valorICMS = base * params.getTrib().getPercST();
            }

            /**
             * SE Filial não for do Simples em Uso e Consumo
             */
            if (!params.getSimples()) {
                valorICMS = base * params.getTrib().getPercICMSEfetivo();
            }
        } else {

            Double percIcmsUF;

            /**
             * Se for do SIMPLES, obtem o Perc. ST Est. Simples para vendas no estado, ou Perc. ST para fora do estado, na atribuição
             * para o Percentual ICMS de Destino
             */
            if (params.getSimples()) {
                percIcmsUF = params.getCt().isVendaForaUF()? params.getTrib().getPercST() : params.getTrib().getPercStEstSimples();
            }else{
                percIcmsUF = params.getTrib().getPercICMSEfetivo();
            }

            valorICMS = base * percIcmsUF;

        }


        return valorICMS;
    }
}
