import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor

public class Cliente {

    private String nome;
    private String  cpf;

    @Override
    public String toString() {
        return "" + nome + '\'' +
                ", CPF='" + cpf + '\''
                ;
    }
}