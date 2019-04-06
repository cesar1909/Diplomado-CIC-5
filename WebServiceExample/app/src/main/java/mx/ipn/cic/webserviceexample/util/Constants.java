package mx.ipn.cic.webserviceexample.util;

public class Constants {

    private Constants() {

    }

    private static String HOST = "http://192.168.100.11";
    private static String PORT = "8081";

    //public static String ALL_USERS = "http://127.0.0.1:8081/rest/user/all";
    public static String ALL_USERS =
            String.format("%s:%s/rest/user/all", HOST, PORT);

}
