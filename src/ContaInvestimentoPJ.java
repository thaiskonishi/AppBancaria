import java.math.BigDecimal;

public class ContaInvestimentoPJ extends Conta {
    private static final String TIPO_CONTA = "pj";

    public ContaInvestimentoPJ(int codigoConta, Cliente titular, BigDecimal saldo) {
        super(codigoConta, titular, saldo);
        System.out.println("A conta investimento PJ foi criada");
    }

    public String getTipoConta() {
        return ContaInvestimentoPJ.TIPO_CONTA;
    }

    @Override
    public boolean investir(BigDecimal valor, Conta destino) {
        BigDecimal taxa = new BigDecimal("1.02");
        destino.deposita(valor.multiply(taxa));
        return true;
    }
}
