package app.definition;

import com.google.gson.Gson;

public enum Estimate {

    ONE("1"), TWO("2"), THREE("3"), FIVE("5"), EIGHT("8"), NEED_MORE_INFO("Need More Info");

    private static final Gson GSON = new Gson();
    private final String value;

    Estimate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
