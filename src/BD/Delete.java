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
    
}
