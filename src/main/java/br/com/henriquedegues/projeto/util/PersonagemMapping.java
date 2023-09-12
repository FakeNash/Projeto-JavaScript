package br.com.henriquedegues.projeto.util;
import br.com.henriquedegues.projeto.model.Personagem;
import br.com.henriquedegues.projeto.model.dto.PersonagemDTO;


public class PersonagemMapping {
    private PersonagemMapping(){
    }

    public static PersonagemDTO fromPersonagem(Personagem personagem){
        return new PersonagemDTO(personagem.getId(), personagem.getName(), personagem.getOrigin(),
        personagem.getGenre(), personagem.getAbout());
    
    }

    public static Personagem toPersonagem(PersonagemDTO dto){
        return new Personagem(dto.getId(), dto.getName(), dto.getOrigin(),dto.getGenre(), dto.getAbout());
    }
    
}
