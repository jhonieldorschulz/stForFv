package br.com.ultra.stforfv.domain.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ClassTributariaPK.class)
@Table(name = "CLASSIFICACAO_TRIBUTARIA")
public class ClassificacaoTributaria implements Serializable{

    @Id
    @Column(name = "seq_pesquisa")
    private Integer sequencia;

    @Id
    @Column(name = "codtributacao")
    private Integer tributacao = 0;

    @Id
    @Column(name = "grupo_fiscal")
    private Integer grupoFiscal;

    @Id
    @Column(name = "codoper")
    private Integer operacao;

    @Id
    @Column(name = "codfilial_emitente")
    private Integer filialEmitente;

    @Column(name = "regime_estadual")
    private String regimeEstadual;

    @Column(name = "uf_emitente")
    private String ufEmitente;

    @Column(name = "uf_destino")
    private String ufDestino;

    @Column(name = "perc_ctm_st")
    private Double percCtmST = 0.0;

    @Column(name = "margem_calculo_st")
    private Double margemST = 0.0;

    @Column(name = "idn_st_uso_consumo")
    private String idnUsoConsumo;


    public ClassificacaoTributaria() {
    }

    public ClassificacaoTributaria(String ufEmitente, String ufDestino) {
        this.ufEmitente = ufEmitente;
        this.ufDestino = ufDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassificacaoTributaria that = (ClassificacaoTributaria) o;

        if (sequencia != null ? !sequencia.equals(that.sequencia) : that.sequencia != null) return false;
        if (tributacao != null ? !tributacao.equals(that.tributacao) : that.tributacao != null) return false;
        if (grupoFiscal != null ? !grupoFiscal.equals(that.grupoFiscal) : that.grupoFiscal != null) return false;
        if (operacao != null ? !operacao.equals(that.operacao) : that.operacao != null) return false;
        if (filialEmitente != null ? !filialEmitente.equals(that.filialEmitente) : that.filialEmitente != null)
            return false;
        if (regimeEstadual != null ? !regimeEstadual.equals(that.regimeEstadual) : that.regimeEstadual != null)
            return false;
        if (ufEmitente != null ? !ufEmitente.equals(that.ufEmitente) : that.ufEmitente != null) return false;
        if (ufDestino != null ? !ufDestino.equals(that.ufDestino) : that.ufDestino != null) return false;
        return percCtmST != null ? percCtmST.equals(that.percCtmST) : that.percCtmST == null;
    }

    @Override
    public int hashCode() {
        int result = sequencia != null ? sequencia.hashCode() : 0;
        result = 31 * result + (tributacao != null ? tributacao.hashCode() : 0);
        result = 31 * result + (grupoFiscal != null ? grupoFiscal.hashCode() : 0);
        result = 31 * result + (operacao != null ? operacao.hashCode() : 0);
        result = 31 * result + (filialEmitente != null ? filialEmitente.hashCode() : 0);
        result = 31 * result + (regimeEstadual != null ? regimeEstadual.hashCode() : 0);
        result = 31 * result + (ufEmitente != null ? ufEmitente.hashCode() : 0);
        result = 31 * result + (ufDestino != null ? ufDestino.hashCode() : 0);
        result = 31 * result + (percCtmST != null ? percCtmST.hashCode() : 0);
        return result;
    }



    public Integer getSequencia() {
        return sequencia;
    }

    public Integer getTributacao() {
        return tributacao;
    }

    public Integer getGrupoFiscal() {
        return grupoFiscal;
    }

    public Integer getOperacao() {
        return operacao;
    }

    public Integer getFilialEmitente() {
        return filialEmitente;
    }

    public String getRegimeEstadual() {
        return regimeEstadual;
    }

    public String getUfEmitente() {
        return ufEmitente;
    }

    public String getUfDestino() {
        return ufDestino;
    }

    public Double getPercCtmST() {
        return percCtmST / 100;
    }

    public Double getMargemST() {
        return margemST / 100;
    }

    public Boolean isVendaForaUF(){
        return  !this.ufEmitente.equals(this.ufDestino);
    }

    public Boolean isUsoConsumo(){
        return idnUsoConsumo!= null? idnUsoConsumo.equals("S") : false;
    }

    @Override
    public String toString() {
        return "ClassificacaoTributaria{" +
                "sequencia=" + sequencia +
                ", tributacao=" + tributacao +
                ", grupoFiscal=" + grupoFiscal +
                ", operacao=" + operacao +
                ", filialEmitente=" + filialEmitente +
                ", regimeEstadual='" + regimeEstadual + '\'' +
                ", ufEmitente='" + ufEmitente + '\'' +
                ", ufDestino='" + ufDestino + '\'' +
                ", percCtmST=" + percCtmST +
                '}';
    }


}
