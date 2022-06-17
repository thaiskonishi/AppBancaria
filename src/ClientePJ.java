public class ClientePJ extends Cliente {
    private static final String TIPO_PESSOA = "pj";
    public static int total = 0;

    public ClientePJ(String nome, String codigoCliente) {
        super(nome, codigoCliente);
        total++;
    }

    @Override
    public String getTipoPessoa() {
        return TIPO_PESSOA;
    }

    @Override
    public String toString() {
        return "ClientePJ [nome=" + super.getNome() + ", codigoCliente=" + codigoCliente
                + "]";
    }
}
