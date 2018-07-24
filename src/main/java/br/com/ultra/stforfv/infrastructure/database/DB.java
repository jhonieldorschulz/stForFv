package br.com.ultra.stforfv.infrastructure.database;

/**
 * Created by Jhoni on 24/11/2017.
 */
public class DB {

    private String host;

    private String porta = "3050";

    private String url;

    private String targetDB;

    private final static String username = "SYSDBA";

    private final static String password = "masterkey";


    public DB(String host, String porta, String targetDB, String url) {
        this.host = host;
        this.porta = porta;
        this.targetDB = targetDB;
        this.url = url;
    }

    public DB(String targetDB, String url) {
        this.targetDB = targetDB;
        this.url = url;
        this.host = "ultraserver";
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getTargetDB() {
        return targetDB;
    }

    public void setTargetDB(String targetDB) {
        this.targetDB = targetDB;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
}


