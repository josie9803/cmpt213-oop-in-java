
package ca.cmpt213.as5courseplanner.controllers;

import ca.cmpt213.as5courseplanner.controllers.datatransferobjects.ApiWatcherCreateDTO;
import ca.cmpt213.as5courseplanner.controllers.datatransferobjects.ApiWatcherDTO;
import ca.cmpt213.as5courseplanner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Watcher controller class to generate the REST interface via Spring Boot.
 */
@RestController()
@RequestMapping("/api/watchers")
public class WatcherController {
    @Autowired
    private Model model;


    // ------------------------
    //  List watchers
    // ------------------------
    @GetMapping()
    public Iterable<ApiWatcherDTO> getAbout() {
        return DTOBuilder.listFromJson(
                model.getWatchers(),
                ApiWatcherDTO.class
        );
    }

    // ------------------------
    //  New Watcher
    // ------------------------
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiWatcherDTO newWatcher(@RequestBody ApiWatcherCreateDTO watcherInfo) {
        // Find the course
        Department department = model.getDepartment(watcherInfo.deptId);
        Course course = model.getCourse(watcherInfo.deptId, watcherInfo.courseId);

        // Build the watcher
        Watcher watcher = new Watcher(department, course);

        return DTOBuilder.fromJson(
                model.addWatcher(watcher),
                ApiWatcherDTO.class
        );
    }

    // ------------------------
    //  Get specific watcher
    // ------------------------
    @GetMapping("/{id}")
    public ApiWatcherDTO getWatcher(@PathVariable("id") long id) {
        for (Watcher watcher : model.getWatchers()) {
            if (watcher.getId() == id) {
                return DTOBuilder.fromJson(
                        watcher,
                        ApiWatcherDTO.class
                );
            }
        }
        throw new ResourceNotFoundException("Unable to find requested watcher.");
    }

    // ------------------------
    //  Delete specific watcher
    // ------------------------
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWatcher(@PathVariable("id") long id) {
        Iterator<Watcher> itr = model.getWatchers().iterator();
        while (itr.hasNext()) {
            Watcher watcher = itr.next();
            if (watcher.getId() == id) {
                itr.remove();
                return;
            }
        }
        throw new ResourceNotFoundException("Unable to find requested watcher.");
    }
}
