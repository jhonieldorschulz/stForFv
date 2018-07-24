package br.com.ultra.stforfv.domain.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OPERACOES")
public class Operacao implements Serializable {

    @Id
    @Column(name = "codoper")
    private Integer id;

    @Column(name = "dscoper")
    private String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
