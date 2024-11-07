package com.examen.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pelicula")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Opinion> opinions = new ArrayList<>();

    public Movie(String title) {
        this.title = title;
    }

    public void addOpinion(Opinion opinion) {
        opinion.setMovie(this);
        opinions.add(opinion);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title=" + title +
                ", opinions=" + opinions +
                '}';
    }
}