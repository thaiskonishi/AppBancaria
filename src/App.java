import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        System.out.println("############## INICIO #############");
        System.out.println("############## BEM-VINDO AO BANCO #############");

        Banco banco1 = new Banco("Banco Lets Code");

        // banco1.cadastrarCliente("Ana", "1001", "pf");
        // banco1.cadastrarCliente("Breno", "1002", "pf");
        // banco1.cadastrarCliente("Caio", "1003", "pf");

        // banco1.cadastrarCliente("Café Bom", "50001", "pj");
        // banco1.cadastrarCliente("Barbearia BSB", "50002", "pj");
        // banco1.cadastrarCliente("Bicicletaria Oficial", "50003", "pj");

        ClientePF cliente1 = new ClientePF("Elaine", "1004");
        banco1.abrirConta(200101, cliente1, Banco.TipoConta.CONTA_CORRENTE);

        ClientePF cliente2 = new ClientePF("Fabio", "1005");
        banco1.abrirConta(300102, cliente2, Banco.TipoConta.CONTA_POUPANCA);
        banco1.abrirConta(400103, cliente2, Banco.TipoConta.CONTA_INVESTIMENTO);

        ClientePJ cliente3 = new ClientePJ("Tabacaria", "50004");
        banco1.abrirConta(200101, cliente3, Banco.TipoConta.CONTA_CORRENTE);
        banco1.abrirConta(400101, cliente3, Banco.TipoConta.CONTA_INVESTIMENTO);

        ClientePJ cliente4 = new ClientePJ("Cartomante", "50005");
        banco1.abrirConta(200102, cliente4, Banco.TipoConta.CONTA_CORRENTE);

        System.out.print(
                "\n####################### Fim #######################\n");

    }
}
