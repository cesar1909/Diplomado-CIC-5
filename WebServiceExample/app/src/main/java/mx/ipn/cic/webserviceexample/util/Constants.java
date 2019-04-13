package mx.ipn.cic.webserviceexample.util;

public class Constants {

    private Constants() {

    }

    private static String HOST = "https://baas.kinvey.com";
    private static String PORT = "";

    //public static String ALL_USERS = "http://127.0.0.1:8081/rest/user/all";
    public static String ALL_USERS =
            String.format("%s%s/appdata/kid_SkmNnKUKN/Usuarios", HOST, PORT);

    public static String DELETE_USER =
            String.format("%s%s/appdata/kid_SkmNnKUKN/Usuarios/{USER_ID}", HOST, PORT);

    public static String UPDATE_USER =
            String.format("%s%s/appdata/kid_SkmNnKUKN/Usuarios/{USER_ID}", HOST, PORT);

}
