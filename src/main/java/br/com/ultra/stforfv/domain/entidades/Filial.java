package br.com.ultra.stforfv.domain.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILIAIS")
public class Filial {

    @Id
    @Column(name = "codfilial")
    private Integer id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "uf")
    private String uf;

    @Column(name = "simples_estadual")
    private String simplesEstadual;

    public Integer getId() {
        return id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getUf() {
        return uf;
    }

    public String getSimplesEstadual() {
        return simplesEstadual;
    }

    @Override
    public String toString() {
        return "Filial{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", uf='" + uf + '\'' +
                ", simplesEstadual='" + simplesEstadual + '\'' +
                '}';
    }
}
