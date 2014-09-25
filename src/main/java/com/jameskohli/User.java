package com.jameskohli;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by James on 9/15/2014.
 */
@Entity (name="UserDetails")
public class User {

    @Id
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
