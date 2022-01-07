package Controller;

import Model.Listas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaInicialController implements Initializable {

    @FXML
    private Button btOrcamento;

    @FXML
    private Button btCliente;

    @FXML
    private Button btConfig;

    @FXML
    private Button btTermos;

    @FXML
    private Button btCadastrarProduto;

    @FXML
    private Button btCadastrarCliente;

    @FXML
    private ImageView imgLogoM;
    
    @FXML
    private ImageView imgOrcamento;
    
    @FXML
    private ImageView imgSair;
    
    @FXML
    private ImageView imgTermos;
    
    @FXML
    private ImageView imgCadastrarProduto;
    
    @FXML
    private ImageView imgCadastrarCliente;
    
    @FXML
    private ImageView imgClientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgLogoM.setImage(new Image("/Icons/logoM.png"));
        imgOrcamento.setImage(new Image("/Icons/orcamento24.png"));
        imgSair.setImage(new Image("/Icons/sair.png"));
        imgTermos.setImage(new Image("/Icons/pdf.png"));
        imgClientes.setImage(new Image("/Icons/pesquisar.png"));
        imgCadastrarProduto.setImage(new Image("/Icons/produto.png"));
        imgCadastrarCliente.setImage(new Image("/Icons/adicionar.png"));
        
        Listas.carregarTodasListas();
        btCadastrarProduto.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.abrirTelaCadastroProduto();
        });

        btOrcamento.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.abrirTelaProduto();
        });
        btCliente.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.abrirTelaCliente();
        });
        btCadastrarCliente.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.abrirTelaCadastroCliente();
        });
        btTermos.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.abrirTelaTermos();
        });

    }
    
    @FXML
    void onBtSair() {
        sistemaamerico.SistemaAmerico.getStage().close();
    }

}
