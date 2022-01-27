package org.magadiflo.webapp.jaxws.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.magadiflo.webapp.jaxws.models.Curso;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return this.em.createQuery("SELECT c FROM Curso AS c", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        this.em.persist(curso);
        return curso;
    }

}
