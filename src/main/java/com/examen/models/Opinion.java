package com.examen.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alberto Guzman Moreno
 * Entidad Opinion
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "usuario")
    private String user;
    @Column(name = "puntuacion")
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Movie movie;

    public Opinion(String description, String user, Integer rating, Movie movie) {
        this.description = description;
        this.user = user;
        this.rating = rating;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user='" + user + '\'' +
                ", rating=" + rating +
                ", movie=" + movie.getId() +
                '}';
    }
}