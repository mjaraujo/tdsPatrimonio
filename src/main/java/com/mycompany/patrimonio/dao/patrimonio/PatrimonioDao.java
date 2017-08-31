/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.dao.patrimonio;

import com.mycompany.patrimonio.dao.GenericDAO;
import com.mycompany.patrimonio.model.Patrimonio;
import com.mycompany.patrimonio.model.Tipo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marcio
 */
public class PatrimonioDao extends GenericDAO<Patrimonio> {

    public List<Patrimonio> getAll() {
        return listAll(Patrimonio.class);
    }

    public Long getQtdPatrimonioCidade(String cidade) {
        Query query = manager.createNamedQuery("Patrimonio.getQtdByCidade", Long.class);
        query.setParameter("cidade", "%" + cidade + "%");
        return (Long) query.getSingleResult();
    }
    public Long getQtdPatrimonioBairro(String bairro) {
        Query query = manager.createNamedQuery("Patrimonio.getQtdByBairro", Long.class);
        query.setParameter("cidade", "%" + bairro + "%");
        return (Long) query.getSingleResult();
    }
    public Long getQtdPatrimonioTipo(Tipo tipo) {
        Query query = manager.createNamedQuery("Patrimonio.getQtdByTipo", Long.class);
        query.setParameter("codTipo", tipo.getTipCodigo());
        return (Long) query.getSingleResult();
    }
}
