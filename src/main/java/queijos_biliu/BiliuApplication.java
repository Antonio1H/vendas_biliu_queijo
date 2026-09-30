package queijos_biliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import queijos_biliu.model.ItemPedido;
import queijos_biliu.model.Pedido;
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

		// criar produto
		Produto queijoCoalho = new Produto(
				"1",
				"queijo coalho",
				"queijo coalho tradicional",
				new BigDecimal("32.00"),
				10);

		Produto queijoNatural = new Produto(
				"2",
				"Queijo Coalho Natural",
				"Queijo coalho natural",
				new BigDecimal("36.00"),
				10);

		//criar pedido
		Pedido pedido = new Pedido();
		pedido.adicionarItem(queijoCoalho,3);
		pedido.adicionarItem(queijoNatural,2);

		//ver oq esta dentro do produto
		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getProduto().getNome() + "  quantidade: " + item.getQuantidade());
		}

		//remover produdo
		pedido.removerItem(1, "1");
		pedido.removerItem(1, "2");

		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getProduto().getNome() + "  quantidade: " + item.getQuantidade());
		}

		// teste do objeto Kaua -->

		//ver oq se os intens foram removidos
		//for (ItemPedido item : pedido.getItens()) {
			//System.out.println(item.getProduto().getNome() + "  quantidade: " + item.getQuantidade());
		//}
	}

}
