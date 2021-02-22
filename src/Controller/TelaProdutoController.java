package Controller;

import Limitadores.Alertas;
import Model.Listas;
import Model.Produto;
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
import sistemaamerico.TelaProdutos;

public class TelaProdutoController implements Initializable {
    
    @FXML
    private TableView<Produto> tbProdutos;

    @FXML
    private TableColumn<Produto, String> clmCodigo;

    @FXML
    private TableColumn<Produto, String> clmDescricao;

    @FXML
    private TableColumn<Produto, Double> clmPreco;

    @FXML
    private TableColumn<Produto, Integer> clmIpi;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btOrcamento;
    
    @FXML
    private Button btMenu;
    
    @FXML
    private Button btAdicionarProdutoOrcamento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btMenu.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.voltarMenuInicial();
            TelaProdutos.getStage().close();
        });
       
       btOrcamento.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.abrirTelaOrcamento();
        });
       btAdicionarProdutoOrcamento.setOnMouseClicked((MouseEvent e) -> {
            adicionarProdutoOrcamento();
        });
    }    
    
    private void iniciarInitAmalcaburio() {
        clmCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmIpi.setCellValueFactory(new PropertyValueFactory("ipi"));
        clmPreco.setCellValueFactory(new PropertyValueFactory("preco"));
    }

    @FXML private void onBtPesquisarCodigo() {
        try {
            String i = tfPesquisar.getText();
            for (Produto t : Listas.listProduto) {
                if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                    iniciarInitAmalcaburio();
                    tbProdutos.setItems(Busca());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    private ObservableList<Produto> Busca() {
        ObservableList<Produto> obsPesquisa = FXCollections.observableArrayList();
        String i = tfPesquisar.getText();
        for (Produto t : Listas.listProduto) {
            if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Produto(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getIpi()));
            }
        }
        return obsPesquisa;
    }
    
    private void adicionarProdutoOrcamento() {
        try {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        String codigo = tbProdutos.getSelectionModel().getSelectedItem().getCodigo();
        String descricao = tbProdutos.getSelectionModel().getSelectedItem().getDescricao();
        double preco = tbProdutos.getSelectionModel().getSelectedItem().getPreco();
        int ipi = tbProdutos.getSelectionModel().getSelectedItem().getIpi();
        double precoTotal = tbProdutos.getSelectionModel().getSelectedItem().getPreco();
        Gerenciadores.GerenciadorListaOrcamento.adicionarProdutoOrcamento(quantidade, codigo, descricao, preco, ipi, precoTotal);
        } catch (NullPointerException e) {
            Alertas.showAlert("Nenhum Item Selecionado", "Selecionar item para adicionar ao orçamento", "", Alert.AlertType.INFORMATION);
        }
    }
    
}
