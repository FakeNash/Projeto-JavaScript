package br.com.henriquedegues.projeto.repository;
import br.com.henriquedegues.projeto.model.Genre;
import java.util.Optional;
import java.util.List;
import br.com.henriquedegues.projeto.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonagemRepository extends JpaRepository<Personagem,Integer> {

    public Optional<Personagem> findByName(String name);

    public List<Personagem> findByOrigin(String origin);

    public List<Personagem> findByAbout(String about);

    public List<Personagem> findByGenre(Genre genre);



    
}
