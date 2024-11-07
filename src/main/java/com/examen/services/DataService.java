package com.examen.services;

import com.examen.models.Movie;
import com.examen.models.Opinion;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alberto Guzman Moreno
 * Clase de utilidad para llamar a los métodos de las historias de usuario
 */
public class DataService {
    private final SessionFactory sessionFactory;

    public DataService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Historia de usuario 1 donde persistimos una película
     * @param movie entidad película
     */
    public void saveMovie(Movie movie) {
        try(var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(movie);
            session.getTransaction().commit();
        }
    }

    /**
     * Historia de usuario 2 donde recogemos todas las opiniones de un usuario
     * por su email
     * @param email email del usuario para filtrar opiniones
     * @return opinions -> Lista de opiniones del usuario
     */
    public List<Opinion> getOpinionsByUserEmail(String email) {
        List<Opinion> opinions;
        try(var session = sessionFactory.openSession()) {
            Query<Opinion> query = session.createQuery("from Opinion o where o.user = :email", Opinion.class);
            query.setParameter("email", email);
            opinions = new ArrayList<>(query.list());
        }
        return opinions;
    }

    /**
     * Modificar una película existente añadiéndole opiniones
     * @param movie entidad película
     * @param opinions -> Lista de opiniones del usuario
     */
    public void addOpinionsToMovie(Movie movie, Opinion ...opinions) {
        try(var session = sessionFactory.openSession()) {
            session.beginTransaction();
            for(Opinion o : opinions) {
                movie.addOpinion(o);
            }
            session.merge(movie);
            session.getTransaction().commit();
        }
    }

    /**
     * Recopilar listado de títulos de películas por una puntuación concreta
     * @param rating puntuación a filtrar.
     * @return Listado de títulos de movies
     */
    public List<String> getMoviesWithLowRating(Integer rating) {
        List<String> results;
        try(var session = sessionFactory.openSession()) {
            Query<String> query = session.createQuery("select distinct(m.title) from Movie m join m.opinions o where o.rating < :rating", String.class);
            query.setParameter("rating", rating);
            results = query.list();
        }
        return results;
    }
}
