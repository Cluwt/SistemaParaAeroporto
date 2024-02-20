package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utils.Conexao;

public class VooDAO {
    
    public static boolean cadastrarVoo(String numeroVoo, String origem, String destino, int assentosDisponiveis) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean sucesso = false;
        
        try {
            // Obtém conexão com o banco de dados
            connection = Conexao.getConnection();
            
            // Prepara a instrução SQL para inserir um novo voo
            String sql = "INSERT INTO voos (numeroVoo, origem, destino, assentosDisponiveis) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, numeroVoo);
            statement.setString(2, origem);
            statement.setString(3, destino);
            statement.setInt(4, assentosDisponiveis);
            
            // Executa a instrução SQL
            int linhasAfetadas = statement.executeUpdate();
            sucesso = linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha a conexão e o statement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return sucesso;
    }
}
