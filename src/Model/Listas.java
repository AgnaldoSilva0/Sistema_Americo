package Model;

import BD.Pesquisar;
import Limitadores.Alertas;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.control.Alert;

public class Listas {

    public static List<Cliente> listCliente = new ArrayList();
    public static List<Produto> listProduto = new ArrayList();
    public static List<Produto> listOrcamento = new ArrayList();
    public static Set<Orcamento> listListaOrcamento = new HashSet<Orcamento>();
    public static List lista = new ArrayList();

    public static void carregarTodasListas() {

        try {
            if (listProduto.isEmpty()) {
                Pesquisar.pesquisarProduto();
            }
            if (listOrcamento.isEmpty()) {
                Pesquisar.pesquisarOrcamento(0,0);
            }
            if (listCliente.isEmpty()) {
                Pesquisar.pesquisarCliente();
            }
        } catch (NumberFormatException e) {
            Alertas.showAlert("Erro ao Carregar a lista", "ERRO FATAL", "Contate o Administrador", Alert.AlertType.ERROR);
        }
    }
}
