package Controller;

import BD.Delete;
import BD.Insert;
import BD.Pesquisar;
import BD.Update;
import Gerenciadores.GerenciadorDeTelas;
import Jasper.SaidaDados;
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
import javafx.scene.control.MenuItem;
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
    private TableColumn<Produto, Double> clmIpi;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btOrcamento;

    @FXML
    private Button btAdicionarProdutoOrcamento;

    @FXML
    private TableView<Cliente> tbClienteOrcamento;

    @FXML
    private TableColumn<Cliente, String> clmCliente;

    @FXML
    private TableColumn<Cliente, String> clmCnpj;

    @FXML
    private TableColumn<Cliente, String> clmTelefone;

    @FXML
    private TableColumn<Cliente, String> clmResponsavel;

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
    private Button btIncrementar;

    @FXML
    private Button btDecrementar;

    @FXML
    private Button btExcluir;

    @FXML
    private MenuItem miMenu;

    @FXML
    private MenuItem imCarregarOrcamento;

    @FXML
    private Label lbValorTotal;

    @FXML
    private Label lbNomeCliente;

    @FXML
    private Label lbCnpj;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btOrcamento.setOnMouseClicked((MouseEvent e) -> {
            entradaDadosCliente();
        });
        btAdicionarProdutoOrcamento.setOnMouseClicked((MouseEvent e) -> {
            adicionarProdutoOrcamento(1, 0);
        });
        btIncrementar.setOnMouseClicked((MouseEvent e) -> {
            adicionarProdutoOrcamento(2, 1);
        });
        btDecrementar.setOnMouseClicked((MouseEvent e) -> {
            adicionarProdutoOrcamento(3, 2);
        });
        btExcluir.setOnMouseClicked((MouseEvent e) -> {
            adicionarProdutoOrcamento(4, 0);
        });
        tbProdutosOrcamento.setItems(ObsMetodo());
        tbClienteOrcamento.setItems(ObsMetodoCliente());
        iniciarInitTabela();
        iniciarInitTabelaCliente();
        valorTotal();
    }

    //Referencia objeto a tabela
    private void iniciarInitTabela() {
        clmCodigoOrcamento.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricaoOrcamento.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmQuantidadeOrcamento.setCellValueFactory(new PropertyValueFactory("quantidade"));
        clmPrecoOrcamento.setCellValueFactory(new PropertyValueFactory("preco"));
        clmPrecoTotalOrcamento.setCellValueFactory(new PropertyValueFactory("PrecoTotal"));
    }

    //Retorna lista para preencher tabela
    private ObservableList<Produto> ObsMetodo() {
        ObservableList<Produto> obs = FXCollections.observableArrayList();
        for (Produto t : Listas.listOrcamento) {
            obs.add(new Produto(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getPrecoTotal(), t.getIpi(),
                    t.getQuantidade()));
        }
        return obs;
    }
    
    //Referencia objeto a tabela
    private void iniciarInitTabelaCliente() {
        clmCliente.setCellValueFactory(new PropertyValueFactory("nome"));
        clmCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        clmTelefone.setCellValueFactory(new PropertyValueFactory("numero"));
        clmResponsavel.setCellValueFactory(new PropertyValueFactory("responsavel"));
    }

    //Retorna lista para preencher tabela
    private ObservableList<Cliente> ObsMetodoCliente() {
        ObservableList<Cliente> obs1 = FXCollections.observableArrayList();
        for (Cliente t : Listas.listCliente) {
            obs1.add(new Cliente(t.getNome(), t.getCnpj(), t.getNumero(), t.getCidade(), t.getResponsavel()));
        }
        return obs1;
    }
    
    //Referencia objeto a tabela
    private void iniciarInitAmalcaburio() {
        clmCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmIpi.setCellValueFactory(new PropertyValueFactory("ipi"));
        clmPreco.setCellValueFactory(new PropertyValueFactory("preco"));
    }

    //Metodo para pesquisar item
    @FXML
    private void onBtPesquisarCodigo() {
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

    //Retorna lista para preencher tabela
    private ObservableList<Produto> Busca() {
        ObservableList<Produto> obsPesquisa = FXCollections.observableArrayList();
        String i = tfPesquisar.getText();
        for (Produto t : Listas.listProduto) {
            if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Produto(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getIpi(), t.getIdProduto()));
            }
        }
        return obsPesquisa;
    }

    //Adiciona, atualiza, exclui Item no Banco de dados table_orcamento
    private void adicionarProdutoOrcamento(int decisao, int addORremove) {
        String cnpj = lbCnpj.getText();
        try {
            switch (decisao) {
                //Adiciona ao orcamento
                case 1:
                    String codigo = tbProdutos.getSelectionModel().getSelectedItem().getCodigo();
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
                    //Insere no table_orcamento o item com o respectivo cliente
                    Insert.inserirOrcamento(cnpj, codigo, quantidade);
                    break;
                //Incrementa no orcamento
                case 2:
                    String codigoOrcamentoADD = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getCodigo();
                    int quantidade1 = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getQuantidade();
                    //Atualiza a quantidade de item
                    Update.atualizarQuantProduto(Integer.parseInt(Pesquisar.retornaIdProduto(codigoOrcamentoADD)),
                            Pesquisar.retornaIdCliente(cnpj), quantidade1, 1);
                    Pesquisar.pesquisarOrcamento(Pesquisar.retornaIdCliente(cnpj));
                    break;
                //Decrementa Produto orçamento
                case 3:
                    String codigoOrcamentoRem = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getCodigo();
                    int quantidadeRem = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getQuantidade();
                    //Atualiza a quantidade de item
                    Update.atualizarQuantProduto(Integer.parseInt(Pesquisar.retornaIdProduto(codigoOrcamentoRem)),
                            Pesquisar.retornaIdCliente(cnpj), quantidadeRem, 2);
                    Pesquisar.pesquisarOrcamento(Pesquisar.retornaIdCliente(cnpj));
                    break;
                //Deleta produto orçamento
                case 4:
                    String codigoOrcamentoEx = tbProdutosOrcamento.getSelectionModel().getSelectedItem().getCodigo();
                    Delete.deletarProdutoOrcamento(Integer.parseInt(Pesquisar.retornaIdProduto(codigoOrcamentoEx)),
                            Pesquisar.retornaIdCliente(cnpj));
            }
        } catch (NullPointerException e) {
            Alertas.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja diminuir", Alert.AlertType.INFORMATION);
        } finally {
            atualizarTabela(cnpj);
        }
    }

    //Preenche a lista que será usada para imprimir os dados no jasper
    private void entradaDadosCliente() {
        Listas.lista.clear();
        try {
            double total = 0;
            for (Produto produto : Listas.listOrcamento) {
                total = total + produto.getPrecoTotal();
            }
            SaidaDados sd = new SaidaDados();
            String cnpj = lbCnpj.getText();
            sd.setValorTotal(total);
            for (Cliente i : Listas.listCliente) {
                if (i.getCnpj().equalsIgnoreCase(cnpj)) {
                    sd.setCliente(i.getNome());
                    sd.setCnpj(i.getCnpj());
                    sd.setEndereco(i.getEndereco());
                    sd.setEmail(i.getEmail());
                    sd.setNumero(i.getNumero());
                    sd.setCidade(i.getCidade());
                    sd.setCep(i.getCep());
                    sd.setUf(i.getUf());
                    sd.setIe(i.getInscricaoEstadual());
                }
            }
            for (Produto e : Listas.listOrcamento) {
                Listas.lista.add(new SaidaDados(e.getCodigo(), e.getDescricao(), e.getPreco(), e.getPrecoTotal(), e.getQuantidade()));
            }
            GerenciadorDeTelas.abrirTelaFinalizar();
        } catch (NullPointerException e) {
            Alertas.showAlert("Cliente não selecionado", "Nenhum Cliente Selecionado", "Selecione Um cliente da lista para gerar o arquivo", Alert.AlertType.INFORMATION);
        }
    }

    //Carrega o orçamento através do CNPJ da pessoa selecionada na tabela cliente
    @FXML
    private void onBtCarregarOrcamento() {
        try {
            int idCliente = Pesquisar.retornaIdCliente(tbClienteOrcamento.getSelectionModel().getSelectedItem().getCnpj());
            Pesquisar.pesquisarOrcamento(idCliente);
            lbCnpj.setText(Pesquisar.retornaCliente(idCliente).getCnpj());
            lbNomeCliente.setText(Pesquisar.retornaCliente(idCliente).getNome());
            atualizarTabela(Pesquisar.retornaCliente(idCliente).getCnpj());
            valorTotal();
        } catch (NullPointerException e) {
            Alertas.showAlert("Erro", "Nenhum Cliente Selecionado", "Selecionar Cliente", Alert.AlertType.ERROR);
        }

    }

    //Calcula O valor total do orçamento
    private void valorTotal() {
        double total = 0;
        for (Produto produto : Listas.listOrcamento) {
            total = total + produto.getPrecoTotal();
        }
        lbValorTotal.setText(String.valueOf(total));
    }

    //Atualiza a tabela orcamento ao fazer alguma modificação
    private void atualizarTabela(String cnpj) {
        Pesquisar.pesquisarOrcamento(Pesquisar.retornaIdCliente(cnpj));
        tbProdutosOrcamento.setItems(ObsMetodo());
        valorTotal();
    }

    //Retorna ao Menu Principal
    @FXML
    private void onBtActionMenu() {
        Gerenciadores.GerenciadorDeTelas.voltarMenuInicial();
        TelaProdutos.getStage().close();
    }

}
