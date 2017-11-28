package verify;

public class VerifyRootUser {

    public static final String account = "root";
    private static final String password = "johnit01";

    public static final String account01 = "quan";
    private static final String password01 = "521314";

    public static final String ALL_LIMIT = "777";
    public static final String NO_LIMIT = "000";
    public static final String READ_LIMIT = "444";

    public static int login(String loginpassword){
        if (loginpassword.equals(password)){
            return 0;
        }else if (loginpassword.equals(password01)){
            return 1;
        }else {
            return -1;
        }
    }


}
