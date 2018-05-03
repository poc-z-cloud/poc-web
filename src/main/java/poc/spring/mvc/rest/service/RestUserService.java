package poc.spring.mvc.rest.service;

import java.util.List;

import poc.spring.mvc.rest.domain.User;

public interface RestUserService {
	User findById(long id);
    
    User findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);
}
