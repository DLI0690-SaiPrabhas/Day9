import java.util.HashSet;
import java.util.Set;

public class UserService{

    private Set<String> str=new HashSet<>();


    public void registerUser(String Username) throws UserAlreadyExistsException {
        if(str.contains(Username)){
            throw new UserAlreadyExistsException(Username);
        }
        else {
            str.add(Username);
            System.out.println("Successfully registered...");
        }
    }
    public void  checkUserExistence(String Username) throws UserNotFoundException{
        if(!str.contains(Username)){
            throw new UserNotFoundException(Username);
        }
        else
            System.out.println("User is existed: "+Username);

    }

    public static void main(String[] args) {

        UserService user=new UserService();
        try {
            user.registerUser("sai");
            user.registerUser("sai");
        } catch (UserAlreadyExistsException e) {

              System.out.println(e);

        }
        try {
            user.checkUserExistence("sai");
        }
        catch (UserNotFoundException e){
            System.out.println("User not found Exception");
        }

    }
}
class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}