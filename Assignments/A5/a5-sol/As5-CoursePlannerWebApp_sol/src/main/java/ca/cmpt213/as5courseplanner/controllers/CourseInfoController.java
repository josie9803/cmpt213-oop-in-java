package ca.cmpt213.as5courseplanner.controllers;

import ca.cmpt213.as5courseplanner.controllers.datatransferobjects.*;
import ca.cmpt213.as5courseplanner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Course Offering controller class to generate the REST interface via Spring Boot.
 */
@RestController
@RequestMapping("/api")
public class CourseInfoController {
    @Autowired
    private Model model;


    // ------------------------
    //  About
    // ------------------------
    @GetMapping("/about")
    public ApiAboutDTO getAbout() {
        return new ApiAboutDTO("Brian's Awesome Sample App", "Brian Fraser");
    }

    // ------------------------
    //  Dump Model
    // ------------------------
    @GetMapping("/dump-model")
    public void dumpModel() {
        model.dumpModelToConsole();
    }

    // ------------------------
    //  Department
    // ------------------------
    @GetMapping("/departments")
    public Iterable<ApiDepartmentDTO> getDepartments() {
        return DTOBuilder.listFromJson(
                model.departments(),
                ApiDepartmentDTO.class
        );
    }

    // ------------------------
    //  Get Courses
    // ------------------------
    @GetMapping("/departments/{deptId}/courses")
    public Iterable<ApiCourseDTO> getDepartmentCourses(
            @PathVariable("deptId") long deptId
    ) {
        return DTOBuilder.listFromJson(
                model.getCoursesForDepartment(deptId),
                ApiCourseDTO.class
        );
    }


    // ------------------------
    //  Get Offerings
    // ------------------------
    @GetMapping("/departments/{deptId}/courses/{courseId}/offerings")
    public Iterable<ApiCourseOfferingDTO> getCourseOfferings(
            @PathVariable("deptId") long deptId,
            @PathVariable("courseId") long courseId
    ) {
        return DTOBuilder.listFromJson(model.getOfferingsForCourse(deptId, courseId), ApiCourseOfferingDTO.class);
    }

    // ------------------------
    //  Get Sections of offerings
    // ------------------------
    @GetMapping("/departments/{deptId}/courses/{courseId}/offerings/{offeringId}")
    public Iterable<ApiOfferingSectionDTO> getCourseOfferings(
            @PathVariable("deptId") long deptId,
            @PathVariable("courseId") long courseId,
            @PathVariable("offeringId") long offeringId

    ) {
        return DTOBuilder.listFromJson(model.getSectionsForCourseOffering(deptId, courseId, offeringId), ApiOfferingSectionDTO.class);
    }


    // ------------------------
    //  Add new section
    // ------------------------
    @PostMapping("/addoffering")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiOfferingSectionDTO addOffering(
            @RequestBody OfferingDataObject newOffering
    ) {
        return DTOBuilder.fromJson(model.addNewOffering(newOffering), ApiOfferingSectionDTO.class);
    }



    // ------------------------
    //  Get Graph Data
    // ------------------------
    @GetMapping("/stats/students-per-semester")
    public Iterable<ApiGraphDataPointDTO> getStudentsPerSemester(
            @RequestParam("deptId") long deptId
    ) {
        return DTOBuilder.listFromJson(
                model.getStudentsPerSemester(deptId),
                ApiGraphDataPointDTO.class
        );
    }

    // ----------------------------
    //  Get data for each semester
    // ----------------------------
    @GetMapping("/stats/data-for_each-semester")
    public Iterable<ApiGraphDataPointDTO> getDataForEachSemester(
            @RequestParam("deptId") long deptId
    ) {
        return DTOBuilder.listFromJson(
                model.getStudentsPerSemester(deptId + 1),
                ApiGraphDataPointDTO.class
        );
    }
}
