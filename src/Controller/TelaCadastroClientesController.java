/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BD.Insert;
import Gerenciadores.GerenciadorListaCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sistemaamerico.TelaCadastroCliente;

public class TelaCadastroClientesController implements Initializable {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCnpj;

    @FXML
    private TextField tfIe;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfEstado;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfResponsavel;

    @FXML
    private Button btCadastarCliente;

    @FXML
    private Button btMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btMenu.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.voltarMenuInicial();
            TelaCadastroCliente.getStage().close();
        });
        btCadastarCliente.setOnMouseClicked((MouseEvent e) -> {
            cadastrarCliente();
        });
    }

    private void cadastrarCliente() {
        String nome = tfNome.getText();
        String cnpj = tfCnpj.getText();
        String ie = tfIe.getText();
        String endereco = tfEndereco.getText();
        String cidade = tfCidade.getText();
        String estado = tfEstado.getText();
        String cep = tfCep.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        String responsavel = tfResponsavel.getText();
        Insert.inserirCliente(nome, cnpj, endereco, email, telefone, cidade, cep, estado, responsavel, ie);
        limparCampos();
    }

    private void limparCampos() {
        tfNome.setText("N/A");
        tfCnpj.setText("N/A");
        tfCep.setText("N/A");
        tfCidade.setText("N/A");
        tfEmail.setText("N/A");
        tfEndereco.setText("N/A");
        tfEstado.setText("N/A");
        tfIe.setText("N/A");
        tfResponsavel.setText("N/A");
        tfTelefone.setText("N/A");
    }

}
