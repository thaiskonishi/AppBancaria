import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        System.out.println("############## INICIO #############");
        System.out.println("############## BEM-VINDO AO BANCO #############");

        Banco banco1 = new Banco("Banco Lets Code");

        System.out.println("############## CADASTRO DE CLIENTE #############");

        banco1.cadastrarCliente("Ana", "1001", "pf");

        banco1.cadastrarCliente("Café Bom", "50001", "pj");

        System.out.println("############## ABERTURA DE CONTA #############");

        ClientePF cliente1 = new ClientePF("Elaine", "1004");
        banco1.abrirConta(200101, cliente1, Banco.TipoConta.CONTA_CORRENTE);
        banco1.abrirConta(400101, cliente1, Banco.TipoConta.CONTA_INVESTIMENTO);

        ClientePF cliente2 = new ClientePF("Fabio", "1005");
        banco1.abrirConta(300102, cliente2, Banco.TipoConta.CONTA_POUPANCA);
        banco1.abrirConta(400102, cliente2, Banco.TipoConta.CONTA_INVESTIMENTO);

        ClientePJ cliente3 = new ClientePJ("Tabacaria", "50004");
        banco1.abrirConta(200103, cliente3, Banco.TipoConta.CONTA_CORRENTE);
        banco1.abrirConta(400103, cliente3, Banco.TipoConta.CONTA_INVESTIMENTO);

        ClientePJ cliente4 = new ClientePJ("Cartomante", "50005");
        banco1.abrirConta(200104, cliente4, Banco.TipoConta.CONTA_CORRENTE);

        System.out.println("############## OPERAÇÕES BANCÁRIAS #############");

        banco1.getBuscaConta(200101).deposita(BigDecimal.valueOf(10000.00));
        System.out.println("saldo conta 200101: " + banco1.getBuscaConta(200101).getSaldo());

        banco1.getBuscaConta(200101).saca(BigDecimal.valueOf(100.00));
        System.out.println("saldo conta 200101: " + banco1.getBuscaConta(200101).getSaldo());

        banco1.getBuscaConta(200101).investir((BigDecimal.valueOf(100.00)), banco1.getBuscaConta(400101));
        System.out.println("saldo conta 400101: " + banco1.getBuscaConta(400101).getSaldo());

        System.out.println("saldo conta 200103: " + banco1.getBuscaConta(200103).getSaldo());
        System.out.println("saldo conta 400103: " + banco1.getBuscaConta(400103).getSaldo());
        banco1.getBuscaConta(200103).deposita(BigDecimal.valueOf(65000.00));
        banco1.getBuscaConta(200103).investir((BigDecimal.valueOf(50000.00)), banco1.getBuscaConta(400103));
        System.out.println("saldo conta 200103: " + banco1.getBuscaConta(200103).getSaldo());
        System.out.println("saldo conta 400103: " + banco1.getBuscaConta(400103).getSaldo());

        System.out.print(
                "\n####################### FIM #######################\n");

    }
}
