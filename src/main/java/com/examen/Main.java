package com.examen;

import com.examen.models.Movie;
import com.examen.models.Opinion;
import com.examen.services.DataService;

import java.util.List;

/**
 * @author Alberto Guzman Moreno
 * Clase principal donde probamos todos los métodos desarrollados
 */
public class Main {
    public static void main(String[] args) {
        DataService dataService = new DataService(HibSession.getSessionFactory());
        // Historia usuario 1 guardar película
//        HibSession.getSessionFactory().inSession(session -> {
//            Movie movie = new Movie("Prueba1");
//            dataService.saveMovie(movie);
//        });
        // Historia usuario 2 recopilar opiniones por usuario
//        HibSession.getSessionFactory().inSession(session -> {
//            String userEmail = "user2@example.com";
//            List<Opinion> opinions = dataService.getOpinionsByUserEmail(userEmail);
//            opinions.forEach(System.out::println);
//        });
        // Historia de usuario 3 añadir opiniones a película existente
//        HibSession.getSessionFactory().inSession(session -> {
//            Movie movie = session.get(Movie.class, 6);
//            Opinion op1 = new Opinion("Opinion1", "alberto@gmail.com", 9, movie);
//            Opinion op2 = new Opinion("Opinion2", "alberto@gmail.com", 5, movie);
//
//            dataService.addOpinionsToMovie(movie, op1, op2);
//        });
        // Historia de usuario 4 recopilar títulos de películas por puntuación
//        HibSession.getSessionFactory().inSession(session -> {
//            List<String> movies = dataService.getMoviesWithLowRating(8);
//            movies.forEach(System.out::println);
//        });
    }
}
