import lombok.Getter;
import lombok.ToString;
import java.math.BigDecimal;

@Getter
@ToString

public abstract class Conta {

    protected static final int AGENCIA_PADRAO = 1;
    protected int agencia = 1;
    protected int conta;
    protected BigDecimal saldo = new BigDecimal(0);
    protected Cliente cliente;

    public void sacar(BigDecimal valorSaque) {
        this.saldo = saldo.subtract(valorSaque);
    }

    public void depositar(BigDecimal valorDeposito) {
        this.saldo = saldo.add(valorDeposito);
    }

    public void transferir(BigDecimal valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


    protected boolean imprimirInformacoes() {
        if (getConta() >= 200) {
            System.out.println("===== Extrato Conta Poupança =====");
        } else {
            System.out.println("===== Extrato Conta Corrente =====");
        }
        System.out.println(String.format("Titular: %s", this.cliente));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo: " + this.saldo.setScale(2).toPlainString()));
        return false;
    }

}