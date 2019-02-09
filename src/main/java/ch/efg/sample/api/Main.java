package ch.efg.sample.api;

import ch.efg.sample.api.implementation.IUserImpl;
import ch.efg.sample.api.implementation.IUserServiceImpl;
import ch.efg.sample.api.interfaces.IUserService;

public class Main {

    public static void main(String[] args){

        IUserService service = new IUserServiceImpl();
        service.save(new IUserImpl("1", "1", "Name"));
        service.save(new IUserImpl("2", "1", "Name1"));
        service.save(new IUserImpl("3", "1", "Name2"));
        service.save(new IUserImpl("4", "4", "Name3"));

        System.out.println(service.findAll());
    }
}
