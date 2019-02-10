package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import ciklum.com.impl.IUserImpl;
import ciklum.com.impl.IUserServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IUserServiceImplTest {

    private IUserServiceImpl service;

    @Before
    public void setUp() {
        List<IUserImpl> users = new ArrayList<IUserImpl>();
        users.add(new IUserImpl("1", "1", "Name"));
        users.add(new IUserImpl("2", "1", "Name1"));
        users.add(new IUserImpl("3", "1", "Name2"));
        users.add(new IUserImpl("4", "4", "Name3"));

        service = new IUserServiceImpl(users);
    }

    @Test
    public void testFindAll() {
        List<IUserImpl> users = new ArrayList<IUserImpl>();
        users.add(new IUserImpl("1", "1", "Name"));
        users.add(new IUserImpl("2", "1", "Name1"));
        users.add(new IUserImpl("3", "1", "Name2"));
        users.add(new IUserImpl("4", "4", "Name3"));

        assertEquals(users, service.findAll());
    }

    @Test
    public void testFindById() {
        assertEquals(Arrays.asList(new IUserImpl("4", "4", "Name3")), service.findById("4"));
    }

    @Test
    public void testSave() {
        assertEquals(new IUserImpl("5", "4", "Name4"), service.save(new IUserImpl("5", "4", "Name4")));
        assertEquals(Arrays.asList(new IUserImpl("5", "4", "Name4")), service.findById("5"));
    }

    @Test
    public void testSaveAll() {
        Set<IUserImpl> usersToSave = new HashSet<IUserImpl>();
        usersToSave.add(new IUserImpl("6", "4", "Name5"));
        usersToSave.add(new IUserImpl("7", "4", "Name6"));

        List<IUserImpl> usersInDb = new ArrayList<>();
        usersInDb.add(new IUserImpl("6", "4", "Name5"));
        usersInDb.add(new IUserImpl("7", "4", "Name6"));

        assertEquals(usersInDb, service.saveAll(usersToSave));
    }

    @Test
    public void testDelete() {
        List<IUserImpl> users = new ArrayList<IUserImpl>();
        users.add(new IUserImpl("1", "1", "Name"));
        users.add(new IUserImpl("2", "1", "Name1"));
        users.add(new IUserImpl("3", "1", "Name2"));

        assertEquals(new IUserImpl("4", "4", "Name3"), service.delete("4"));
        assertEquals(users, service.findAll());
    }

    @Test
    public void testFindAllGroupByGroupId() {
        List<IUserImpl> firstGroup = new ArrayList<>();
        firstGroup.add(new IUserImpl("1", "1", "Name"));
        firstGroup.add(new IUserImpl("2", "1", "Name1"));
        firstGroup.add(new IUserImpl("3", "1", "Name2"));

        List<IUserImpl> secondGroup = new ArrayList<>();
        secondGroup.add(new IUserImpl("4", "4", "Name3"));

        Map<String, List<IUserImpl>> groups = new HashMap<>();
        groups.put("1", firstGroup);
        groups.put("4", secondGroup);

        assertEquals(groups, service.findAllGroupByGroupId());
    }
}