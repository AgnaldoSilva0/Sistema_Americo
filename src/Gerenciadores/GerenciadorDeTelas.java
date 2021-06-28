package Gerenciadores;

import Controller.TelaInicialController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import sistemaamerico.SistemaAmerico;
import sistemaamerico.TelaFinalizar;
import sistemaamerico.TelaTermos;

public class GerenciadorDeTelas {

    public static void abrirTelaCadastroProduto() {
        SistemaAmerico.mudarTela(5);
    }

    public static void abrirTelaProduto() {
        SistemaAmerico.mudarTela(2);
    }

    public static void abrirTelaCliente() {
        SistemaAmerico.mudarTela(4);
    }

    public static void abrirTelaCadastroCliente() {
        SistemaAmerico.mudarTela(6);
    }

    public static void abrirTelaTermos() {
        TelaTermos instancia = new TelaTermos();
        try {
            instancia.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void abrirTelaListaOrcamento() {
        SistemaAmerico.mudarTela(3);
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
        SistemaAmerico.mudarTela(1);
    }
    

}
