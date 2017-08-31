/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.dao.tipo;

import com.mycompany.patrimonio.dao.GenericDAO;
import com.mycompany.patrimonio.model.Tipo;
import java.util.List;

/**
 *
 * @author marcio
 */
public class TipoDao extends GenericDAO<Tipo> {
    public List<Tipo> getAll(){
        return listAll(Tipo.class);
    }
}
