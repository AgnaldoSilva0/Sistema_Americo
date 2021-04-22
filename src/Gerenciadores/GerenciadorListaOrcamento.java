package Gerenciadores;

import Model.Listas;
import Model.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorListaOrcamento {
    
    public static void carregarOrcamento() {
        String patch = "C:\\BDs\\BDOrcamento.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaProduto = br.readLine();
            while (linhaProduto != null) {
                String[] vectLeitor = linhaProduto.split(";");
                int quantidade = Integer.parseInt(vectLeitor[0]);
                String codigo = (vectLeitor[1]);
                String descricao = (vectLeitor[2]);
                double preco = Double.parseDouble(vectLeitor[3]);
                int ipi = Integer.parseInt(vectLeitor[4]);
                double precoTotal = Double.parseDouble(vectLeitor[5]);
                Listas.listOrcamento.add(new Produto(codigo, descricao, preco, precoTotal, ipi, quantidade));
                linhaProduto = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void addProdutoArquivoOrcamento() {
        String patch = "C:\\BDs\\BDOrcamento.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
            for (Produto produto : Listas.listOrcamento) {
                bw.write(produto.getQuantidade() + ";" + produto.getCodigo() + ";" + produto.getDescricao() 
                        + ";" + produto.getPreco() + ";" + produto.getIpi() + ";" + produto.getPrecoTotal());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void adicionarProdutoOrcamento(int quantidade, String codigo, String descricao, double preco, int ipi, double precoTotal) {
        for (Produto i : Listas.listOrcamento){
            if (i.getCodigo().equalsIgnoreCase(codigo)) {
                i.setQuantidade(quantidade + i.getQuantidade());
                i.setPrecoTotal(i.getPreco() * i.getQuantidade());
                addProdutoArquivoOrcamento();
                return;
            }
        }
        precoTotal = preco * quantidade;
        Listas.listOrcamento.add(new Produto(codigo, descricao, preco, precoTotal, ipi, quantidade));
        addProdutoArquivoOrcamento();
    }
    
    public static void incrementarProduto(String codigo, String descricao, double preco, int quantidade, double total) {
        for (Produto produto : Listas.listOrcamento) {
            if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                produto.setPrecoTotal(total + produto.getPreco());
                produto.setQuantidade(quantidade + 1);
                return;
            }
        }
    }
    
    public static void decrementarProduto(String codigo, String descricao, double preco, int quantidade, double total) {
        for (Produto produto : Listas.listOrcamento) {
            if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                produto.setPrecoTotal(total - produto.getPreco());
                produto.setQuantidade(quantidade - 1);
                return;
            }
        }
    }
    
    public static void removerProduto(String codigo, String descricao, double preco, int quantidade, double total) {
        for (Produto produto : Listas.listOrcamento) {
            if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                Listas.listOrcamento.remove(produto);
                return;
            }
        }
    }
    
}
