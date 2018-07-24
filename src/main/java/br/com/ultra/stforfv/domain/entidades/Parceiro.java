package br.com.ultra.stforfv.domain.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PARCEIROS")
public class Parceiro implements Serializable{

    @Id
    @Column(name = "parceiro")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "grupo_fiscal")
    private Integer grupoFiscal;

    @Column(name = "uf")
    private String uf;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getGrupoFiscal() {
        return grupoFiscal;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "Parceiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", grupoFiscal=" + grupoFiscal +
                ", uf='" + uf + '\'' +
                '}';
    }
}
