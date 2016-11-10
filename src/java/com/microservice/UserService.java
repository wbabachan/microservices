package com.microservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

    private List<User> list = new ArrayList();

    public UserService() {
        list.add(new User("1", "Harald"));
        list.add(new User("2", "Hans"));
        list.add(new User("3", "Gerhard"));
        list.add(new User("4", "Julia"));
        list.add(new User("5", "Petra"));
        list.add(new User("6", "Jana"));
    }

    @GET
    @Path("/list")
    public List<User> getUsers() {
        return list;
    }

    @GET
    @Path("/{userId}")
    public User getUser(@PathParam("userId") String id) {
        User selectedUser = null;
        for(User user : list) {
            if (user.getId().equals(id)) {
                selectedUser = user;
                break;
            }
        }
        return selectedUser;
    }
    
    @DELETE
    @Path("/{userId}")
    public boolean deleteUser(@PathParam("userId") String id) {
        return true;
    }

    @PUT
    @Path("/{userId}/{userName}")
    public boolean deleteUser(@PathParam("userId") String id, @PathParam("userName") String name) {
        list.add(new User(id, name));
        return true;
    }

}
