package Model;

import Limitadores.Alertas;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

public class Listas {
    
    public static List <Cliente> listCliente = new ArrayList();
    public static List <Produto> listProduto = new ArrayList();
    public static List <Produto> listOrcamento = new ArrayList();
    public static List lista = new ArrayList();
    
    public static void carregarTodasListas() {
        
        try {
        if (listProduto.isEmpty()) {
            Gerenciadores.GerenciadorListaProduto.carregarProduto();
        }
        if (listOrcamento.isEmpty()) {
            Gerenciadores.GerenciadorListaOrcamento.carregarOrcamento();
        }
        if (listCliente.isEmpty()) {
            Gerenciadores.GerenciadorListaCliente.carregarCliente();
        }
        } catch (NumberFormatException e) {
            Alertas.showAlert("Erro ao Carregar a lista", "ERRO FATAL", "Contate o Administrador", Alert.AlertType.ERROR);
        }
    }
}
