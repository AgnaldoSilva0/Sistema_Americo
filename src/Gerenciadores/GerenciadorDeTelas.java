package Gerenciadores;

import Controller.TelaInicialController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import sistemaamerico.CadastrarProduto;
import sistemaamerico.SistemaAmerico;
import sistemaamerico.TelaCadastroCliente;
import sistemaamerico.TelaClientes;
import sistemaamerico.TelaFinalizar;
import sistemaamerico.TelaProdutos;
import sistemaamerico.TelaTermos;

public class GerenciadorDeTelas {
    
    public static void abrirTelaCadastroProduto() {
    CadastrarProduto instancia = new CadastrarProduto();
        try {
            instancia.start(new Stage());
            SistemaAmerico.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaProduto() {
    TelaProdutos instancia = new TelaProdutos();
        try {
            instancia.start(new Stage());
            SistemaAmerico.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaCliente() {
    TelaClientes instancia = new TelaClientes();
        try {
            instancia.start(new Stage());
            SistemaAmerico.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaCadastroCliente() {
        TelaCadastroCliente instancia = new TelaCadastroCliente();
        try {
            instancia.start(new Stage());
            SistemaAmerico.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaTermos() {
        TelaTermos instancia = new TelaTermos();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void abrirTelaFinalizar() {
        TelaFinalizar instancia = new TelaFinalizar();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void voltarMenuInicial() {
    SistemaAmerico instancia = new SistemaAmerico();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
