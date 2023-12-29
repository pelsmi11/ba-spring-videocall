package website.pelsmi11.videocallspring.user;

import org.springframework.stereotype.Service;
import website.pelsmi11.videocallspring.credentials.Credentials;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_LIST = new ArrayList<>();
    private final Credentials credentials ;

    public UserService(Credentials credentials) {
        this.credentials = credentials;
    }
    public void register(User user){
        user.setStatus("online");
        USERS_LIST.add(user);
    }

    public User Login(User user){
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()->new RuntimeException("User not found"));

        var cUser = USERS_LIST.get(userIndex);
        if(!cUser.getPassword().equals(user.getPassword())){
           throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }

    public void logout(String email){
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()->new RuntimeException("User not found"));
        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public Credentials getCredentials(){
        return credentials;
    }

    public List<User> findAll(){
        return USERS_LIST;
    }
}
