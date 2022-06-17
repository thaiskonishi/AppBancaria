import java.math.BigDecimal;

public class ContaCorrentePF extends Conta {
    private static final String TIPO_CONTA = "pf";
    public static int total = 0;

    public ContaCorrentePF(int codigoConta, Cliente titular, BigDecimal saldo) {
        super(codigoConta, titular, saldo);
        System.out.println("A conta corrente PF foi criada ");
        total++;

    }

    public String getTipoConta() {
        return ContaCorrentePF.TIPO_CONTA;
    }

}
