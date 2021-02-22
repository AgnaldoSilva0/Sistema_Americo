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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgLogoM.setImage(new Image("/Icons/logoM.png"));
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
    
}