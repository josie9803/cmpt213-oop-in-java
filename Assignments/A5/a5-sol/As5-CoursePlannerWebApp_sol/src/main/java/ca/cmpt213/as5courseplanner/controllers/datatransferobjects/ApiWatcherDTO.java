package ca.cmpt213.as5courseplanner.controllers.datatransferobjects;
import java.util.List;

public class ApiWatcherDTO {
    public long id;
    public ApiDepartmentDTO department;
    public ApiCourseDTO course;
    public List<String> events;

}
