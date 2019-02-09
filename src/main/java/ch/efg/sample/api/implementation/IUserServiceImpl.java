package ch.efg.sample.api.implementation;

import ch.efg.sample.api.interfaces.IUserService;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import java.util.stream.Collectors;

public class IUserServiceImpl implements IUserService {

    private List<IUserImpl> users;

    public IUserServiceImpl(){
        this.users = new ArrayList<>();
    }

    public IUserServiceImpl(List<IUserImpl> list){
        this.users = list;
    }

    public List<IUserImpl> findAll() {
        if(users.size()>0) {
            return this.users.stream().collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<IUserImpl> findById(String id){
        List<IUserImpl> usersById = new ArrayList<>();
        if(users.size()>0) {
            usersById = this.users
                .stream()
                .filter(iUser -> id.equals(iUser.getId()))
                .collect(Collectors.toList());
        }
        return usersById;
    }

    @Override
    public Object save(Object user) {
        if(user!=null && user.getClass()==IUserImpl.class){
            this.users.add((IUserImpl) user);
        }
        return user;
    }

    @Override
    public List saveAll(Iterable newUsers) {
        List<IUserImpl> users = new ArrayList<>();
        newUsers.forEach(iUser -> {
            this.save(iUser);
            users.add((IUserImpl) iUser);
        });
        return users;
    }

    public IUserImpl delete(String id) {
        IUserImpl user;
        user = this.users
            .stream()
            .filter(iUser -> id.equals(iUser.getId()))
            .findAny()
            .orElse(null);

        if(user!=null){
            this.users.remove(user);
            return user;
        } else {
            System.out.println("No such user "+user.toString()+" found in repository.");
            return null;
        }
    }

    public Map<String, List<IUserImpl>> findAllGroupByGroupId(){
        Map<String, List<IUserImpl>> userAllUsersByGroupIdMap = new HashMap<>();
        Set<String> groupsSet = new HashSet<>();

        this.users.forEach(iUser -> groupsSet.add(iUser.getGroupId()));

        groupsSet.forEach(groupId ->
            userAllUsersByGroupIdMap.put(
                groupId,
                this.users
                    .stream()
                    .filter(iUser -> groupId.equals(iUser.getGroupId()))
                    .collect(Collectors.toList()))
                );

        return userAllUsersByGroupIdMap;
    }
}

