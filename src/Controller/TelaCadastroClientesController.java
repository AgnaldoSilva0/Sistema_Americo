/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BD.Insert;
import Limitadores.Alertas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
        });
        btCadastarCliente.setOnMouseClicked((MouseEvent e) -> {
            cadastrarCliente();
        });
    }

    private void cadastrarCliente() {
        if(tfNome.getText().trim().isEmpty() || tfCnpj.getText().trim().isEmpty()) {
            Alertas.showAlert("Campo Vazio", "Preencha os campos obrigatórios", "Nome e CNPJ não podem ser vazios!", Alert.AlertType.WARNING);
            return;
        }
        
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
        Alertas.showAlert("Cliente Cadastrado", "Sucesso", nome, Alert.AlertType.CONFIRMATION);
        limparCampos();
    }

    private void limparCampos() {
        tfNome.clear();
        tfCnpj.clear();
        tfCep.clear();
        tfCidade.clear();
        tfEmail.clear();
        tfEndereco.clear();
        tfEstado.clear();
        tfIe.clear();
        tfResponsavel.clear();
        tfTelefone.clear();
    }

}
