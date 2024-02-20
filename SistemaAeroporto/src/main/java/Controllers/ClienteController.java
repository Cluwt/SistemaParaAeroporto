package Controllers;

import Models.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;

    public ClienteController() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente autenticarCliente(String nomeUsuario, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getNomeUsuario().equals(nomeUsuario) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null;
    }

    // Outros métodos conforme necessário
}
