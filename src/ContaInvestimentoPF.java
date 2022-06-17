import java.math.BigDecimal;

public class ContaInvestimentoPF extends Conta {
    private static final String TIPO_CONTA = "pf";

    public ContaInvestimentoPF(int codigoConta, Cliente titular, BigDecimal saldo) {
        super(codigoConta, titular, saldo);
        System.out.println("A conta investimento PJ foi criada");
    }

    public String getTipoConta() {
        return ContaInvestimentoPF.TIPO_CONTA;
    }

}
