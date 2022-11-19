package nxu.it.entity;

public class SysUser{
        private String username;
        private String password;
        private  String role="user";

    public SysUser(String username) {
        this.username = username;
        if (username.equals("admin"))
        {
            role="admin";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public  boolean isAdmin(){
        return role.equals("admin");
    }
}
