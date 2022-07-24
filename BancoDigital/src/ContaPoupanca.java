public class ContaPoupanca extends Conta {
    private static int SEQUENCIAL = 1;
    private static int prefixoContaPoupanca = 200;

    public ContaPoupanca(Cliente cliente) {
        super.agencia = AGENCIA_PADRAO;
        super.conta = prefixoContaPoupanca + SEQUENCIAL++;
        super.cliente = cliente;
    }

}