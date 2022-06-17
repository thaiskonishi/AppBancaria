import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Crie uma aplicação que simule uma app bancária. Os clientes podem ser pessoa física ou jurídica, sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência. Além do produto conta-corrente, os clientes PF podem abrir uma conta-poupança e conta-investimento. Clientes PJ não abrem poupança, mas seus rendimentos em conta-investimento rendem 2% a mais.

// Crie as funcionalidades: abrir conta, sacar, depositar, transferência, investir, consultar saldo.

// Use a classe "Aplicacao" para criar seu método "main" e demonstrar o funcionamento do seu código.

public class Banco {

    private String nome;
    private final List<ClientePF> pessoaFisica = new ArrayList<>();
    private final List<ClientePJ> pessoaJuridica = new ArrayList<>();
    private final List<ContaCorrentePF> contasCorrentePF = new ArrayList<>();
    private final List<ContaPoupancaPF> contasPoupancaPF = new ArrayList<>();
    private final List<ContaInvestimentoPF> contasInvestimentoPF = new ArrayList<>();
    private final List<ContaCorrentePJ> contasCorrentePJ = new ArrayList<>();
    private final List<ContaInvestimentoPJ> contaInvestimentoPJ = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    enum TipoConta {
        CONTA_CORRENTE, CONTA_POUPANCA, CONTA_INVESTIMENTO
    }

    public Banco() {
        this.pessoaFisica.add(new ClientePF("Ana", "111.111.111-11"));
        this.pessoaFisica.add(new ClientePF("Pedro", "222.222.222-22"));
        this.pessoaFisica.add(new ClientePF("Caio", "333.333.333-33"));
        this.pessoaFisica.add(new ClientePF("Denis", "444.444.444-44"));

        this.pessoaJuridica.add(new ClientePJ("America", "1111"));
        this.pessoaJuridica.add(new ClientePJ("Barbearia", "2222"));

        this.contasCorrentePF.add(new ContaCorrentePF(101, pessoaFisica.get(0), new BigDecimal(10000)));
        this.contasCorrentePF.add(new ContaCorrentePF(102, pessoaFisica.get(1), new BigDecimal(5000)));
        this.contasCorrentePJ.add(new ContaCorrentePJ(1001, pessoaJuridica.get(0), new BigDecimal(100000)));
        this.contasCorrentePJ.add(new ContaCorrentePJ(1001, pessoaJuridica.get(0), new BigDecimal(100000)));

    }

    public int cadastrarCliente(String nomeCliente, String codigoCliente, String tipoPessoa) {
        System.out.println("Em tipo de pessoa, digite pf para pessoa física e pj para pessoa jurídica.");
        if (tipoPessoa == "pf") {
            pessoaFisica.add(new ClientePF(nome, codigoCliente));
            int indice = ClientePF.total - 1;
            return indice;

        } else if (tipoPessoa == "pj") {
            pessoaJuridica.add(new ClientePJ(nome, codigoCliente));
            int indice = ClientePJ.total - 1;
            return indice;

        } else {
            System.out.println("Digite um tipo de pessoa válido! ( pf ou pj )");
            return -1;
        }

    }

    public void abrirConta(int codigoConta, Cliente cliente, TipoConta tipoConta) {
        if (cliente instanceof ClientePF) {
            pessoaFisica.add((ClientePF) cliente);
            switch (tipoConta) {
                case CONTA_CORRENTE:
                    contasCorrentePF.add(new ContaCorrentePF(codigoConta, (ClientePF) cliente, BigDecimal.ZERO));
                    break;
                case CONTA_POUPANCA:
                    contasPoupancaPF.add(new ContaPoupancaPF(codigoConta, (ClientePF) cliente, BigDecimal.ZERO));
                    break;
                case CONTA_INVESTIMENTO:
                    contasInvestimentoPF
                            .add(new ContaInvestimentoPF(codigoConta, (ClientePF) cliente, BigDecimal.ZERO));
                    break;

            }
        } else {
            if (cliente instanceof ClientePJ) {
                pessoaJuridica.add((ClientePJ) cliente);
                switch (tipoConta) {
                    case CONTA_CORRENTE:
                        contasCorrentePJ.add(new ContaCorrentePJ(codigoConta, (ClientePJ) cliente, BigDecimal.ZERO));
                        break;
                    case CONTA_POUPANCA:
                        System.out.println("Não é possível abrir uma conta poupança para uma pessoa jurídica.");
                        break;
                    case CONTA_INVESTIMENTO:
                        contaInvestimentoPJ
                                .add(new ContaInvestimentoPJ(codigoConta, (ClientePJ) cliente, BigDecimal.ZERO));
                        break;
                }

            }

        }
    }
}
