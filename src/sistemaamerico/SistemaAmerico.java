/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaamerico;

import Controller.TelaProdutoController;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class SistemaAmerico extends Application {

    private static Stage stage;
    private static Scene cenaPrincipal;
    private static Scene cenaProdutos;
    private static Scene cenaOrcamentos;
    private static Scene cenaClientes;
    private static Scene cenaCadastroProdutos;
    private static Scene cenaCadastrarClientes;
    private static Scene cenaFinalizar;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        
        Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("/View/InicioOpcoes.fxml"));
        cenaPrincipal = new Scene(fxmlTelaInicial);
        
        //Parent fxmlTelaProdutos = FXMLLoader.load(getClass().getResource("/View/TelaProduto.fxml"));
        //cenaProdutos = new Scene(fxmlTelaProdutos); 
        
        
        FXMLLoader fxmlTelaProdutos1 = new FXMLLoader(getClass().getResource("/View/TelaProduto.fxml"));
        Parent fxmlTelaProdutos = fxmlTelaProdutos1.load();
        cenaProdutos = new Scene(fxmlTelaProdutos); 
        TelaProdutoController controller = fxmlTelaProdutos1.getController();
        controller.carregarOrcamento();
        
        
        Parent fxmlTelaOrcamento = FXMLLoader.load(getClass().getResource("/View/TelaCarregarOrcamento.fxml"));
        cenaOrcamentos = new Scene(fxmlTelaOrcamento); 
        
        Parent fxmlTelaClientes = FXMLLoader.load(getClass().getResource("/View/TelaCliente.fxml"));
        cenaClientes = new Scene(fxmlTelaClientes); 
                
        Parent fxmlTelaCadastroProduto = FXMLLoader.load(getClass().getResource("/View/TelaCadastroProduto.fxml"));
        cenaCadastroProdutos = new Scene(fxmlTelaCadastroProduto);
        
        Parent fxmlCadastrarCliente = FXMLLoader.load(getClass().getResource("/View/TelaCadastroClientes.fxml"));
        cenaCadastrarClientes = new Scene(fxmlCadastrarCliente);
        
        Parent fxmlTelaFinalizar = FXMLLoader.load(getClass().getResource("/View/TelaFinalizar.fxml"));
        cenaFinalizar = new Scene(fxmlTelaFinalizar);
        
        primaryStage.setTitle("Américo Representações");
        primaryStage.getIcons().add(new Image("/Icons/logoM.png"));

        primaryStage.setScene(cenaPrincipal);
        primaryStage.show();
    }
    
    public static void mudarTela(int numeracao, Object userData) {
        switch (numeracao) {
            case 1:
                stage.setScene(cenaPrincipal);
                stage.setTitle("Américo Representações");
                stage.centerOnScreen();
                notifyAllListners(1, userData);
                break;
            case 2:
                stage.setScene(cenaProdutos);
                stage.setTitle("Orçamento");
                stage.centerOnScreen();
                notifyAllListners(2, userData);
                break;
            case 3:
                stage.setScene(cenaOrcamentos);
                stage.setTitle("Selecionar Orçamento");
                stage.centerOnScreen();
                notifyAllListners(3, userData);
                break;
            case 4:
                stage.setScene(cenaClientes);
                stage.setTitle("Clientes");
                stage.centerOnScreen();
                notifyAllListners(4, userData);
                break;
            case 5:
                stage.setScene(cenaCadastroProdutos);
                stage.setTitle("Cadastrar Produtos");
                stage.centerOnScreen();
                notifyAllListners(5, userData);
                break;
            case 6:
                stage.setScene(cenaCadastrarClientes);
                stage.setTitle("Cadastrar Cliente");
                stage.centerOnScreen();
                notifyAllListners(6, userData);
                break;
            case 7:
                stage.setScene(cenaFinalizar);
                stage.setTitle("Finalizar");
                stage.centerOnScreen();
                notifyAllListners(7, userData);
        }
    }
    
    public static void mudarTela(int numeracao) {
        mudarTela(numeracao, null);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SistemaAmerico.stage = stage;
    }
    
    private static ArrayList<OnChangeScreen> listners = new ArrayList<>();
    
    public static interface OnChangeScreen {
        void onScreenChanged(int newScreen, Object userData);
    }
    
    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
        listners.add(newListener);
    }
    
    private static void notifyAllListners(int newScreen, Object userData) {
        for (OnChangeScreen l : listners) {
            l.onScreenChanged(newScreen, userData);
        }
    }
    
}
