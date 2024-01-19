
import java.util.HashMap;
import java.util.Map;

public class AdminAccount implements Admin {
    private final Map<String, UserAccount>  userAccounts;

    public AdminAccount() {
        this.userAccounts = new HashMap<>();
    }

    @Override
    public void viewUsers() {
        System.out.println("User List:");
        for (String username : userAccounts.keySet()) {
            System.out.println(username);
        }
    }

    public void addUser(UserAccount userAccount) {
        userAccounts.put(userAccount.getUsername(), userAccount);
        System.out.println("User added: " + userAccount.getUsername());
    }

    @Override
    public UserAccount getUserAccount(String username) {
        return userAccounts.get(username);
    }
}
