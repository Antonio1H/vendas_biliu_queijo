
package queijos_biliu.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto == null || quantidade <= 0) {
            throw new IllegalArgumentException(
                    "Produto e quantidade devem ser válidos."
            );
        }

        ItemPedido item = new ItemPedido(produto, quantidade);
        item.setPedido(this);
        itens.add(item);
    }

    public void removerItem(int quantidade, String idProduto) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero."
            );
        }

        for (int i = 0; i < itens.size(); i++) {
            ItemPedido item = itens.get(i);

            if (item.getProduto().getId().equals(idProduto)) {

                if (quantidade > item.getQuantidade()) {
                    throw new IllegalArgumentException(
                            "A quantidade solicitada para remoção é maior "
                                    + "que a quantidade do item."
                    );
                }

                if (quantidade == item.getQuantidade()) {
                    itens.remove(i);
                    item.setPedido(null);
                } else {
                    item.setQuantidade(
                            item.getQuantidade() - quantidade
                    );
                }

                return;
            }
        }

        throw new IllegalArgumentException(
                "Produto não encontrado neste pedido."
        );
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            BigDecimal subtotal = item.getProduto()
                    .getValor()
                    .multiply(BigDecimal.valueOf(item.getQuantidade()));

            total = total.add(subtotal);
        }

        return total;
    }
}