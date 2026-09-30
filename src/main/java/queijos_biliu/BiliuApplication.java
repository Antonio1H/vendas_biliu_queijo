package queijos_biliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import queijos_biliu.model.Produto;

import java.math.BigDecimal;

@SpringBootApplication
public class BiliuApplication {
// private String id;
//    private String nome;
//    private String descricao;
//    private BigDecimal valor;
//    private int quantidade;

	public static void main(String[] args) {
		SpringApplication.run(BiliuApplication.class, args);

		// testar objeto produto
		Produto queijoCoalho = new Produto("QJ1","queijo coalho gelado", "queijo coalho tradicional",
				new BigDecimal("32.00"),10);

		System.out.println("produto: " + queijoCoalho.getNome() + " Descrição: " + queijoCoalho.getDescricao());

		// teste do objeto Kaua -->

	}

}
