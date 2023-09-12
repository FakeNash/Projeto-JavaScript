package br.com.henriquedegues.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import br.com.henriquedegues.projeto.model.Personagem;
import br.com.henriquedegues.projeto.model.Genre;
import br.com.henriquedegues.projeto.repository.PersonagemRepository;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository repository;

    public Personagem insetOrUpdate(Personagem personagem){
        return repository.save(personagem);
    }

    public List<Personagem> findAll(){
        return repository.findAll();
    }

    public boolean delete(int id){
        var personagem = repository.findById(id);

        if(personagem.isPresent()){
           repository.deleteById(id);
           personagem = repository.findById(id);
           return personagem.isEmpty();
        }
        return false;



    }

    public Personagem findByName(String name){
        var personagem = repository.findByName(name);

        if (personagem.isPresent()){
            return personagem.get();
        }
        return new Personagem();
    }

    

    public List<Personagem> findByOrigin(String origin) {
        return repository.findByOrigin(origin);
    }

    public List<Personagem> findByAbout(String about) {
        return repository.findByAbout(about);
    
}

    public List<Personagem> findByGenre(Genre genre) {
        return repository.findByGenre(genre);
}

    

    public Optional<Personagem> findById(int id){
        return repository.findById(id);
    }


}