package website.pelsmi11.videocallspring.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import website.pelsmi11.videocallspring.credentials.Credentials;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping
    public void register(
            @RequestBody User user
    ) {
        service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.Login(user);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody User email) {
        service.logout(email.getEmail());
    }

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/credentials")
    public Credentials getCredentials(){
        return service.getCredentials();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex){
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

}
