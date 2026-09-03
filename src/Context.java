import java.util.HashMap;

/// This is such a cheat but I can't think of anything else atp tbh
public class Context {
    private static final HashMap<String, Object> contextVars;

    static {
        contextVars = new HashMap<String, Object>();
    }

    public static void addContextVar(String name, Object variable) {
        contextVars.put(name, variable);
    }

    /// Hi from tooltip
    public static Object getContextVar(String name) {
        return contextVars.get(name);
    }
}
