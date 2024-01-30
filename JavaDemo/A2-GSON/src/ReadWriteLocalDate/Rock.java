package ReadWriteLocalDate;

import java.time.LocalDate;

public class Rock {
    private String name;
    private LocalDate dateCreated;

    public Rock(String name, LocalDate dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "ReadWriteLocalDate.Rock{" +
                "name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
