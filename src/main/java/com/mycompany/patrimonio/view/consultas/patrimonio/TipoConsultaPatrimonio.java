/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrimonio.view.consultas.patrimonio;

/**
 *

 */
public enum TipoConsultaPatrimonio {
  
    QTD_PATRIMONIO_CIDADE("Quantidade de patrimônios existentes por cidade"),
    QTD_PATRIMONIO_BAIRRO("Quantidade de patrimônios existentes por bairro"),
    QTD_PATRIMONIO_TIPO("Quantidade de patrimônios existentes por tipo");
    
    private final String descricao;       

    private TipoConsultaPatrimonio(String s) {
        descricao = s;
    }

    public boolean equalsName(String otherName) {
        return descricao.equals(otherName);
    }

    public String toString() {
       return this.descricao;
    }

}
