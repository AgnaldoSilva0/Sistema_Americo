/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jasper;

import Model.Listas;
import java.util.ArrayList;
import java.util.List;

public class ImpressaoOrcamento {

    public static void imprimir() {
        iReportCodigo impressao = new iReportCodigo();
        List listaDados = GetDados();
        impressao.Imprime_Relatorio(listaDados);
    }

    public static List GetDados() {
        List lista = new ArrayList();
        lista.clear();
        lista = Listas.lista;

        return lista;
    }

}
