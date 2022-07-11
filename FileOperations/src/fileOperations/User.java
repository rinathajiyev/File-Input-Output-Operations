package fileOperations;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public transient String password;
}
