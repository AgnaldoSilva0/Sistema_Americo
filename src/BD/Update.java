/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Update {
    
    public static void atualizarQuantProduto(int idProduto, int idCliente, int quantidade, int addORremove) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexoes.conectar();
            String sql = "UPDATE table_orcamento"
                    + " SET "
                    + " quantidade = ?"
                    + " WHERE idProdutokey = ? AND idClientekey = ?";
            
            ps = conn.prepareStatement(sql);
            if (addORremove == 1) {
                ps.setInt(1, quantidade + 1);
            } else {
                ps.setInt(1, quantidade - 1);
            }
            ps.setInt(2, idProduto);
            ps.setInt(3, idCliente);
              
            int linhasAfetadas = ps.executeUpdate();
            System.out.println(linhasAfetadas);
        } catch(SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConnection();
        }
    }
    
}
