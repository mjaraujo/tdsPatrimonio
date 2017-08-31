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
@Table(name = "TB_CIDADE", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CID_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findByCidCodigo", query = "SELECT c FROM Cidade c WHERE c.cidCodigo = :cidCodigo")
    , @NamedQuery(name = "Cidade.findByCidDescricao", query = "SELECT c FROM Cidade c WHERE c.cidDescricao = :cidDescricao")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CID_CODIGO", nullable = false)
    private Integer cidCodigo;
    @Basic(optional = false)
    @Column(name = "CID_DESCRICAO", nullable = false, length = 60)
    private String cidDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private List<Predio> predioList;

    public Cidade() {
    }

    public Cidade(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public Cidade(Integer cidCodigo, String cidDescricao) {
        this.cidCodigo = cidCodigo;
        this.cidDescricao = cidDescricao;
    }

    public Integer getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Integer cidCodigo) {
        this.cidCodigo = cidCodigo;
    }

    public String getCidDescricao() {
        return cidDescricao;
    }

    public void setCidDescricao(String cidDescricao) {
        this.cidDescricao = cidDescricao;
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
        hash += (cidCodigo != null ? cidCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.cidCodigo == null && other.cidCodigo != null) || (this.cidCodigo != null && !this.cidCodigo.equals(other.cidCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Cidade[ cidCodigo=" + cidCodigo + " ]";
    }
    
}
