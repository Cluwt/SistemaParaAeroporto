package Models;

import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Voo {
    private String numeroVoo;
    private String origem;
    private String destino;
    private int assentosDisponiveis;

    // Construtor
    public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
    }

     public void cadastrarVoo() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Obtém a conexão com o banco de dados
            connection = Conexao.getConnection();

            // Define a query SQL para inserir um novo voo
            String sql = "INSERT INTO voos (numero_voo, origem, destino, assentos_disponiveis) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Define os parâmetros da query com os valores do voo atual
            statement.setString(1, numeroVoo);
            statement.setString(2, origem);
            statement.setString(3, destino);
            statement.setInt(4, assentosDisponiveis);

            // Executa a query
            statement.executeUpdate();
            System.out.println("Voo cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar voo: " + e.getMessage());
        } finally {
            // Fecha conexão e statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
    
    // Getters e Setters
    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }
}
