package Gerenciadores;

import Limitadores.Alertas;
import Model.Cliente;
import Model.Listas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;

public class GerenciadorListaCliente {

    //Banco TXT
    public static void carregarCliente() {
        String patch = "C:\\BDs\\BDCliente.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaProduto = br.readLine();
            while (linhaProduto != null) {
                String[] vectLeitor = linhaProduto.split(";");
                String nome = (vectLeitor[0]);
                String cnpj = (vectLeitor[1]);
                String endereco = (vectLeitor[2]);
                String email = (vectLeitor[3]);
                String numero = (vectLeitor[4]);
                String cidade = (vectLeitor[5]);
                String cep = (vectLeitor[6]);
                String uf = (vectLeitor[7]);
                String responsavel = (vectLeitor[8]);
                String ie = (vectLeitor[9]);
                Listas.listCliente.add(new Cliente(nome, cnpj, endereco, email, numero, cidade, cep, uf, responsavel, ie));
                linhaProduto = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Banco TXT
    public static void addCliente() {
        String patch = "C:\\BDs\\BDCliente.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Cliente c : Listas.listCliente) {
                bw.write(c.getNome() + ";" + c.getCnpj() + ";" + c.getEndereco() + ";" + c.getEmail() + ";" + c.getNumero()
                        + ";" + c.getCidade() + ";" + c.getCep() + ";" + c.getUf() + ";" + c.getResponsavel() + ";" + c.getInscricaoEstadual());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarCliente(String nome, String cnpj, String endereco, String email, String numero,
            String cidade, String cep, String uf, String responsavel, String ie) {
        Listas.listCliente.add(new Cliente(nome, cnpj, endereco, email, numero, cidade, cep, uf, responsavel, ie));
        addCliente();
        Alertas.showAlert("Sucesso", "Cliente cadastrado", nome, Alert.AlertType.CONFIRMATION);
    }

}
