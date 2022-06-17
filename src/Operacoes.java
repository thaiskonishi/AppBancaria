import java.math.BigDecimal;

public interface Operacoes {
    public boolean saca(BigDecimal valor);

    public boolean deposita(BigDecimal valor);

    public boolean transfere(BigDecimal valor, Conta destino);

    public boolean investir(BigDecimal valor, Conta Destino);

}
