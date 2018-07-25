package rest;

import javax.validation.constraints.Max;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/myFirstRest")
public class MyFirstRestExample {

    @GET
    @Path("/sayHi")
    public String sayHi() {
        return "Labas";
    }

    @GET
    @Path("/hiNumber")
    public int myNumber() {
        return 10;
    }

    @GET
    @Path("sayHi/{name}")
    public String sayHiToUser(@PathParam("name") String userName) {
        return "Labas " + userName;
    }

    @GET
    @Path("/getStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public student getStudent() {
        student st = new student(10, "Andrius", "Baltrunas", "andrius@test.com");
        return st;

    }

    @GET
    @Path("/getStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<student> getStudents() {
        List<student> students = new ArrayList<>();
        students.add(new student(12, "Andrius", "Baltrunas", "abaltrunas@kcs.com"));
        students.add(new student(33, "Jonas", "Jonukas", "jonukas@kcs.com"));
        return students;
    }
    @POST
    @Path("/saveStudents")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public student save(student st){
        st.setId(11);
        st.setName(st.getName() + "!!!!");
st.setSurname(st.getSurname() + "!!!!");
st.setEmail(st.getEmail() + "!!!!");
return st ;
    }
}

