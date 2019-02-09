package ch.efg.sample.api.implementation;

import ch.efg.sample.api.interfaces.IUser;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
