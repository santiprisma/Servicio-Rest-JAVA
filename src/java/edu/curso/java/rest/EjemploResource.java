/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curso.java.rest;

import javax.ws.rs.core.*;
import javax.ws.rs.*;
import java.util.*;


/**
 * REST Web Service
 *
 * @author educacionit
 */
@Path("ejemplo")
public class EjemploResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EjemploResource
     */
    public EjemploResource() {
    }

    /**
     * Retrieves representation of an instance of edu.curso.java.rest.EjemploResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EjemploResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @GET
    @Path("/path/{anio}/{mes}/{dia}")
    public Response ejemploPath(
            @PathParam("anio") int anio,
            @PathParam("mes") int mes,
            @PathParam("dia") int dia) {
        
        String date = anio + "/" + mes + "/" + dia;
        
        return Response.status(200).entity("Resultado: " + date).build();
    }
    
    @GET
    @Path("/query")
    public Response getUsers(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {
        
        return Response
                .status(200)
                .entity("Ejemplo from:  " + from + ", to: " + to + ", orderBy: " + orderBy.toString())
                .build();
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/personas")
    public Response recuperarPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Juan", "Perez"));
        personas.add(new Persona(2, "Maria", "Lopez"));
        personas.add(new Persona(3, "Ariel", "Gonzalez"));
        
        GenericEntity ge = new GenericEntity<List<Persona>>(personas) {};
        return Response.status(200).entity(ge).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/personas")
    public Response altaPersona(Persona persona) {
        return Response.status(200).entity(persona).build();
    }
    
}
