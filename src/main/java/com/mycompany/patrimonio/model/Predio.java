/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author marcio
 */
@Entity
@Table(name = "TB_PREDIO", catalog = "patrimonio", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PRE_DESCRICAO"})})
@NamedQueries({
    @NamedQuery(name = "Predio.findAll", query = "SELECT p FROM Predio p")
    , @NamedQuery(name = "Predio.findByPreCodigo", query = "SELECT p FROM Predio p WHERE p.preCodigo = :preCodigo")
    , @NamedQuery(name = "Predio.findByPreDescricao", query = "SELECT p FROM Predio p WHERE p.preDescricao = :preDescricao")
    , @NamedQuery(name = "Predio.findByPreNumero", query = "SELECT p FROM Predio p WHERE p.preNumero = :preNumero")})
public class Predio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRE_CODIGO", nullable = false)
    private Integer preCodigo;
    @Basic(optional = false)
    @Column(name = "PRE_DESCRICAO", nullable = false, length = 60)
    private String preDescricao;
    @Column(name = "PRE_NUMERO", length = 10)
    private String preNumero;
    @JoinColumn(name = "PRE_CODBAIRRO", referencedColumnName = "BAI_CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Bairro bairro;
    @JoinColumn(name = "PRE_CODCIDADE", referencedColumnName = "CID_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidade;
    @JoinColumn(name = "PRE_CODENDERECO", referencedColumnName = "END_CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Endereco preCodendereco;

    public Predio() {
    }

    public Predio(Integer preCodigo) {
        this.preCodigo = preCodigo;
    }

    public Predio(Integer preCodigo, String preDescricao) {
        this.preCodigo = preCodigo;
        this.preDescricao = preDescricao;
    }

    public Integer getPreCodigo() {
        return preCodigo;
    }

    public void setPreCodigo(Integer preCodigo) {
        this.preCodigo = preCodigo;
    }

    public String getPreDescricao() {
        return preDescricao;
    }

    public void setPreDescricao(String preDescricao) {
        this.preDescricao = preDescricao;
    }

    public String getPreNumero() {
        return preNumero;
    }

    public void setPreNumero(String preNumero) {
        this.preNumero = preNumero;
    }

    public Bairro getPreCodbairro() {
        return bairro;
    }

    public void setPreCodbairro(Bairro preCodbairro) {
        this.bairro = preCodbairro;
    }

    public Cidade getPreCodcidade() {
        return cidade;
    }

    public void setPreCodcidade(Cidade preCodcidade) {
        this.cidade = preCodcidade;
    }

    public Endereco getPreCodendereco() {
        return preCodendereco;
    }

    public void setPreCodendereco(Endereco preCodendereco) {
        this.preCodendereco = preCodendereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preCodigo != null ? preCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predio)) {
            return false;
        }
        Predio other = (Predio) object;
        if ((this.preCodigo == null && other.preCodigo != null) || (this.preCodigo != null && !this.preCodigo.equals(other.preCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Predio[ preCodigo=" + preCodigo + " ]";
    }
    
}
