/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio;

import com.mycompany.patrimonio.dao.ConexaoHibernate;
import com.mycompany.patrimonio.view.janelaPrincipal.JanelaPrincipal;
import javax.persistence.EntityManager;

/**
 *
 * @author Giuvane
 */
public class Principal {
    public static void main(String[] args) {
        EntityManager manager = ConexaoHibernate.getInstance();
        JanelaPrincipal form = new JanelaPrincipal();
        form.setVisible(true);
    }
}
