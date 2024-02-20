package Models;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    private List<Voo> voos;

    public Aeroporto() {
        this.voos = new ArrayList<>();
    }

    public void cadastrarVoo(Voo voo) {
        voos.add(voo);
    }

    public boolean verificarDisponibilidade(String numeroVoo, int quantidadeAssentos) {
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equals(numeroVoo) && voo.getAssentosDisponiveis() >= quantidadeAssentos) {
                return true;
            }
        }
        return false;
    }

    public void reservarAssentos(String numeroVoo, int quantidadeAssentos) {
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equals(numeroVoo)) {
                voo.setAssentosDisponiveis(voo.getAssentosDisponiveis() - quantidadeAssentos);
                return;
            }
        }
    }

    // Outros métodos conforme necessário
}
