package Controllers;

import Models.Administrador;
import java.util.ArrayList;
import java.util.List;

public class AdministradorController {
    private List<Administrador> administradores;

    public AdministradorController() {
        this.administradores = new ArrayList<>();
    }

    public void cadastrarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public Administrador autenticarAdministrador(String nomeUsuario, String senha) {
        for (Administrador admin : administradores) {
            if (admin.getNomeUsuario().equals(nomeUsuario) && admin.getSenha().equals(senha)) {
                return admin;
            }
        }
        return null;
    }

    // Outros métodos conforme necessário
}
