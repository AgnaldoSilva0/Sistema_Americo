/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Orcamento {
    
    String cliente;
    String data;
    String nPedido;
    String cnpj;
    //Usado para salvar o cnpj do cliente para usar para carregar o orçamento
    public static String cnpjStatic;
    //Usado para salvar o id do orçamento para inserir itens
    public static String nOrcamento;

    public Orcamento(String cliente, String data, String nPedido, String cnpj) {
        this.cliente = cliente;
        this.data = data;
        this.nPedido = nPedido;
        this.cnpj = cnpj;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getnPedido() {
        return nPedido;
    }

    public void setnPedido(String nPedido) {
        this.nPedido = nPedido;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static String getCnpjStatic() {
        return cnpjStatic;
    }

    public static void setCnpjStatic(String cnpjStatic) {
        Orcamento.cnpjStatic = cnpjStatic;
    }

    public static String getnOrcamento() {
        return nOrcamento;
    }

    public static void setnOrcamento(String nOrcamento) {
        Orcamento.nOrcamento = nOrcamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.cliente);
        hash = 47 * hash + Objects.hashCode(this.data);
        hash = 47 * hash + Objects.hashCode(this.nPedido);
        hash = 47 * hash + Objects.hashCode(this.cnpj);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orcamento other = (Orcamento) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.nPedido, other.nPedido)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }
    
    
    
}
