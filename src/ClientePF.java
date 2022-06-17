public class ClientePF extends Cliente {
    private static final String TIPO_PESSOA = "pf";
    public static int total = 0;

    public ClientePF(String nome, String codigoCliente) {
        super(nome, codigoCliente);
        total++;
    }

    @Override
    public String getTipoPessoa() {
        return TIPO_PESSOA;
    }

    @Override
    public String toString() {
        return "ClientePF [nome=" + super.getNome() + ", codigoCliente=" + codigoCliente
                + "]";
    }
}
