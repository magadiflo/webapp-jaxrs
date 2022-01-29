package org.magadiflo.webapp.jaxws.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.magadiflo.webapp.jaxws.models.Curso;
import org.magadiflo.webapp.jaxws.services.CursoService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
@Produces(MediaType.APPLICATION_XML)
public class CursoRestController {

    @Inject
    private CursoService service;

    /*Primera forma*/
    @GET
    public List<Curso> listar() {
        return this.service.listar();
    }

    /*Segunda forma*/
    /*
    @GET
    public Response listar() {
        return Response.ok(this.service.listar()).build();
    }
    */

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        Optional<Curso> optional = this.service.porId(id);
        if (optional.isPresent()) {
            return Response.ok(optional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }




}
