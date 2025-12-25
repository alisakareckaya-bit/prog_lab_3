package humans;

public class StoryException extends Exception {
    public StoryException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "ААААА " + super.getMessage();
    }
}