
package products.productmanagement.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import products.productmanagement.models.User;
import products.productmanagement.services.UserService;

@RestController
@RequestMapping("/api/categories")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userCreated = userService.createUser(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User userFounded = userService.getUserById(id);
        
        return ResponseEntity.ok(userFounded);
    }
    
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        
        return ResponseEntity.ok(users);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User userUpdated = userService.updateUser(id, user);
        
        return ResponseEntity.ok(userUpdated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
