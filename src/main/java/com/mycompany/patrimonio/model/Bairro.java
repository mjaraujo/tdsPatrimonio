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
@Table(name = "TB_BAIRRO", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"BAI_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b")
    , @NamedQuery(name = "Bairro.findByBaiCodigo", query = "SELECT b FROM Bairro b WHERE b.baiCodigo = :baiCodigo")
    , @NamedQuery(name = "Bairro.findByBaiDescricao", query = "SELECT b FROM Bairro b WHERE b.baiDescricao = :baiDescricao")})
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BAI_CODIGO", nullable = false)
    private Integer baiCodigo;
    @Basic(optional = false)
    @Column(name = "BAI_DESCRICAO", nullable = false, length = 60)
    private String baiDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bairro")
    private List<Predio> predioList;

    public Bairro() {
    }

    public Bairro(Integer baiCodigo) {
        this.baiCodigo = baiCodigo;
    }

    public Bairro(Integer baiCodigo, String baiDescricao) {
        this.baiCodigo = baiCodigo;
        this.baiDescricao = baiDescricao;
    }

    public Integer getBaiCodigo() {
        return baiCodigo;
    }

    public void setBaiCodigo(Integer baiCodigo) {
        this.baiCodigo = baiCodigo;
    }

    public String getBaiDescricao() {
        return baiDescricao;
    }

    public void setBaiDescricao(String baiDescricao) {
        this.baiDescricao = baiDescricao;
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
        hash += (baiCodigo != null ? baiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.baiCodigo == null && other.baiCodigo != null) || (this.baiCodigo != null && !this.baiCodigo.equals(other.baiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Bairro[ baiCodigo=" + baiCodigo + " ]";
    }
    
}
