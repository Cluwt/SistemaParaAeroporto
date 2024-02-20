package Views;

import DAO.VooDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroVooView extends JFrame {

    public CadastroVooView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Voo");
        setPreferredSize(new Dimension(400, 300));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Define o espaçamento entre os componentes

        JLabel lblNumeroVoo = new JLabel("Número do Voo:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblNumeroVoo, constraints);

        JTextField txtNumeroVoo = new JTextField(15);
        constraints.gridx = 1;
        panel.add(txtNumeroVoo, constraints);

        JLabel lblOrigem = new JLabel("Origem:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lblOrigem, constraints);

        JTextField txtOrigem = new JTextField(15);
        constraints.gridx = 1;
        panel.add(txtOrigem, constraints);

        JLabel lblDestino = new JLabel("Destino:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(lblDestino, constraints);

        JTextField txtDestino = new JTextField(15);
        constraints.gridx = 1;
        panel.add(txtDestino, constraints);

        JLabel lblAssentos = new JLabel("Assentos Disponíveis:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(lblAssentos, constraints);

        JTextField txtAssentos = new JTextField(15);
        constraints.gridx = 1;
        panel.add(txtAssentos, constraints);

        JButton btnCadastrar = new JButton("Cadastrar");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2; // Define a largura do botão para ocupar duas colunas
        constraints.anchor = GridBagConstraints.CENTER; // Alinha o botão ao centro
        panel.add(btnCadastrar, constraints);    

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados inseridos pelo usuário
                String numeroVoo = txtNumeroVoo.getText();
                String origem = txtOrigem.getText();
                String destino = txtDestino.getText();
                int assentosDisponiveis = Integer.parseInt(txtAssentos.getText());

                // Chamar o método de cadastro na classe DAO
                boolean cadastrado = VooDAO.cadastrarVoo(numeroVoo, origem, destino, assentosDisponiveis);
                
                if (cadastrado) {
                    JOptionPane.showMessageDialog(null, "Voo cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar voo. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CadastroVooView().setVisible(true);
        });
    }
}
