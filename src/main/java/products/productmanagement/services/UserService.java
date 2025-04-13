
package products.productmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.productmanagement.models.User;
import products.productmanagement.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public User createUser(User user){
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        return userRepository.save(user);
    }
    
    public User getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        
        return user;
    }
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    @Transactional
    public User updateUser(Long id, User user){
        User existingUser = getUserById(id);
        
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }
    
    @Transactional
    public void deleteUser(Long id){
        User userFounded = userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
     
        userRepository.delete(userFounded);
    }
}
