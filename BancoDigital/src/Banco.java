import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter

public class Banco {

    private final String nome = "Banco Digital";
    private List <Conta> contas = new ArrayList<Conta>();
    private static Banco banco;

    private Banco() {
    }

    public static Banco getInstance() {
        if(banco == null) {
            banco = new Banco();
        }
        return banco;
    }
    public void cadastrarConta(Conta novaConta){
        contas.add(novaConta);
    }

    public void imprimirContas(List<Conta> contas){
        for (Conta conta:contas) System.out.println(conta);
    }

    public Conta encontrarConta(String cpf){
        for (Conta conta:contas) {
            if(conta.getCliente().getCpf().equals(cpf)) return conta;
        }
        return null;
    }

}