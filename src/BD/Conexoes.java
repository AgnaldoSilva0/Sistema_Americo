/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Conexoes {

    private static Connection conn;

    public static Connection conectar() {
        try {
            String url = "jdbc:sqlite:C:/BDs/dds/banco_dados.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.getMessage();
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void criarTabelaProduto() {
        Connection conn = null;
        Statement st = null;

        try {
            conn = Conexoes.conectar();

            String sql = "ALTER TABLE table_orcamento ADD COLUMN quantidade integer";

            //String sql = "CREATE TABLE IF NOT EXISTS table_orcamento"
            //+ "(idOrcamento integer PRIMARY KEY,"
            //+ "data text,"
            //+ "idClientekey integer,"
            //+ "idProdutokey integer,"
            //+ "FOREIGN KEY (idClientekey) REFERENCES table_cliente (idCliente),"
            //+ "FOREIGN KEY (idProdutokey) REFERENCES banco_produto (idProduto)"
            //  + ")";
            st = conn.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(st);
            Conexoes.closeConnection();
        }
    }

}
