/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Limitadores.Alertas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Usuario
 */
public class Delete {
    
    public static void deletarProdutoOrcamento(int idProduto, int idCliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexoes.conectar();
            
            String sql = "DELETE FROM table_orcamento"
                    + " WHERE idProdutokey = ? AND idClientekey = ?;";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            ps.setInt(2, idCliente);
            
            int linhasAfetadas = ps.executeUpdate();
            System.out.println(linhasAfetadas);
            
        } catch(SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }
    
    public static void deletarOrcamento(String idOrcamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexoes.conectar();
            
            String sql = "DELETE FROM table_orcamento"
                    + " WHERE idOrcamento = ?;";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, idOrcamento);
            System.out.println(idOrcamento);
            
            int linhasAfetadas = ps.executeUpdate();
            Alertas.showAlert("Sucesso", "Orçameno Excluido com Sucesso", idOrcamento, Alert.AlertType.CONFIRMATION);
            
        } catch(SQLException e) {
            Alertas.showAlert("Erro", "Aconteceu um erro ao tentar excluir o item, tente novamente!", "", Alert.AlertType.ERROR);
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }
    
    public static void deletarCliente(String cnpj) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexoes.conectar();
            
            String sql = "DELETE FROM table_cliente"
                    + " WHERE cnpj = ?;";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, cnpj);
            
            int linhasAfetadas = ps.executeUpdate();
            Alertas.showAlert("Sucesso", "Cliente Excluido com Sucesso", cnpj, Alert.AlertType.CONFIRMATION);
            
        } catch(SQLException e) {
            Alertas.showAlert("Erro", "Aconteceu um erro ao tentar excluir o item, tente novamente!", "", Alert.AlertType.ERROR);
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }
    
}
