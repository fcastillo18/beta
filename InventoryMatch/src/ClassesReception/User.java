/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesReception;

/**
 *
 * @author fcastillo
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String category;
    private boolean toChangePass;

    public User() {
    }
    
    public User(String firstName, String lastName, String userName, String password, String category, boolean toChangePass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.category = category;
        this.toChangePass = toChangePass;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isToChangePass() {
        return toChangePass;
    }

    public void setToChangePass(boolean toChangePass) {
        this.toChangePass = toChangePass;
    }
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", category=" + category + ", toChangePass=" + toChangePass + '}';
    }
    
    
    
}
