package Controller;

import Gerenciadores.GerenciadorArquivo;
import Gerenciadores.GerenciadorListaOrcamento;
import Limitadores.Alertas;
import Model.Cliente;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import sistemaamerico.TelaOrcamento;

public class TelaOrcamentoController implements Initializable {
    
    @FXML
    private TableView<Produto> tbProdutosOrcamento;

    @FXML
    private TableColumn<Produto, Integer> clmQuantidadeOrcamento;

    @FXML
    private TableColumn<Produto, String> clmCodigoOrcamento;

    @FXML
    private TableColumn<Produto, String> clmDescricaoOrcamento;

    @FXML
    private TableColumn<Produto, Double> clmPrecoOrcamento;

    @FXML
    private TableColumn<Produto, Double> clmPrecoTotalOrcamento;
    
    @FXML
    private TableView<Cliente> tbClientesOrcamento;

    @FXML
    private TableColumn<Cliente, String> clmCliente;

    @FXML
    private TableColumn<Cliente, String> clmCnpj;

    @FXML
    private TableColumn<Cliente, String> clmTelefone;

    @FXML
    private TableColumn<Cliente, String> clmResponsavel;

    @FXML
    private Label lbValorTotal;

    @FXML
    private Button btIncrementar;

    @FXML
    private Button btDecrementar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btMenu;
    
    @FXML
    private Button btGerarArquivoOrcamento;
    
    @FXML
    private Button btLimparLista;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btGerarArquivoOrcamento.setOnMouseClicked((MouseEvent e) -> {
            entradaDadosCliente();
        });
        btMenu.setOnMouseClicked((MouseEvent e) -> {
            TelaOrcamento.getStage().close();
        });
        btLimparLista.setOnMouseClicked((MouseEvent e) -> {
            limparListaOrcamento();
        });
        tbProdutosOrcamento.setItems(ObsMetodo());
        tbClientesOrcamento.setItems(ObsMetodoCliente());
        iniciarInitTabela();
        iniciarInitTabelaCliente();
        valorTotal();
    }    
    
    private void iniciarInitTabela() {
        clmCodigoOrcamento.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricaoOrcamento.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmQuantidadeOrcamento.setCellValueFactory(new PropertyValueFactory("quantidade"));
        clmPrecoOrcamento.setCellValueFactory(new PropertyValueFactory("preco"));
        clmPrecoTotalOrcamento.setCellValueFactory(new PropertyValueFactory("PrecoTotal"));
    }
    
    private ObservableList<Produto> ObsMetodo() {
        ObservableList<Produto> obs = FXCollections.observableArrayList();
            for (Produto t : Listas.listOrcamento) {
                obs.add(new Produto(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getPrecoTotal(), t.getIpi(),
                        t.getQuantidade()));
		}
		return obs;
	}
    
    private void iniciarInitTabelaCliente() {
        clmCliente.setCellValueFactory(new PropertyValueFactory("nome"));
        clmCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        clmTelefone.setCellValueFactory(new PropertyValueFactory("numero"));
        clmResponsavel.setCellValueFactory(new PropertyValueFactory("responsavel"));
    }
    
    private ObservableList<Cliente> ObsMetodoCliente() {
        ObservableList<Cliente> obs1 = FXCollections.observableArrayList();
            for (Cliente t : Listas.listCliente) {
                obs1.add(new Cliente(t.getNome(), t.getCnpj(), t.getNumero(), t.getCidade(), t.getResponsavel()));
		}
		return obs1;
	}
    
    @FXML
    public void onBtActionAdicionarProduto() {
        try {
            String codigo = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getPrecoTotal();
            GerenciadorListaOrcamento.incrementarProduto(codigo, descricao, preco, quantidade, total);
            GerenciadorListaOrcamento.addProdutoArquivoOrcamento();
            tbProdutosOrcamento.setItems(ObsMetodo());
            valorTotal();
        } catch (java.lang.RuntimeException e){
            Alertas.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja adicionar", Alert.AlertType.INFORMATION);
        } 
        }
        
    
    @FXML
    public void onBtActionDecrementarProduto() {
        try {
            String codigo = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getPrecoTotal();
            GerenciadorListaOrcamento.decrementarProduto(codigo, descricao, preco, quantidade, total);
            GerenciadorListaOrcamento.addProdutoArquivoOrcamento();
            tbProdutosOrcamento.setItems(ObsMetodo());
            valorTotal();
        } catch (java.lang.RuntimeException e){
            Alertas.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja diminuir", Alert.AlertType.INFORMATION);
        }
        }
    
    @FXML
    public void onBtActionRemoverProduto() {
        try {
            String codigo = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getPrecoTotal();
            GerenciadorListaOrcamento.removerProduto(codigo, descricao, preco, quantidade, total);
            GerenciadorListaOrcamento.addProdutoArquivoOrcamento();
            tbProdutosOrcamento.setItems(ObsMetodo());
            valorTotal();
        } catch (java.lang.RuntimeException e){
            Alertas.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja remover", Alert.AlertType.INFORMATION);
        }
        }
    
    public void valorTotal() {
        double total = 0;
        for (Produto produto : Listas.listOrcamento) {
            total = total + produto.getPrecoTotal();
        }
       lbValorTotal.setText(String.valueOf(total));
    }
    
    private void entradaDadosCliente() {
        try {
            String cnpj = tbClientesOrcamento.getSelectionModel().getSelectedItem().getCnpj();
        for (Cliente i : Listas.listCliente) {
            if (i.getCnpj().equalsIgnoreCase(cnpj)) {               
                GerenciadorArquivo.salvarArquivoOrcamento(i.getNome(), i.getCnpj(), i.getEndereco(), i.getEmail(), 
                        i.getNumero(), i.getCidade(), i.getCep(), i.getUf(), i.getResponsavel(), i.getInscricaoEstadual());
            }
        }
        } catch (NullPointerException e) {
            Alertas.showAlert("Cliente não selecionado", "Nenhum Cliente Selecionado", "Selecione Um cliente da lista para gerar o arquivo", Alert.AlertType.INFORMATION);
        }
    }
    
    private void limparListaOrcamento() {
        Listas.listOrcamento.clear();
        GerenciadorListaOrcamento.addProdutoArquivoOrcamento();
        tbProdutosOrcamento.setItems(ObsMetodo());
        Alertas.showAlert("Sucesso", "Lista zerada", "", Alert.AlertType.CONFIRMATION);
    }
}
