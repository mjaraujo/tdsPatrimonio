/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author marcio
 */
@Entity
@Table(name = "TB_ENDERECO", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"END_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
    , @NamedQuery(name = "Endereco.findByEndCodigo", query = "SELECT e FROM Endereco e WHERE e.endCodigo = :endCodigo")
    , @NamedQuery(name = "Endereco.findByEndDescricao", query = "SELECT e FROM Endereco e WHERE e.endDescricao = :endDescricao")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "END_CODIGO", nullable = false)
    private Integer endCodigo;
    @Basic(optional = false)
    @Column(name = "END_DESCRICAO", nullable = false, length = 60)
    private String endDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preCodendereco")
    private List<Predio> predioList;

    public Endereco() {
    }

    public Endereco(Integer endCodigo) {
        this.endCodigo = endCodigo;
    }

    public Endereco(Integer endCodigo, String endDescricao) {
        this.endCodigo = endCodigo;
        this.endDescricao = endDescricao;
    }

    public Integer getEndCodigo() {
        return endCodigo;
    }

    public void setEndCodigo(Integer endCodigo) {
        this.endCodigo = endCodigo;
    }

    public String getEndDescricao() {
        return endDescricao;
    }

    public void setEndDescricao(String endDescricao) {
        this.endDescricao = endDescricao;
    }

    public List<Predio> getPredioList() {
        return predioList;
    }

    public void setPredioList(List<Predio> predioList) {
        this.predioList = predioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endCodigo != null ? endCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.endCodigo == null && other.endCodigo != null) || (this.endCodigo != null && !this.endCodigo.equals(other.endCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Endereco[ endCodigo=" + endCodigo + " ]";
    }
    
}
