package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sistemaamerico.CadastrarProduto;

public class TelaCadastroProdutoController implements Initializable {
    
    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfPreco;

    @FXML
    private TextField tfIpi;

    @FXML
    private Button btCadastrar;
    
    @FXML
    private Button btMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            cadastrarProduto();
        });
       
       btMenu.setOnMouseClicked((MouseEvent e) -> {
            Gerenciadores.GerenciadorDeTelas.voltarMenuInicial();
            CadastrarProduto.getStage().close();
        });
    }    
    
    private void cadastrarProduto() {
        String codigo = tfCodigo.getText();
        String descricao = tfDescricao.getText();
        double preco = Double.parseDouble(tfPreco.getText());
        int ipi = Integer.parseInt(tfIpi.getText());
        Gerenciadores.GerenciadorListaProduto.cadastrarProduto(codigo, descricao, preco, ipi);
        limparTextField();
    }
    
    private void limparTextField() {
        tfCodigo.clear();
        tfDescricao.clear();
        tfIpi.clear();
        tfPreco.clear();
    }
    
    
    
}
