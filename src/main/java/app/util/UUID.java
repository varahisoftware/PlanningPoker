package app.util;

public interface UUID {

    static String generate() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

}
