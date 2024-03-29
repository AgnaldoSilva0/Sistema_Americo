package Gerenciadores;

import Model.Listas;
import Model.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorListaProduto {

    //Banco TXT
    public static void carregarProduto() {
        String patch = "C:\\BDs\\BDAmalcaburio.txt";
        int contador = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaProduto = br.readLine();
            while (linhaProduto != null) {
                String[] vectLeitor = linhaProduto.split(";");
                String codigo = (vectLeitor[0]);
                String descricao = (vectLeitor[1]);
                double preco = Double.parseDouble(vectLeitor[2]);
                int ipi = Integer.parseInt(vectLeitor[3]);
                //Listas.listProduto.add(new Produto(codigo, descricao, preco, ipi));
                linhaProduto = br.readLine();
                contador = contador + 1;
                System.out.println(contador);
                System.out.println(codigo);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Banco TXT
    public static void addProduto() {
        String patch = "C:\\BDs\\BDAmalcaburio.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Produto produto : Listas.listProduto) {
                bw.write(produto.getCodigo() + ";" + produto.getDescricao() + ";" + produto.getPreco() + ";" + produto.getIpi());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cadastrarProduto(String codigo, String descricao, double preco, int ipi) {
        //Listas.listProduto.add(new Produto(codigo, descricao, preco, ipi));
        addProduto();
    }

}
