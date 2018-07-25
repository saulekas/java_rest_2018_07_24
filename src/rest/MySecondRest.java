package rest;

import rest.Utils.DbUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class MySecondRest {
    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<student> getStudents(){
      List<student> students = new ArrayList<>();
        DbUtils dbUtils = new DbUtils();
        Connection connection = dbUtils.createConnection();

        if (connection !=null);
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()){
                students.add(new student(resultSet.getInt("STUDENTS_ID"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return students;
    }
    @GET
    @Path("/{id}/student")
    @Produces(MediaType.APPLICATION_JSON)
    public student getStudent(@PathParam("id") int id){
        student student = null;
        DbUtils dbUtils = new DbUtils();
        Connection connection = dbUtils.createConnection();
        if (connection != null);
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from students where STUDENTS_ID="+id);
            resultSet.next();
            student= new student(resultSet.getInt("STUDENTs_ID"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  student;

    }


}
