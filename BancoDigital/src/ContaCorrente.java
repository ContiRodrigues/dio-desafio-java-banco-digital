public class ContaCorrente extends Conta {

    private static int SEQUENCIAL = 1;

    public ContaCorrente(Cliente cliente) {
        super.agencia = AGENCIA_PADRAO;
        int prefixoContaCorrente = 100;
        super.conta = prefixoContaCorrente + SEQUENCIAL++;
        super.cliente = cliente;

    }

}