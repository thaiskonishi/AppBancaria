// import java.math.BigDecimal;

public abstract class Cliente {

    protected String nome;
    protected String codigoCliente;

    public Cliente(String nome, String codigoCliente) {
        this.nome = nome;
        this.codigoCliente = codigoCliente;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public boolean setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
        return true;
    }

    public abstract String getTipoPessoa();

}
