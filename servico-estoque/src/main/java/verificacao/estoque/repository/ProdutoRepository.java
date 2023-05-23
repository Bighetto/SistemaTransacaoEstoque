package verificacao.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import verificacao.estoque.dto.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}
