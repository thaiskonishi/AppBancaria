import java.math.BigDecimal;

public class ContaCorrentePJ extends Conta {
    private static final String TIPO_CONTA = "pj";
    public static int total = 0;

    public ContaCorrentePJ(int codigoConta, Cliente titular, BigDecimal saldo) {
        super(codigoConta, titular, saldo);
        System.out.println("A conta corrente PJ foi criada");
        total++;
    }

    public String getTipoConta() {
        return ContaCorrentePJ.TIPO_CONTA;
    }

    @Override
    public boolean saca(BigDecimal valor) {
        BigDecimal taxaSaque = new BigDecimal("1.005");
        if (super.getSaldo().compareTo(valor) >= 0) {
            super.setSaldo(super.getSaldo().subtract(valor.multiply(taxaSaque)));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean transfere(BigDecimal valor, Conta destino) {
        BigDecimal taxaTransfere = new BigDecimal("1.005");
        if (this.getSaldo().compareTo(valor) >= 0) {
            this.setSaldo(this.getSaldo().subtract(valor.multiply(taxaTransfere)));
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean investir(BigDecimal valor, Conta destino) {
        BigDecimal taxa = new BigDecimal("1.02");
        destino.deposita(valor.multiply(taxa));
        return true;
    }
}
