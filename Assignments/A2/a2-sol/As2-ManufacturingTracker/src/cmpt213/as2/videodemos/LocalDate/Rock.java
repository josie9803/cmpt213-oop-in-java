package cmpt213.as2.videodemos.LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Rock {
    private String name;
    private LocalDate dateCreated;

    public Rock(String name, LocalDate dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "name='" + name + '\'' +
                ", dateCreated=" + dateCreated.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
