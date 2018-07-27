package br.com.ultra.stforfv.domain.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TRIBUTACOES")
public class Tributacao implements Serializable{

    @Id
    @Column(name = "codtributacao")
    private Integer id;

    @Column(name = "dsctributacao")
    private String tributacao;

    @Column(name = "per_st")
    private Double percST = 0.0;

    @Column(name = "per_base_st")
    private Double percBaseST = 0.0;

    @Column(name = "per_st_est_simples")
    private Double percStEstSimples = 0.0;

    @Column(name = "per_ICMS_efetiva")
    private Double percICMSEfetivo = 0.0;

    @Column(name = "per_base_icms")
    private Double percBaseICMS = 0.0;

    @Column(name = "per_base_ipi")
    private Double percBaseIPI = 0.0;

    @Column(name = "per_ipi")
    private Double perIpi = 0.0;

    public Tributacao() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tributacao that = (Tributacao) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tributacao != null ? !tributacao.equals(that.tributacao) : that.tributacao != null) return false;
        if (percST != null ? !percST.equals(that.percST) : that.percST != null) return false;
        if (percBaseST != null ? !percBaseST.equals(that.percBaseST) : that.percBaseST != null) return false;
        if (percStEstSimples != null ? !percStEstSimples.equals(that.percStEstSimples) : that.percStEstSimples != null)
            return false;
        return percICMSEfetivo != null ? percICMSEfetivo.equals(that.percICMSEfetivo) : that.percICMSEfetivo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tributacao != null ? tributacao.hashCode() : 0);
        result = 31 * result + (percST != null ? percST.hashCode() : 0);
        result = 31 * result + (percBaseST != null ? percBaseST.hashCode() : 0);
        result = 31 * result + (percStEstSimples != null ? percStEstSimples.hashCode() : 0);
        result = 31 * result + (percICMSEfetivo != null ? percICMSEfetivo.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public String getTributacao() {
        return tributacao;
    }

    public Double getPercST() {
        return percST / 100;
    }

    public Double getPercBaseST() {
        return percBaseST / 100;
    }

    public Double getPercBaseICMS(){
        return percBaseICMS / 100;
    }

    public Double getPercStEstSimples() {
        return percStEstSimples / 100;
    }

    public Double getPercICMSEfetivo() {
        return percICMSEfetivo / 100;
    }

    public Double getPerIpi() {
        return percBaseIPI > 0 ? perIpi / percBaseIPI : 0.0;
    }

    @Override
    public String toString() {
        return "Tributacao{" +
                "id=" + id +
                ", tributacao='" + tributacao + '\'' +
                ", percST=" + percST +
                ", percBaseST=" + percBaseST +
                ", percStEstSimples=" + percStEstSimples +
                ", percICMSEfetivo=" + percICMSEfetivo +
                ", percBaseICMS=" + percBaseICMS +
                ", percBaseIPI=" + percBaseIPI +
                ", perIpi=" + perIpi +
                '}';
    }
}
