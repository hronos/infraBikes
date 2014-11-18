/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

/**
 *
 * @author dlennart
 */
public class LoggedIn {
    boolean loggedin=false;
    String username=null;
    String role="user";
    public void LoggedIn(){
        
    }
    
    public void setUsername(String name){
        this.username=name;
    }
    public String getUsername(){
        return username;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
    public void setLoggedin(){
        loggedin=true;
    }
    public void setLoggedout(){
        loggedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.loggedin=loggedin;
    }
    public boolean getloggedin(){
        return loggedin;
    }
}
