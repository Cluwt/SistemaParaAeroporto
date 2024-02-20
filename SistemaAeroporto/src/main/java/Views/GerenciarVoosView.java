package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GerenciarVoosView extends JFrame {

    private JTable tblVoos;
    private JButton btnNovoVoo;

    public GerenciarVoosView() {
        initComponents();
        carregarDados();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Voos");
        setSize(640, 480);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        tblVoos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblVoos);
        panel.add(scrollPane);

        btnNovoVoo = new JButton("Novo Voo");
        panel.add(btnNovoVoo);

        btnNovoVoo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroVooView cadastroVooView = new CadastroVooView();
                cadastroVooView.setVisible(true);
            }
        });
    }

    private void carregarDados() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaparaaeroporto", "root", "");
            String sql = "SELECT * FROM voos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // Crie o modelo da tabela com as colunas
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Número");
            model.addColumn("Origem");
            model.addColumn("Destino");
            model.addColumn("Assentos Disponíveis");

            // Adicione os dados ao modelo da tabela
            while (rs.next()) {
                String numeroVoo = rs.getString("numeroVoo");
                String origem = rs.getString("origem");
                String destino = rs.getString("destino");
                int assentosDisponiveis = rs.getInt("assentosDisponiveis");
                model.addRow(new Object[]{numeroVoo, origem, destino, assentosDisponiveis});
            }
            
            // Defina o modelo da tabela com os dados carregados
            tblVoos.setModel(model);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GerenciarVoosView().setVisible(true);
            }
        });
    }
}
