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
@Table(name = "TB_MARCA", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"MAR_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
    , @NamedQuery(name = "Marca.findByMarCodigo", query = "SELECT m FROM Marca m WHERE m.marCodigo = :marCodigo")
    , @NamedQuery(name = "Marca.findByMarDescricao", query = "SELECT m FROM Marca m WHERE m.marDescricao = :marDescricao")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAR_CODIGO", nullable = false)
    private Integer marCodigo;
    @Basic(optional = false)
    @Column(name = "MAR_DESCRICAO", nullable = false, length = 60)
    private String marDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patCodmarca")
    private List<Patrimonio> patrimonioList;

    public Marca() {
    }

    public Marca(Integer marCodigo) {
        this.marCodigo = marCodigo;
    }

    public Marca(Integer marCodigo, String marDescricao) {
        this.marCodigo = marCodigo;
        this.marDescricao = marDescricao;
    }

    public Integer getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(Integer marCodigo) {
        this.marCodigo = marCodigo;
    }

    public String getMarDescricao() {
        return marDescricao;
    }

    public void setMarDescricao(String marDescricao) {
        this.marDescricao = marDescricao;
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
        hash += (marCodigo != null ? marCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.marCodigo == null && other.marCodigo != null) || (this.marCodigo != null && !this.marCodigo.equals(other.marCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Marca[ marCodigo=" + marCodigo + " ]";
    }
    
}
