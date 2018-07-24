package br.com.ultra.stforfv.domain.entidades;

import java.io.Serializable;

public class ClassTributariaPK implements Serializable{

    private Integer sequencia;

    private Integer tributacao;

    private Integer grupoFiscal;

    private Integer operacao;

    private Integer filialEmitente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassTributariaPK that = (ClassTributariaPK) o;

        if (sequencia != null ? !sequencia.equals(that.sequencia) : that.sequencia != null) return false;
        if (tributacao != null ? !tributacao.equals(that.tributacao) : that.tributacao != null) return false;
        if (grupoFiscal != null ? !grupoFiscal.equals(that.grupoFiscal) : that.grupoFiscal != null) return false;
        if (operacao != null ? !operacao.equals(that.operacao) : that.operacao != null) return false;
        return filialEmitente != null ? filialEmitente.equals(that.filialEmitente) : that.filialEmitente == null;
    }

    @Override
    public int hashCode() {
        int result = sequencia != null ? sequencia.hashCode() : 0;
        result = 31 * result + (tributacao != null ? tributacao.hashCode() : 0);
        result = 31 * result + (grupoFiscal != null ? grupoFiscal.hashCode() : 0);
        result = 31 * result + (operacao != null ? operacao.hashCode() : 0);
        result = 31 * result + (filialEmitente != null ? filialEmitente.hashCode() : 0);
        return result;
    }
}
