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
    private final List<ContaInvestimentoPJ> contasInvestimentoPJ = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    enum TipoConta {
        CONTA_CORRENTE, CONTA_POUPANCA, CONTA_INVESTIMENTO
    }

    public List<ClientePF> getPessoaFisica() {
        return pessoaFisica;
    }

    public List<ClientePJ> getPessoaJuridica() {
        return pessoaJuridica;
    }

    public List<ContaCorrentePF> getContasCorrentePF() {
        return contasCorrentePF;
    }

    public List<ContaPoupancaPF> getContasPoupancaPF() {
        return contasPoupancaPF;
    }

    public List<ContaInvestimentoPF> getContasInvestimentoPF() {
        return contasInvestimentoPF;
    }

    public List<ContaCorrentePJ> getContasCorrentePJ() {
        return contasCorrentePJ;
    }

    public List<ContaInvestimentoPJ> getContaInvestimentoPJ() {
        return contasInvestimentoPJ;
    }

    public Cliente getBuscaCliente(String codigoCliente) {
        for (ClientePF cliente : pessoaFisica) {
            if (cliente.getCodigoCliente().contains(codigoCliente)) {
                return cliente;
            }
        }
        for (ClientePJ cliente : pessoaJuridica) {
            if (cliente.getCodigoCliente().contains(codigoCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public Conta getBuscaConta(int codigoConta) {
        for (ContaCorrentePF conta : contasCorrentePF) {
            if (conta.getCodigoConta() == codigoConta) {
                return conta;
            }
        }
        for (ContaCorrentePJ conta : contasCorrentePJ) {
            if (conta.getCodigoConta() == codigoConta) {
                return conta;
            }
        }
        for (ContaInvestimentoPF conta : contasInvestimentoPF) {
            if (conta.getCodigoConta() == codigoConta) {
                return conta;
            }
        }
        for (ContaInvestimentoPJ conta : contasInvestimentoPJ) {
            if (conta.getCodigoConta() == codigoConta) {
                return conta;
            }
        }
        for (ContaPoupancaPF conta : contasPoupancaPF) {
            if (conta.getCodigoConta() == codigoConta) {
                return conta;
            }
        }

        return null;

    }

    public void cadastrarCliente(String nomeCliente, String codigoCliente, String tipoPessoa) {
        if (tipoPessoa == "pf") {
            pessoaFisica.add(new ClientePF(nome, codigoCliente));
            System.out.println("cliente cadastrado");

        } else if (tipoPessoa == "pj") {
            pessoaJuridica.add(new ClientePJ(nome, codigoCliente));
            System.out.println("cliente cadastrado");

        } else {
            System.out.println("tipo de pessoa válido!");

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
                        contasInvestimentoPJ
                                .add(new ContaInvestimentoPJ(codigoConta, (ClientePJ) cliente, BigDecimal.ZERO));
                        break;
                }

            }

        }
    }
}
