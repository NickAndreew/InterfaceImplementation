package ciklum.com.impl;

import ciklum.com.src.IUser;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class IUserImpl implements IUser {

    private String id;
    private String name;
    private String groupId;

    public IUserImpl(){
    }

    public IUserImpl(String id, String groupId, String name){
        this.id = id;
        this.groupId = groupId;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGroupId() {
        return this.groupId;
    }
}
