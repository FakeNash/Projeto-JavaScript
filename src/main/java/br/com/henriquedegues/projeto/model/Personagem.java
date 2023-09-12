package br.com.henriquedegues.projeto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "personagens")
public class Personagem {

    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @Column(columnDefinition = "varchar(50) not null")
        private String name;
        @Column(columnDefinition = "varchar(70) not null")
        private String origin;
        @Column(nullable = false,length = 1)
        private Genre genre;
        @Column(columnDefinition = "text not null")
        private String about;
        
        public Personagem(){

        }

        public Personagem(int id, String name, String origin, Genre genre, String about) {
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

        public void setGenre(String origin) {
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
