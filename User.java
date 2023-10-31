public class User {
    private String email;
    private String password;
    private boolean isAdmin = false;

    public User(String e, String p){
        this.email = e;
        this.password = p;
    }

    public String getEmail(){
        return this.email;
    }

    public void setAdmin(boolean admin){
        this.isAdmin = admin;
    }

    public boolean isAdmin(){
        return this.isAdmin;
    }
    
}
