/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BD.Delete;
import BD.Pesquisar;
import Limitadores.Alertas;
import Model.Cliente;
import Model.Listas;
import Model.Orcamento;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import sistemaamerico.SistemaAmerico;

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
    private Button btMenu, btExcluirCliente;

    @FXML
    private TextField tfPesquisarCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btMenu.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.voltarMenuInicial();
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
    
    @FXML
    private void criarOrcamento() {
        Orcamento.cnpjStatic = tbCliente.getSelectionModel().getSelectedItem().getCnpj();
        Orcamento.nOrcamento = JOptionPane.showInputDialog("Identificação Orçamento");
        
        SistemaAmerico.mudarTela(2, "Agnaldo");
    }
    
    @FXML
    private void onBtExcluirCliente() {
        String cnpj = tbCliente.getSelectionModel().getSelectedItem().getCnpj();
        
        if (Alertas.OpcaoYesNo(cnpj) == true) {
            Delete.deletarCliente(cnpj);
            Alertas.showAlert("Cliente ecluido com sucesso", cnpj, "", Alert.AlertType.CONFIRMATION);
            
            Listas.listCliente.clear();
            Pesquisar.pesquisarCliente();
            iniciarInitAmalcaburio();
            tbCliente.setItems(Busca());
        }
        
    }

}
