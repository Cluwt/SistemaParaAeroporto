package Models;

public class Cliente {
    private String nomeUsuario;
    private String senha;

    public Cliente(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
