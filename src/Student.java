/**
 * A student that has a unique ID.
 */
public class Student {
    /**
     * The student ID.
     */
    private final String id;

    Student(String id) {
        this.id = id;
    }

    /**
     * @return The student ID.
     */
    public String getId() {
        return id;
    }
}
