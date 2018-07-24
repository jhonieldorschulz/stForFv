package br.com.ultra.stforfv.domain.tributacoes;

public interface ICalculoICMS {

    Double getBaseICMS();

    Double getValorICMS(Double base);

}
