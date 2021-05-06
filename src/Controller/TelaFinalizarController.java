/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Jasper.ImpressaoOrcamento;
import Jasper.SaidaDados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class TelaFinalizarController implements Initializable {

    @FXML
    private TextField tfPagamento;

    @FXML
    private TextField tfTransportadora;

    @FXML
    private TextField tfDesconto;

    @FXML
    private TextArea tfObservacoes;

    @FXML
    private Button brFinalizar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void onBtActionFinalizar() {
        SaidaDados sd = new SaidaDados();
        sd.setPagamento(tfPagamento.getText());
        sd.setTransportadora(tfTransportadora.getText());
        sd.setDesconto(tfDesconto.getText());
        sd.setObservacao(tfObservacoes.getText());
        ImpressaoOrcamento.imprimir();
    }

}
