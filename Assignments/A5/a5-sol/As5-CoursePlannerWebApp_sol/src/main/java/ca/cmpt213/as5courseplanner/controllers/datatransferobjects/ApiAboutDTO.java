package ca.cmpt213.as5courseplanner.controllers.datatransferobjects;

public class ApiAboutDTO {
    public String appName;
    public String authorName;

    public ApiAboutDTO(String appName, String authorName) {
        this.appName = appName;
        this.authorName = authorName;
    }
}
