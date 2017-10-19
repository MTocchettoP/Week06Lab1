/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.services;

/**
 *
 * @author 733196
 */
public class UserServices {
    
    private String[] userNames = {"adam", "betty"};
    private String password = "password";
    
    public  User loging(String loginName, String password){
        User user = null;
        
        for(String userName : userNames)
            if(userName.equals(loginName))
                if(this.password.equals(password)){
                    user = new User();
                    user.setName(loginName);
                }
        return user;
    }
}
