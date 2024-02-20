package Controllers;

import Models.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaController {
    private List<Reserva> reservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
    }

    public void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    // Outros métodos conforme necessário
}
