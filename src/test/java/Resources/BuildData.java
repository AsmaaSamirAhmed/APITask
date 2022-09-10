package Resources;



import Pojo_Classes.Profile;
import Pojo_Classes.User;
import Pojo_Classes.UsersAdded;

import java.util.ArrayList;
import java.util.List;

public class BuildData {
    UsersAdded Users;
    List<User> UserInfo;
    User u;
    Profile UserProfile;
    public UsersAdded AddUserPayload()
    {
         Users=new UsersAdded();
        UserInfo=new ArrayList<User>();
        u=new User();
        u.setName("Semsem");
        u.setUsername("asmaa@test.com");
        UserProfile=new Profile();
        UserProfile.setFirstName("Asmaas");
        UserProfile.setLastName("Samir");

        List<String> UserOrders=new ArrayList<String>();
        UserOrders.add("order1");
        UserOrders.add("order2");
        UserProfile.setOrders(UserOrders);
        u.setProfile(UserProfile);
        UserInfo.add(u);
        Users.setUserDetails(UserInfo);
return Users;
    }
    public String getUserFirstname(){
        String u;
        u=UserProfile.getFirstName();
        return u;
    }

}
