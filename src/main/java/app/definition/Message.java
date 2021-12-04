package app.definition;

import com.google.gson.Gson;

import java.io.Serializable;

public class Message implements Serializable {

    private static final Gson GSON = new Gson();

    public enum Persona {PARTICIPANT, SCRUM_MASTER}

    public enum Type {JIRA}

    private final Persona from;
    private final Persona to;
    private final String sessionId;
    private final Type type;
    private final Object payload;

    public Message(Persona from, Persona to, String sessionId, Type type, Object payload) {
        this.from = from;
        this.to = to;
        this.sessionId = sessionId;
        this.type = type;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
