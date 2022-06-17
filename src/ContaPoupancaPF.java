import java.math.BigDecimal;

public class ContaPoupancaPF extends Conta {

    public ContaPoupancaPF(int codigoConta, Cliente titular, BigDecimal saldo) {
        super(codigoConta, titular, saldo);
        System.out.println("A conta poupança foi criada ");

    }
}
