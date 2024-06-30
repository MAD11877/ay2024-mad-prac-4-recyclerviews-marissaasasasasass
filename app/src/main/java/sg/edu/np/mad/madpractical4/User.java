package sg.edu.np.mad.madpractical4;

import java.io.Serializable;

public class User implements Serializable {
    // Fields
    public String name;
    public String description;
    public int id;
    public boolean followed;

    // Constructor
    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for followed
    public boolean getFollowed() {
        return followed;
    }
}