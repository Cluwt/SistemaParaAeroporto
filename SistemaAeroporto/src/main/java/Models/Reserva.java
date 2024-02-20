package Models;

public class Reserva {
    private Usuario usuario;
    private Voo voo;
    private int quantidadeAssentos;

    public Reserva(Usuario usuario, Voo voo, int quantidadeAssentos) {
        this.usuario = usuario;
        this.voo = voo;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario +
                ", voo=" + voo +
                ", quantidadeAssentos=" + quantidadeAssentos +
                '}';
    }
}
