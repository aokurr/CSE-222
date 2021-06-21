
public class User {
    private String Name_Surname;
    private String Password;
    private String Id;
    private String Role;
    private static final String COMMA_DELIMITER=";";
    public User(String data[]){
        Name_Surname=data[3];
        Password=data[1];
        Id=data[0];
        Role=data[2];
    }

    /**
     * print user information on the screen
     * @return
     */
    public String toString(){
        return String.format("\n**Name= %s\nId= %s\nPassword= %s\nRole= %s**\n",Name_Surname,Id,Password,Role);
    }

    /**
     * Returns the user's password
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     *returns the user's role
     * @return
     */
    public String getRole(){
        return Role;
    }
}
