/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marcio
 */
@Entity
@Table(name = "TB_PATRIMONIO", catalog = "patrimonio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Patrimonio.findAll", query = "SELECT p FROM Patrimonio p")
    , @NamedQuery(name = "Patrimonio.findByPatCodigo", query = "SELECT p FROM Patrimonio p WHERE p.patCodigo = :patCodigo")
    , @NamedQuery(name = "Patrimonio.findByPatDescricao", query = "SELECT p FROM Patrimonio p WHERE p.patDescricao = :patDescricao")
    , @NamedQuery(name = "Patrimonio.getQtdByCidade", query = "SELECT count(p) FROM Patrimonio p JOIN p.predio pre JOIN pre.cidade c WHERE UPPER(c.cidDescricao) LIKE UPPER( :cidade)")
    , @NamedQuery(name = "Patrimonio.getQtdByBairro", query = "SELECT count(p) FROM Patrimonio p JOIN p.predio pre JOIN pre.bairro b WHERE UPPER(b.baiDescricao) LIKE UPPER( :bairro)")
    , @NamedQuery(name = "Patrimonio.getQtdByTipo", query = "SELECT count(p) FROM Patrimonio p WHERE p.tipo.tipCodigo :codTipo")
    , @NamedQuery(name = "Patrimonio.findByPatDatafabricacao", query = "SELECT p FROM Patrimonio p WHERE p.patDatafabricacao = :patDatafabricacao")
    , @NamedQuery(name = "Patrimonio.findByPatDataaquisicao", query = "SELECT p FROM Patrimonio p WHERE p.patDataaquisicao = :patDataaquisicao")
    , @NamedQuery(name = "Patrimonio.findByPatDataeliminacao", query = "SELECT p FROM Patrimonio p WHERE p.patDataeliminacao = :patDataeliminacao")
    , @NamedQuery(name = "Patrimonio.findByPatVlraquisicao", query = "SELECT p FROM Patrimonio p WHERE p.patVlraquisicao = :patVlraquisicao")
    , @NamedQuery(name = "Patrimonio.findByPatObs", query = "SELECT p FROM Patrimonio p WHERE p.patObs = :patObs")
    , @NamedQuery(name = "Patrimonio.findByPatLocalizacao", query = "SELECT p FROM Patrimonio p WHERE p.patLocalizacao = :patLocalizacao")
    , @NamedQuery(name = "Patrimonio.findByPatCodpredio", query = "SELECT p FROM Patrimonio p WHERE p.predio = :patCodpredio")})
public class Patrimonio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAT_CODIGO", nullable = false)
    private Integer patCodigo;
    @Basic(optional = false)
    @Column(name = "PAT_DESCRICAO", nullable = false, length = 60)
    private String patDescricao;
    @Basic(optional = false)
    @Column(name = "PAT_DATAFABRICACAO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date patDatafabricacao;
    @Basic(optional = false)
    @Column(name = "PAT_DATAAQUISICAO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date patDataaquisicao;
    @Column(name = "PAT_DATAELIMINACAO")
    @Temporal(TemporalType.DATE)
    private Date patDataeliminacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAT_VLRAQUISICAO", precision = 10, scale = 2)
    private BigDecimal patVlraquisicao;
    @Column(name = "PAT_OBS", length = 100)
    private String patObs;
    @Column(name = "PAT_LOCALIZACAO", length = 100)
    private String patLocalizacao;
    @JoinColumn(name = "PAT_CODPREDIO", referencedColumnName = "PRE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Predio predio;
    @JoinColumn(name = "PAT_CODDEPARTAMENTO", referencedColumnName = "DEP_CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Departamento patCoddepartamento;
    @JoinColumn(name = "PAT_CODMARCA", referencedColumnName = "MAR_CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Marca patCodmarca;
    @JoinColumn(name = "PAT_CODTIPO", referencedColumnName = "TIP_CODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Tipo tipo;
  
    public Patrimonio() {
    }

    public Patrimonio(Integer patCodigo) {
        this.patCodigo = patCodigo;
    }

    
    public Integer getPatCodigo() {
        return patCodigo;
    }

    public void setPatCodigo(Integer patCodigo) {
        this.patCodigo = patCodigo;
    }

    public String getPatDescricao() {
        return patDescricao;
    }

    public void setPatDescricao(String patDescricao) {
        this.patDescricao = patDescricao;
    }

    public Date getPatDatafabricacao() {
        return patDatafabricacao;
    }

    public void setPatDatafabricacao(Date patDatafabricacao) {
        this.patDatafabricacao = patDatafabricacao;
    }

    public Date getPatDataaquisicao() {
        return patDataaquisicao;
    }

    public void setPatDataaquisicao(Date patDataaquisicao) {
        this.patDataaquisicao = patDataaquisicao;
    }

    public Date getPatDataeliminacao() {
        return patDataeliminacao;
    }

    public void setPatDataeliminacao(Date patDataeliminacao) {
        this.patDataeliminacao = patDataeliminacao;
    }

    public BigDecimal getPatVlraquisicao() {
        return patVlraquisicao;
    }

    public void setPatVlraquisicao(BigDecimal patVlraquisicao) {
        this.patVlraquisicao = patVlraquisicao;
    }

    public String getPatObs() {
        return patObs;
    }

    public void setPatObs(String patObs) {
        this.patObs = patObs;
    }

    public String getPatLocalizacao() {
        return patLocalizacao;
    }

    public void setPatLocalizacao(String patLocalizacao) {
        this.patLocalizacao = patLocalizacao;
    }

    
    public Departamento getPatCoddepartamento() {
        return patCoddepartamento;
    }

    public void setPatCoddepartamento(Departamento patCoddepartamento) {
        this.patCoddepartamento = patCoddepartamento;
    }

    public Marca getPatCodmarca() {
        return patCodmarca;
    }

    public void setPatCodmarca(Marca patCodmarca) {
        this.patCodmarca = patCodmarca;
    }

    public Tipo getPatCodtipo() {
        return tipo;
    }

    public void setPatCodtipo(Tipo patCodtipo) {
        this.tipo = patCodtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patCodigo != null ? patCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patrimonio)) {
            return false;
        }
        Patrimonio other = (Patrimonio) object;
        if ((this.patCodigo == null && other.patCodigo != null) || (this.patCodigo != null && !this.patCodigo.equals(other.patCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.patrimonio.model.Patrimonio[ patCodigo=" + patCodigo + " ]";
    }

}
