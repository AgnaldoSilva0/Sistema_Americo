/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Model.Listas;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Insert {

    public static void insertProduto(String codigo, String descricao, double preco, int ipi) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "INSERT INTO banco_produto"
                    + " (codigo, descricao, preco, ipi) "
                    + " VALUES "
                    + "(?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, descricao);
            ps.setDouble(3, preco);
            ps.setInt(4, ipi);
            int linhasAfetadas = ps.executeUpdate();
            System.out.println(linhasAfetadas);

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }

    public static void inserirCliente(String nome, String cnpj, String endereco, String email, String numero, String cidade,
            String cep, String uf, String responsavel, String ie) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "INSERT INTO table_cliente"
                    + "(nome, cnpj, endereco, email, numero, cidade, cep, uf, responsavel, ie)"
                    + " VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, cnpj);
            ps.setString(3, endereco);
            ps.setString(4, email);
            ps.setString(5, numero);
            ps.setString(6, cidade);
            ps.setString(7, cep);
            ps.setString(8, uf);
            ps.setString(9, responsavel);
            ps.setString(10, ie);

            int linhasAfetadas = ps.executeUpdate();
            System.out.println(linhasAfetadas);

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }

    public static void inserirOrcamento(String cnpj, String codigoProduto, int quantidade, String idOrcamento) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "INSERT INTO table_orcamento"
                    + "(data, idClientekey, idProdutokey, quantidade, idOrcamento)"
                    + " VALUES "
                    + "(?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "03/05/2021");
            ps.setInt(2, Pesquisar.retornaIdCliente(cnpj));
            ps.setInt(3, Integer.parseInt(Pesquisar.retornaIdProduto(codigoProduto)));
            ps.setInt(4, quantidade);
            ps.setString(5, idOrcamento);

            int linhasAfetadas = ps.executeUpdate();
            System.out.println(linhasAfetadas);

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }

    }

    //Adiciona e Atualiza NÃO ESTÁ EM USO (PONTO DE REFERENCIA)
    public static void salvarOrcamento(int idCliente) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            for (Produto p : Listas.listOrcamento) {
                conn = Conexoes.conectar();
                boolean dec = Pesquisar.existeNoOrcamento(p.getIdProduto(), idCliente, false);

                if (dec == true) {
                    String sql = "UPDATE table_orcamento"
                            + " SET "
                            + " quantidade = ? "
                            + " WHERE idProdutokey = ? AND idClientekey = ?";

                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, p.getQuantidade());
                    ps.setString(2, p.getIdProduto());
                    ps.setInt(3, idCliente);

                    int linhasAfetadas = ps.executeUpdate();
                    System.out.println(linhasAfetadas);

                } else {
                    System.out.println("Baby");
                    String sql1 = "INSERT INTO table_orcamento"
                            + "(data, idClientekey, idProdutokey, quantidade)"
                            + " VALUES "
                            + "(?,?,?,?)";

                    ps = conn.prepareStatement(sql1);
                    ps.setString(1, "03/05/2021");
                    ps.setInt(2, idCliente);
                    ps.setInt(3, Integer.parseInt(Pesquisar.retornaIdProduto(p.getCodigo())));
                    ps.setInt(4, p.getQuantidade());
                    ps.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }

    }

}
