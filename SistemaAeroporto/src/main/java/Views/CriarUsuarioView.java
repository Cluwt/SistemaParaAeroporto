package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriarUsuarioView extends JFrame {

    public CriarUsuarioView() {
        initComponents();
    }
    
       private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sistemaparaaeroporto";
        String usuario = "root";
        String senha = "";
        
        return DriverManager.getConnection(url, usuario, senha);
    }

    private void initComponents() {
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criar Usuário");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Define o espaçamento entre os componentes

        JLabel lblNomeUsuario = new JLabel("Nome de Usuário:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblNomeUsuario, constraints);

        JTextField txtNomeUsuario = new JTextField(15);
        constraints.gridx = 1;
        panel.add(txtNomeUsuario, constraints);

        JLabel lblSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lblSenha, constraints);

        JPasswordField txtSenha = new JPasswordField(15);
        constraints.gridx = 1;
        panel.add(txtSenha, constraints);

        JButton btnCriarUsuario = new JButton("Criar Usuário");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2; // Define a largura do botão para ocupar duas colunas
        constraints.anchor = GridBagConstraints.CENTER; // Alinha o botão ao centro
        panel.add(btnCriarUsuario, constraints);

        btnCriarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeUsuario = txtNomeUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                // Conectar ao banco de dados e salvar o novo usuário
                try {
                    Connection connection = getConnection(); // Método para obter conexão com o banco de dados
                    String sql = "INSERT INTO clientes (nomeUsuario, senha) VALUES (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, nomeUsuario);
                    statement.setString(2, senha);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
                        // Limpar os campos após a criação do usuário
                        txtNomeUsuario.setText("");
                        txtSenha.setText("");
                        dispose();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao criar usuário: " + ex.getMessage());
                }
            }
        });

        add(panel);
      
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CriarUsuarioView().setVisible(true);
            }
        });
    }
}
