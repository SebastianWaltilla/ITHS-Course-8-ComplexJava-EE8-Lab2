package rest;

import entity.Student;
import exceptions.NotFoundException;
import service.SchoolService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolRest {

    @Inject
    SchoolService schoolService;

    @Path("getStudentAndHisSubjectByFirstName/{firstName}")
    @GET
    public Response getPlayerById(@PathParam("firstName") String name){
        List<Student> player = schoolService.getStudentAndHisSubjectByFirstName(name);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new NotFoundException("Student with name: " + name + " not found.");
        }
    }

    @Path("getStudentsBySubjectAndTeacher/{subject}/{teacherName}")
    @GET
    public Response getPlayerById(@PathParam("subject") String subject,@PathParam("teacherName") String teacherName){
        List<Student> player = schoolService.getSubjectAndCourseByteacher(subject,teacherName);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new NotFoundException("Teacher has no subject with name: " + subject + " or Teacher with name: " + teacherName + "not found.");
        }
    }
}
