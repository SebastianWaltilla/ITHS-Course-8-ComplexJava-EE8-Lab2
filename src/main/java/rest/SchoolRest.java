package rest;

import entity.Student;
import entity.Subject;
import exceptions.StudentNotFoundException;
import service.SchoolService;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;

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
    StudentService studentService;
    @Inject
    SubjectService subjectService;
    @Inject
    TeacherService teacherService;

    @Inject
    SchoolService schoolService;





    @Path("getStudentAndHisSubjectByFirstName/{firstName}")
    @GET
    public Response getPlayerById(@PathParam("firstName") String name){
        List<Student> player = schoolService.getStudentAndHisSubjectByFirstName(name);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new StudentNotFoundException("Player with ID " + name + " not found.");
        }
    }




}
