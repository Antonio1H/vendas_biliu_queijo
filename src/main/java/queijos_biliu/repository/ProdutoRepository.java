package queijos_biliu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import queijos_biliu.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}