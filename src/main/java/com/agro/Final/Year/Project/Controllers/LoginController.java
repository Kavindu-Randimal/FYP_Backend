package com.agro.Final.Year.Project.Controllers;

import com.agro.Final.Year.Project.Models.Dto.LoginUser;
import com.agro.Final.Year.Project.Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    LoginRepository loginRepository;



    @PostMapping("/register")
    public LoginUser registerUser(@RequestBody LoginUser loginUser) throws Exception{

        if (loginUser.getUserName().isEmpty() || loginUser.getUserEmail().isEmpty() ||
                loginUser.getUserRole().isEmpty() || loginUser.getPassword().isEmpty()){
            System.out.println("user name cant be empty");
        }
        List<LoginUser> loginUsers = loginRepository.findByEmail(loginUser.getUserEmail());
        if ( loginUsers!=null && loginUsers.size() > 1 ) {
            throw new Exception("User Already Registerd");
        }
        loginRepository.save(loginUser);
        System.out.println("save");
        return loginRepository.save(loginUser);
    }

    @PostMapping("/login")
    public LoginUser login(@RequestBody LoginUser loginUser) throws Exception{

        if (loginUser.getUserEmail().isEmpty() || loginUser.getPassword().isEmpty()){
            throw new Exception("user name cant be empty");
        }
        List<LoginUser> loginUsers = loginRepository.findByEmail(loginUser.getUserEmail());
        if ( loginUsers!=null && loginUsers.size() > 0 && loginUsers.get(0) != null ) {
            if ( loginUsers.get(0).getPassword(). equals( loginUser.getPassword() ) ) {
                return loginUsers.get(0);
            }
        }
        throw new Exception("user not found");
    }

//    @PostMapping("/login")
//    public LoginUser loginUser(@RequestBody LoginUser loginUser) throws Exception{
//
//        if (loginUser.getUserName().isEmpty() || loginUser.getUserEmail().isEmpty() ||
//                loginUser.getUserRole().isEmpty() || loginUser.getPassword().isEmpty()){
//            System.out.println("user name cant be empty");
//        }
//        List<LoginUser> loginUsers = loginRepository.findByEmail(loginUser.getUserEmail());
//        if ( loginUsers!=null && loginUsers.get(0) != null ) {
//            if ( loginUsers.get(0).getPassword(). equals( loginUser.getPassword() ) ) {
//                return loginUsers.get(0);
//            }
//        }
//        return null;
//    }

    @PostMapping("/registerPrivateKey")
    public LoginUser registerPrivateKey(@RequestBody LoginUser loginUser) throws Exception{

        if (loginUser.getPrivateKey().isEmpty() || loginUser.getUserEmail().isEmpty()){
            throw new Exception("user email or priivate key cant be empty");
        }
        List<LoginUser> loginUsers = loginRepository.findByEmail(loginUser.getUserEmail());
        if ( loginUsers!=null && loginUsers.get(0) != null ) {
            loginUsers.get(0).setPrivateKey(loginUser.getPrivateKey());
            loginRepository.save(loginUser);
            loginUsers.get(0).setPassword(null);
            return loginUsers.get(0);
        }
        return null;
    }

    @GetMapping("/user")
    public List<LoginUser> getAllUsers() {
        return loginRepository.findAll();
    }

}
