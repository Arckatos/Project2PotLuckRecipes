package transferobjects;

/**
 *
 * @author Arck
 */
public class Member {
    /* ATTRIBUTES	-----------------------------------------------------	*/
    
    /** memberId will contain a numeric value.*/
    private int memberId;
    /** isAdmin will contain a boolean value.*/
    private boolean isAdmin;
    /** alias will contain a String value.*/
    private String alias;
    /** firstName will contain a String value.*/
    private String firstName;
    /** lastName will contain a String.*/
    private String lastName;
    /** email will contain a String value.*/
    private String email; 
    /** username will contain a String value.*/
    private String username; 
    /** password will contain a String value.*/
    private String password; 
    /** salt will contain a String value.*/
    private String salt; 
    /* MODIFIERS	-----------------------------------------------------	*/

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /* ACCESSORS	-----------------------------------------------------	*/

    public int getMemberId() {
        return memberId;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public String getAlias() {
        return alias;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }
    
}

