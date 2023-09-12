package br.com.henriquedegues.projeto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.henriquedegues.projeto.model.dto.PersonagemDTO;
import br.com.henriquedegues.projeto.service.PersonagemService;
import br.com.henriquedegues.projeto.util.PersonagemMapping;

@Controller

@RequestMapping("/personagens")
public class PersonagemController {
    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public String formInsert(Model model){
        PersonagemDTO personagem = new PersonagemDTO();
        model.addAttribute("objPersonagem", personagem);
       return "pages/register";
    }

    @PostMapping
    public String insert(@ModelAttribute PersonagemDTO personagemDTO) {
        var personagem = personagemService.insetOrUpdate(
            PersonagemMapping.toPersonagem(personagemDTO));
            if(personagem.getId() != 0) {
                return "pages/success";
            } else {
                return "pages/error";
            }
    }
    
}
