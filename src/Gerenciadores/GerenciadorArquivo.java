/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciadores;

import Limitadores.Alertas;
import static Model.Listas.listOrcamento;
import Model.Produto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.JOptionPane;

public class GerenciadorArquivo {
    
    public static void salvarArquivoOrcamento(String nome, String cnpj, String endereco, String email, String numero, 
        String cidade, String cep, String uf, String responsavel, String inscricaoEstadual) {
        
        String condicaoPagamento = JOptionPane.showInputDialog("Condição de Pagamento");
        String transportadora = JOptionPane.showInputDialog("Transportadora");
        String desconto = JOptionPane.showInputDialog("Desconto");
        Window primaryStage = null;
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        File file = chooser.showSaveDialog(primaryStage);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            double valorTotal = 0;
            Date dataHoraAtual = new Date();
            DecimalFormat deci = new DecimalFormat("0.000");
            bw.write("#Cliente: " + nome);
            bw.newLine();
            bw.write("#CNPJ: " + cnpj + " #IE: " + inscricaoEstadual);
            bw.newLine();
            bw.write("Endereço: " + endereco + " CID/UF: " + cidade + "-" + uf);
            bw.newLine();
            bw.write("#TEL: " + numero);
            bw.newLine();
            bw.write("#E-mail: " + email);
            bw.newLine();
            bw.write("#Transportadora: " + transportadora);
            bw.newLine();
            bw.write("#Pagamento: " + condicaoPagamento);
            bw.newLine();
            bw.write("#Responsável: " + responsavel + "___________________" + "        Desconto: " + desconto + "%");
            bw.newLine();
            bw.write("#Data: " + new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual));
            bw.newLine();
            bw.newLine();
            for (Produto pE : listOrcamento) {
                bw.write("Código: " + pE.getCodigo());
                bw.newLine();
                bw.write("Descrição: " + pE.getDescricao());
                bw.newLine();
                bw.write("Quantidade: " + pE.getQuantidade() + " Preço Unitario: R$ "
                        + deci.format(pE.getPreco()) + " Valor Total: R$ " + deci.format(pE.getPrecoTotal()));
                bw.newLine();
                bw.write("----------------------------------------------------------------------------");
                bw.newLine();
                valorTotal = valorTotal + pE.getPrecoTotal();
            }
            bw.write("Valor Total do Orçamento: " + valorTotal);
            Alertas.showAlert("Sucesso", "Arquivo Salvo com Sucesso", file.getName(), Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            Alertas.showAlert("Erro", "Ocorreu um Erro ao salvar o Arquivo", e.getMessage(), Alert.AlertType.WARNING);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Alertas.showAlert("Cancelado", "Nenhum item foi salvo", "Cancelado com Sucesso", Alert.AlertType.INFORMATION);
        }
    }
    
    
    
    }
    
