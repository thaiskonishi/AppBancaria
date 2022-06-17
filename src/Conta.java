import java.math.BigDecimal;

public abstract class Conta implements Operacoes {
    protected int codigoConta;
    protected BigDecimal saldo = BigDecimal.ZERO;
    protected Cliente titular;

    public Conta(int codigoConta, Cliente titular, BigDecimal saldo) {

        this.codigoConta = codigoConta;
        this.titular = titular;
        this.saldo = saldo;

        System.out.println("Está sendo criada a conta de código: " + this.codigoConta);

    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean saca(BigDecimal valor) {
        if (this.getSaldo().compareTo(valor) >= 0) {
            this.setSaldo(this.getSaldo().subtract(valor));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deposita(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            this.setSaldo(this.getSaldo().add(valor));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean transfere(BigDecimal valor, Conta destino) {
        if (this.getSaldo().compareTo(valor) >= 0) {
            this.setSaldo(this.getSaldo().subtract(valor));
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean investir(BigDecimal valor, Conta destino) {
        BigDecimal taxa = new BigDecimal("1.00");
        destino.deposita(valor.multiply(taxa));
        return true;
    }

}
