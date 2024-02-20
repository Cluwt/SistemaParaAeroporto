package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Utils.Conexao;
import Views.AdministradorView;
import Views.ClienteView;
import Views.LoginView;

public class LoginController {
    
    public void login(String usuario, String senha) {
        System.out.println("Tentativa de login com usuário: " + usuario + " e senha: " + senha);

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Obter conexão com o banco de dados
            connection = Conexao.getConnection();

            // Consulta SQL para verificar as credenciais do administrador
            String sqlAdmin = "SELECT * FROM administradores WHERE nomeUsuario = ? AND senha = ?";
            statement = connection.prepareStatement(sqlAdmin);
            statement.setString(1, usuario);
            statement.setString(2, senha);

            // Executar a consulta para administradores
            resultSet = statement.executeQuery();

            // Se encontrou o administrador, redirecionar para a tela de administrador
            if (resultSet.next()) {
                System.out.println("Login bem-sucedido para o administrador: " + usuario);
                AdministradorView administradorView = new AdministradorView();
                administradorView.setVisible(true);

                // Fechar a tela de login
                LoginView loginView = new LoginView();
                loginView.dispose();
                return; // Encerrar a execução do método após o redirecionamento
            }

            // Consulta SQL para verificar as credenciais do cliente
            String sqlCliente = "SELECT * FROM clientes WHERE usuario = ? AND senha = ?";
            statement = connection.prepareStatement(sqlCliente);
            statement.setString(1, usuario);
            statement.setString(2, senha);

            // Executar a consulta para clientes
            resultSet = statement.executeQuery();

            // Se encontrou o cliente, redirecionar para a tela de cliente
            if (resultSet.next()) {
                System.out.println("Login bem-sucedido para o cliente: " + usuario);
                ClienteView clienteView = new ClienteView();
                clienteView.setVisible(true);

                // Fechar a tela de login
                LoginView loginView = new LoginView();
                loginView.dispose();
                return; // Encerrar a execução do método após o redirecionamento
            }

            // Se não encontrou nenhum usuário, exibir mensagem de erro
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.err.println("Erro ao verificar o login: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fechar conexões, declarações e resultados
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar Connection: " + e.getMessage());
                }
            }
        }
    }
}
