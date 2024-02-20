package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagamentoView extends JFrame {

    public PagamentoView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pagamento");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Define o espaçamento entre os componentes

        JLabel lblTipoPagamento = new JLabel("Tipo de Pagamento:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(lblTipoPagamento, constraints);

        JComboBox<String> cmbTipoPagamento = new JComboBox<>(new String[]{"Somente Ida", "Ida e Volta"});
        constraints.gridx = 1;
        panel.add(cmbTipoPagamento, constraints);

        JLabel lblTaxaTuristica = new JLabel("Taxa Turística:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lblTaxaTuristica, constraints);

        JTextField txtTaxaTuristica = new JTextField(15);
        constraints.gridx = 1;
        panel.add(txtTaxaTuristica, constraints);

        JButton btnPagar = new JButton("Pagar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2; // Define a largura do botão para ocupar duas colunas
        constraints.anchor = GridBagConstraints.CENTER; // Alinha o botão ao centro
        panel.add(btnPagar, constraints);

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para processar o pagamento
                JOptionPane.showMessageDialog(null, "Pagamento processado com sucesso!");
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PagamentoView().setVisible(true);
            }
        });
    }
}
