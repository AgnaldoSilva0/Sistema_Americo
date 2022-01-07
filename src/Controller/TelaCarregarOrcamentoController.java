/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BD.Pesquisar;
import Limitadores.Alertas;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class TelaCarregarOrcamentoController implements Initializable {

    @FXML
    private TableView<Orcamento> tbOrcamento;

    @FXML
    private TableColumn<Orcamento, String> clmnPedido;

    @FXML
    private TableColumn<Orcamento, String> clmCliente;

    @FXML
    private TableColumn<Orcamento, String> clmData;
    
    @FXML
    private TableColumn<Orcamento, String> clmTeste;

    @FXML
    private Button btCarregar;
    
    @FXML
    private Button btPesquisar;
    
    @FXML
    private Button btAtualizar;

    @FXML
    private TextField tfPesquisar;
    
    @FXML
    private ImageView imgAtualizar;
    
    @FXML
    private ImageView imgSair;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pesquisar.pesquisarOrcamentoSet();
        imgAtualizar.setImage(new Image("/Icons/atualizar.png"));
        imgSair.setImage(new Image("/Icons/sair.png"));
        tbOrcamento.setItems(ObsMetodo());
        iniciarInit();
    }    
    
    //Referencia objeto a tabela
    private void iniciarInit() {
        clmCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        clmData.setCellValueFactory(new PropertyValueFactory("data"));
        clmnPedido.setCellValueFactory(new PropertyValueFactory("nPedido"));
        clmTeste.setCellValueFactory(new PropertyValueFactory("cnpj"));
    }

    //Retorna lista para preencher tabela
    private ObservableList<Orcamento> ObsMetodo() {
        ObservableList<Orcamento> obs = FXCollections.observableArrayList();
        for (Orcamento t : Listas.listListaOrcamento) {
            obs.add(new Orcamento(t.getCliente(), t.getData(), t.getCnpj(), t.getnPedido()));
        }
        return obs;
    }
    
    @FXML
    private void onBtPesquisarCodigo() {
        try {
            String i = tfPesquisar.getText();
            for (Orcamento t : Listas.listListaOrcamento) {
                if (t.getCliente().toUpperCase().contains(i.toUpperCase())) {
                    iniciarInit();
                    tbOrcamento.setItems(ObsMetodo());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }
    
    @FXML
    private void onBtCarregarOrcamento() {
        try {
            Pesquisar.pesquisarOrcamento(Pesquisar.retornaIdCliente(tbOrcamento.getSelectionModel().getSelectedItem().getnPedido()), tbOrcamento.getSelectionModel().getSelectedItem().getCnpj());
            Orcamento.setCnpjStatic(tbOrcamento.getSelectionModel().getSelectedItem().getnPedido());
            Orcamento.setnOrcamento(tbOrcamento.getSelectionModel().getSelectedItem().getCnpj());
            Gerenciadores.GerenciadorDeTelas.abrirTelaProduto();
        } catch (NullPointerException e) {
            Alertas.showAlert("Erro", "Nenhum Cliente Selecionado", "Selecionar Cliente", Alert.AlertType.ERROR);
        } 
    }
    
    @FXML
    private void onBtAtualizarLista() {
        Pesquisar.pesquisarOrcamentoSet();
        imgAtualizar.setImage(new Image("/Icons/atualizar.png"));
        tbOrcamento.setItems(ObsMetodo());
        iniciarInit();
    }
    
    @FXML
    private void onBtSair() {
        Gerenciadores.GerenciadorDeTelas.abrirTelaProduto();
    }
    
}
