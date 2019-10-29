package pw.react.backend.reactbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pw.react.backend.reactbackend.repository.UserRepository;
import pw.react.backend.reactbackend.service.UserService;
import pw.react.backend.reactbackend.entity.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/spring")
public class UserController {

    @Autowired
    private UserRepository user_repocitory;

    @Autowired
    private UserService user_service;

    @GetMapping(value = "/showUsersAll")
    public List<User> showUsersAll() {
        List<User> users = (List<User>) user_repocitory.findAll();
        return users;
    }

    //See the "READ_PLEASE.txt" file to properly pass values for POST method
    @PostMapping(value ="/createUser")
    public String createUser(@RequestBody User user) {
        if (user_service.checkLogin(user.getLogin())==null) {
            user_repocitory.save(new User(user.getLogin(),user.getFirstName(),
                    user.getLastName(),user.getDateOfBirth(),user.getIsActive()));
            return "User was added to the database";
        }
        return "Error was occurred";
    }

    @GetMapping(value="/findByLogin/{login}")
    public String retrieveByLogin(@PathVariable String login) {
        User user = user_repocitory.findByLogin(login);
        if(user == null)
            return "No user was found";
        return user.toString();
    }

    @GetMapping(value="/findById/{id}")
    public String retriveById(@PathVariable(value = "id") Long id) {
        User user = user_service.findById(id);
        if(user == null)
            return "No user was found";
        return user.toString();
    }

    @PutMapping("/updateById/{id}")
    public String updateById(@PathVariable(value = "id") Long id, @Valid @RequestBody User tmp) {
        User user = user_service.findById(id);
        if (user == null) {
            return "No user was found";
        }
        user.setUser(tmp.getLogin(), tmp.getFirstName(),
                tmp.getLastName(), tmp.getDateOfBirth(), tmp.getIsActive());
        final User updatedUser = user_service.save(user);
        return updatedUser.toString();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteId(@PathVariable(value = "id") Long id) {
        User user = user_service.findById(id);
        if (user == null) {
            return "No user was found";
        }
        user_service.delete(user);
        return "User was deleted";
    }

}