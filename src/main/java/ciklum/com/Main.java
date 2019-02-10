package ciklum.com;

import ciklum.com.impl.IUserImpl;
import ciklum.com.impl.IUserServiceImpl;
import ciklum.com.src.IUserService;

public class Main {

    public static void main(String[] args){

        IUserService service = new IUserServiceImpl();
        service.save(new IUserImpl("1", "1", "Name"));
        service.save(new IUserImpl("2", "1", "Name1"));
        service.save(new IUserImpl("3", "1", "Name2"));
        service.save(new IUserImpl("4", "4", "Name3"));

        System.out.println(service.findAll());

        /*
            Feel free to edit the main() method for testing
            Please don't forget to checkout the IUserServiceImplTest.java
         */
    }
}
