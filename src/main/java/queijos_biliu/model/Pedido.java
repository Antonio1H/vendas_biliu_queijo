package queijos_biliu.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(Produto produto, int quantidade){
        itens.add(new ItemPedido(produto,quantidade));
    }

    public void removerItem(int quantidade, String id) {

        // Percorre a lista usando o índice de cada ItemPedido
        for (int i = 0; i < itens.size(); i++) {

            // Pega o ItemPedido que está na posição atual da lista
            ItemPedido item = itens.get(i);

            // Verifica se o produto desse item possui o ID procurado
            if (item.getProduto().getId().equals(id)) {

                // Diminui da quantidade atual a quantidade que queremos remover
                item.setQuantidade(item.getQuantidade() - quantidade);

                // Se a quantidade chegar a 0, não precisamos mais
                // manter esse ItemPedido dentro da lista
                if (item.getQuantidade() == 0) {

                    // Remove o item usando seu índice na lista
                    itens.remove(i);
                }
            }
        }
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }


}
