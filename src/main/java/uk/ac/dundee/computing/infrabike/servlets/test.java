package uk.ac.dundee.computing.infrabike.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


import org.glassfish.jersey.server.mvc.Viewable;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("test")
@Stateless
public class test {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable testModel(@Context HttpServletRequest request) {
        //return "Got it!";
        request.setAttribute("obj", new String("IT Works"));
        System.out.println("/test called");
        return new Viewable("/works", null);
    }
}