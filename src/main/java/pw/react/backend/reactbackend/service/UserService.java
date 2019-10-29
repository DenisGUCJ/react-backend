package pw.react.backend.reactbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.react.backend.reactbackend.entity.User;
import pw.react.backend.reactbackend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    public User checkLogin(String login) {
        List<User> users;
        users = (List<User>) usersRepository.findAll();
        for (User user : users) {
            if (user.getLogin() != null && user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    public void delete(User userToDelete) {
        usersRepository.delete(userToDelete);
    }

    public User save(User user) {
        return usersRepository.save(user);
    }

    public User findById(Long id){
        Optional<User> user= usersRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }
}