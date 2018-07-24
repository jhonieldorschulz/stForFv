package br.com.ultra.stforfv.domain.entidades;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GRUPOS_FISCAIS")
public class GrupoFiscal implements Serializable{


    @Id
    @Column(name= "grupo_fiscal")
    private Integer grupoFiscal;


    @Column(name= "origem")
    private String origem;

    public Integer getGrupoFiscal() {
        return grupoFiscal;
    }

    public String getOrigem() {
        return origem;
    }

    @Override
    public String toString() {
        return "GrupoFiscal{" +
                "grupoFiscal=" + grupoFiscal +
                ", origem='" + origem.trim() + '\'' +
                '}';
    }
}
