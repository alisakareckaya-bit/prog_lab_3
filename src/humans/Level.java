package humans;

public enum Level {
    HIGH("очень любит газировку"),
    MEDIUM("иногда по праздникам выпивает газировку"),
    SMALL("почти не любит газировку");
    final String description;
    Level(String desc) {
        this.description = desc;
    }
}