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
@Table(name = "TB_TIPO", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"TIP_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
    , @NamedQuery(name = "Tipo.findByTipCodigo", query = "SELECT t FROM Tipo t WHERE t.tipCodigo = :tipCodigo")
    , @NamedQuery(name = "Tipo.findByTipDescricao", query = "SELECT t FROM Tipo t WHERE t.tipDescricao = :tipDescricao")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TIP_CODIGO", nullable = false)
    private Integer tipCodigo;
    @Basic(optional = false)
    @Column(name = "TIP_DESCRICAO", nullable = false, length = 60)
    private String tipDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<Patrimonio> patrimonioList;

    public Tipo() {
    }

    public Tipo(Integer tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public Tipo(Integer tipCodigo, String tipDescricao) {
        this.tipCodigo = tipCodigo;
        this.tipDescricao = tipDescricao;
    }

    public Integer getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(Integer tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipDescricao() {
        return tipDescricao;
    }

    public void setTipDescricao(String tipDescricao) {
        this.tipDescricao = tipDescricao;
    }

    public List<Patrimonio> getPatrimonioList() {
        return patrimonioList;
    }

    public void setPatrimonioList(List<Patrimonio> patrimonioList) {
        this.patrimonioList = patrimonioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.tipCodigo == null && other.tipCodigo != null) || (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Tipo[ tipCodigo=" + tipCodigo + " ]";
    }
    
}
