/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.Listas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sistemaamerico.TelaClientes;

public class TelaClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tbCliente;

    @FXML
    private TableColumn<Cliente, String> clmNome;

    @FXML
    private TableColumn<Cliente, String> clmCnpj;

    @FXML
    private TableColumn<Cliente, String> clmTelefone;

    @FXML
    private TableColumn<Cliente, String> clmCidade;

    @FXML
    private TableColumn<Cliente, String> clmResponsavel;

    @FXML
    private Button btSelecionarCliente;

    @FXML
    private Button btPesquisarCliente;

    @FXML
    private Button btMenu;

    @FXML
    private TextField tfPesquisarCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btMenu.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.voltarMenuInicial();
            TelaClientes.getStage().close();
        });
    }

    private void iniciarInitAmalcaburio() {
        clmNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clmCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        clmTelefone.setCellValueFactory(new PropertyValueFactory("numero"));
        clmCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        clmResponsavel.setCellValueFactory(new PropertyValueFactory("responsavel"));
    }

    @FXML
    private void onBtPesquisar() {
        try {
            String i = tfPesquisarCliente.getText();
            for (Cliente t : Listas.listCliente) {
                if (t.getNome().toUpperCase().contains(i.toUpperCase())) {
                    iniciarInitAmalcaburio();
                    tbCliente.setItems(Busca());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    private ObservableList<Cliente> Busca() {
        ObservableList<Cliente> obsPesquisa = FXCollections.observableArrayList();
        String i = tfPesquisarCliente.getText();
        for (Cliente t : Listas.listCliente) {
            if (t.getNome().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Cliente(t.getNome(), t.getCnpj(), t.getNumero(), t.getCidade(), t.getResponsavel()));
            }
        }
        return obsPesquisa;
    }

}
