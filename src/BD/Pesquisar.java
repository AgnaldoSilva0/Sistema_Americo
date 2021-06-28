/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Model.Cliente;
import Model.Listas;
import Model.Orcamento;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Pesquisar {

    public static void pesquisarProduto() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "SELECT * FROM banco_produto";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Listas.listProduto.add(new Produto(rs.getString("codigo"), rs.getString("descricao"), rs.getDouble("preco"),
                        rs.getInt("ipi"), rs.getInt("idProduto")));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }

    public static void pesquisarCliente() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "SELECT * FROM table_cliente";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Listas.listCliente.add(new Cliente(rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"),
                        rs.getString("email"), rs.getString("numero"), rs.getString("cidade"), rs.getString("cep"),
                        rs.getString("uf"), rs.getString("responsavel"), rs.getString("ie"), rs.getInt("idCliente")));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }

    public static void pesquisarOrcamento(int idCliente, int idOrcamento) {
        Listas.listOrcamento.clear();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "SELECT * FROM banco_produto "
                    + "INNER JOIN table_orcamento "
                    + "ON banco_produto.idProduto = table_orcamento.idProdutokey "
                    + "WHERE table_orcamento.idClientekey = ? AND table_orcamento.idOrcamento = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setInt(2, idOrcamento);
            rs = ps.executeQuery();

            while (rs.next()) {
                double precoTotal = rs.getDouble("preco") * rs.getInt("quantidade");
                Listas.listOrcamento.add(new Produto(rs.getString("codigo"), rs.getString("descricao"), rs.getDouble("preco"),
                        precoTotal, rs.getInt("ipi"), rs.getInt("idProduto"), rs.getInt("quantidade")));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }

    public static String retornaIdProduto(String codigoProduto) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "SELECT * FROM banco_produto "
                    + "WHERE codigo = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, codigoProduto);
            rs = ps.executeQuery();

            while (rs.next()) {
                codigoProduto = String.valueOf(rs.getInt("idProduto"));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }

        return codigoProduto;
    }

    public static int retornaIdCliente(String cnpj) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        int resultado = 0;

        try {
            conn = Conexoes.conectar();
            String sql = "SELECT * FROM table_cliente"
                    + " WHERE cnpj = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, cnpj);
            rs = ps.executeQuery();

            while (rs.next()) {
                resultado = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }

        return resultado;
    }

    public static Cliente retornaCliente(int idCliente) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Cliente cliente = new Cliente();

        try {
            conn = Conexoes.conectar();
            String sql = "SELECT * FROM table_cliente"
                    + " WHERE idCliente = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setCnpj(rs.getString("cnpj"));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }

        return cliente;
    }

    public static boolean existeNoOrcamento(int idProduto, int idCliente, boolean existe) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "SELECT * FROM table_orcamento "
                    + "WHERE idProdutokey = ? AND idClientekey = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            ps.setInt(2, idCliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }

        return existe;
    }

    public static void pesquisarOrcamentoSet() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            conn = Conexoes.conectar();

            String sql = "SELECT * FROM table_cliente "
                    + "INNER JOIN table_orcamento "
                    + "ON table_cliente.idCliente = table_orcamento.idClientekey";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Listas.listListaOrcamento.add(new Orcamento(rs.getString("nome"), "22", String.valueOf(rs.getInt("idOrcamento")), rs.getString("cnpj")));
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeResultSet(rs);
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }

}
