/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.dao.marca;

import com.mycompany.patrimonio.dao.GenericDAO;
import com.mycompany.patrimonio.model.Marca;
import java.util.List;

/**
 *
 * @author marcio
 */
public class MarcaDao extends GenericDAO<Marca> {
    public List<Marca> getAll(){
        return listAll(Marca.class);
    }
}
