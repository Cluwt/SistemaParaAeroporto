package Controllers;

import Models.Pagamento;
import java.util.ArrayList;
import java.util.List;

public class PagamentoController {
    private List<Pagamento> pagamentos;

    public PagamentoController() {
        this.pagamentos = new ArrayList<>();
    }

    public void registrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    // Outros métodos conforme necessário
}
