package br.com.ultra.stforfv.domain.tributacoes;

import br.com.ultra.stforfv.domain.entidades.Tributacao;

public class IPI {

    /**
     * SE PARAMETRO IPI_CONSIDERA_DESCONTO = 'S' ENTÃO USA O VALOR_LÍQUIDO
     * SENÃO O VALOR_BRUTO PARA BASE DE CÁLCULO
     */
    private Double valorBase;

    private Double percIpi;

    private Double valor;

    public IPI(Tributacao trib, Double valorLiquido, Double valorBruto, Boolean consideraDesconto) {
        valorBase = consideraDesconto? valorLiquido : valorBruto;
        percIpi = trib.getPerIpi();
        valor = valorBase * percIpi;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "IPI{" +
                "valorBase=" + valorBase +
                ", percIpi=" + percIpi +
                ", valor=" + valor +
                '}';
    }
}
