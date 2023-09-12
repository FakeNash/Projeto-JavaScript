package br.com.henriquedegues.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

import br.com.henriquedegues.projeto.model.Genre;
import br.com.henriquedegues.projeto.model.dto.PersonagemDTO;
import br.com.henriquedegues.projeto.service.PersonagemService;
import br.com.henriquedegues.projeto.util.PersonagemMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/personagens")
public class APIPersonagemController {
    @Autowired
    private PersonagemService service;

    @PostMapping
    public ResponseEntity<PersonagemDTO> insert(@RequestBody 
    PersonagemDTO dto) {
        if (dto.getId() != 0)
             return new ResponseEntity<>(new PersonagemDTO(),
             HttpStatus.BAD_REQUEST);
             
        var personagem = service.insetOrUpdate(
            PersonagemMapping.toPersonagem(dto));

        if (personagem != null )
            return new ResponseEntity<>(
                PersonagemMapping.fromPersonagem(personagem),
                HttpStatus.CREATED);
                
        return new ResponseEntity<>(new PersonagemDTO(),
        HttpStatus.NOT_FOUND);
          


    }

    @PutMapping
    public ResponseEntity<PersonagemDTO> update(@RequestBody PersonagemDTO dto){
        if(dto.getId() <= 0)
        return new ResponseEntity<>(new PersonagemDTO(),
        HttpStatus.BAD_REQUEST);

        var personagem = service.findById(dto.getId());

        if(personagem.isPresent())
           return new ResponseEntity<>(
                PersonagemMapping.fromPersonagem(
                    service.insetOrUpdate(
                        PersonagemMapping.toPersonagem(dto)
                    )
               ),
                HttpStatus.OK);
            return new ResponseEntity<>(new PersonagemDTO(),
            HttpStatus.NOT_FOUND);

        
    }

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> findAll(){
        return new ResponseEntity<>(
            service.findAll().stream().map(
                (obj) -> PersonagemMapping.fromPersonagem
                (obj)).collect(Collectors.toList
                ()),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){

        var personagem = service.findById(id);
        if (personagem.isPresent()){
            var isSuccess = service.delete(id);
            
            if(isSuccess)
                return new ResponseEntity<>("Personagem Removido com sucesso",
                HttpStatus.OK);
            return new  ResponseEntity<>("Não foi possivel remover o personagem",
             HttpStatus.NOT_FOUND);   
        }
        return new ResponseEntity<>("Personagem não localizado",
        HttpStatus.NOT_FOUND);
    }

    @GetMapping("/origin/{origin}")
    public ResponseEntity<List<PersonagemDTO>> findByOrigin
    (@PathVariable String origin) {
        return new ResponseEntity<>(
            service.findByOrigin(origin).stream().map(
                (obj) -> PersonagemMapping.fromPersonagem(obj)
            ).collect(Collectors.toList()),
            HttpStatus.OK
        );
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<PersonagemDTO>> findByGenre
    (@PathVariable Genre genre) {
        return new ResponseEntity<>(
            service.findByGenre(genre).stream().map(
                (obj) -> PersonagemMapping.fromPersonagem(obj)
            ).collect(Collectors.toList()),
            HttpStatus.OK
        );
    }

    }