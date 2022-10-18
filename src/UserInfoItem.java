public class UserInfoItem {
    private String userName;
    private int userType;

    UserInfoItem(int userType, String userName) {
        this.userType = userType;
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public int getUserType() {
        return this.userType;
    }
}
