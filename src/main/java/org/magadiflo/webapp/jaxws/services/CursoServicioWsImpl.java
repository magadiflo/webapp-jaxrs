package org.magadiflo.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.magadiflo.webapp.jaxws.models.Curso;
import org.magadiflo.webapp.jaxws.repositories.CursoRepository;

import java.util.List;

@Stateless
@WebService(endpointInterface = "org.magadiflo.webapp.jaxws.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {

    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return this.repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return this.repository.guardar(curso);
    }

}
