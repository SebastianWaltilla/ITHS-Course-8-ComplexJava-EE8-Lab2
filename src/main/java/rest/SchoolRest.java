package rest;

import entity.Student;
import entity.Subject;
import exceptions.NotFoundException;
import service.SchoolService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolRest {

    @Inject
    SchoolService schoolService;

    @Path("getAllStudentBySubject/{subject}")
    @GET
    public Response getPlayerById(@PathParam("subject") String name){
        List<Subject> player = schoolService.getAllStudentBySubject(name);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new NotFoundException("Student with name: " + name + " not found.");
        }
    }


    @Path("getStudentsBySubjectAndTeacher/{subject}/{teacherName}")
    @GET
    public Response getPlayerById(@PathParam("subject") String subject,@PathParam("teacherName") String teacherName){
        Set<Student> player = schoolService.getStudentsBySubjectAndTeacher(subject, teacherName);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new NotFoundException("Teacher has no subject with name: " + subject + " or Teacher with name: " + teacherName + "not found.");
        }
    }
}
