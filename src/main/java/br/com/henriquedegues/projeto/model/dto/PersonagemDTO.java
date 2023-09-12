package br.com.henriquedegues.projeto.model.dto;
import br.com.henriquedegues.projeto.model.Genre;


public class PersonagemDTO {



        private int id;
        private String name;
        private String origin;
        private Genre genre;
        private String about;
        
        public PersonagemDTO(){

        }

        public PersonagemDTO(int id, String name, String origin, Genre genre, String about) {
            this.id = id;
            this.name = name;
            this.origin = origin;
            this.genre = genre;
            this.about = about;
        }

        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public Genre getGenre() {
            return genre;
        }
    
        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        public String getAbout() {
            return about;
        }
    
        public void setAbout(String about) {
            this.about = about;
        }




    }