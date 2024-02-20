package Controllers;

import Models.Voo;
import java.util.ArrayList;
import java.util.List;

public class VooController {
    private List<Voo> voos;

    public VooController() {
        this.voos = new ArrayList<>();
    }

    public void cadastrarVoo(Voo voo) {
        voos.add(voo);
    }

    public List<Voo> listarVoos() {
        return voos;
    }

    public Voo buscarVooPorNumero(String numeroVoo) {
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equals(numeroVoo)) {
                return voo;
            }
        }
        return null;
    }

    // Outros métodos conforme necessário
}
