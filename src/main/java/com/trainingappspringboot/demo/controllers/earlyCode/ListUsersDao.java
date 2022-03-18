package com.trainingappspringboot.demo.controllers.earlyCode;

public class ListUsersDao {

//    private List<User> users;
//
//    public List<User> findAll() {
//        if (users == null) {
//            users = generateUsers();
//        }
//        return users;
//    }
//
//    public User findOne(long id) {
//        User user;
//        for(User u : users) {
//           if(u.getId() == id) {
//              user = u;
//              return user;
//           }
//        }
//        return null;
//    }
//
//    public User findByUsername(String username) {
//        User user;
//        for(User u : users) {
//            if(u.getUsername().equals(username)) {
//                user = u;
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public User findByEmail(String email) {
//        User user;
//        for(User u : users) {
//            if(u.getEmail().equals(email)) {
//                user = u;
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public void update(User user) {
//        int index = users.indexOf(user);
//        users.set(index, user);
//    }
//
//    public Long insert(User user) {
//        // make sure we have users
//        if (users == null) {
//            users = generateUsers();
//        }
//        // we'll assign an "id" here based on the size of the userss list
//        // really the dao would handle this
//        user.setId((long) users.size() + 1);
//        users.add(user);
//        return user.getId();
//    }
//
//    private List<User> generateUsers() {
//        List<User> users = new ArrayList<>();
//        users.add(new User(
//                1,
//                "user1",
//                "user1@email.com",
//                null,
//                "password",
//                LocalDateTime.now()
//        ));
//        users.add(new User(
//                2,
//                "user2",
//                "user2@email.com",
//                null,
//                "password",
//                LocalDateTime.now()
//        ));
//        users.add(new User(
//                3,
//                "user3",
//                "user3@email.com",
//                null,
//                "password",
//                LocalDateTime.now()
//        ));
//        users.add(new User(
//                4,
//                "user4",
//                "user4@email.com",
//                null,
//                "password",
//                LocalDateTime.now()
//        ));
//        return users;
//    }
}
