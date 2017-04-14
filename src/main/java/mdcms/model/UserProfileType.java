package mdcms.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
    ADMIN("ADMIN"),
    MOD("MOD");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }

}