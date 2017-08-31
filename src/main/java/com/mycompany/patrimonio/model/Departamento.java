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
@Table(name = "TB_DEPARTAMENTO", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DEP_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findByDepCodigo", query = "SELECT d FROM Departamento d WHERE d.depCodigo = :depCodigo")
    , @NamedQuery(name = "Departamento.findByDepDescricao", query = "SELECT d FROM Departamento d WHERE d.depDescricao = :depDescricao")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEP_CODIGO", nullable = false)
    private Integer depCodigo;
    @Basic(optional = false)
    @Column(name = "DEP_DESCRICAO", nullable = false, length = 60)
    private String depDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patCoddepartamento")
    private List<Patrimonio> patrimonioList;

    public Departamento() {
    }

    public Departamento(Integer depCodigo) {
        this.depCodigo = depCodigo;
    }

    public Departamento(Integer depCodigo, String depDescricao) {
        this.depCodigo = depCodigo;
        this.depDescricao = depDescricao;
    }

    public Integer getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(Integer depCodigo) {
        this.depCodigo = depCodigo;
    }

    public String getDepDescricao() {
        return depDescricao;
    }

    public void setDepDescricao(String depDescricao) {
        this.depDescricao = depDescricao;
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
        hash += (depCodigo != null ? depCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.depCodigo == null && other.depCodigo != null) || (this.depCodigo != null && !this.depCodigo.equals(other.depCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Departamento[ depCodigo=" + depCodigo + " ]";
    }
    
}
