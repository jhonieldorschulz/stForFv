package br.com.ultra.stforfv.service;

import br.com.ultra.stforfv.infrastructure.database.DB;
import br.com.ultra.stforfv.infrastructure.database.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBService {

    private static final String ULTRASERVER_URL = "D:/ftp/Clientes/Bancos";

    private static final DB PROVINA = new DB( "PROVINA", ULTRASERVER_URL + "/PROVINA_NF.FDB");
    private static final DB KGEPEL = new DB("KGEPEL", ULTRASERVER_URL + "/KGEPEL.FDB");
    private static final DB GLOBAL = new DB( "GLOBAL", ULTRASERVER_URL + "/GLOBAL_HOMOLOGACAO.FDB");
    private static final DB TOPVET = new DB( "TOPVET", ULTRASERVER_URL + "/TOPVET.FDB");
    private static final DB SCHUMACHER = new DB("SCHUMACHER", ULTRASERVER_URL + "/SCHUMACHER.FDB");


    private static final List<DB> databases = Arrays.asList(PROVINA, KGEPEL, GLOBAL, TOPVET, SCHUMACHER);


    @Autowired
    private DBConnection dbConnection;

    public void setDB(String db){
        DB database = databases.stream().filter(d -> d.getTargetDB().equals(db)).findFirst().get();
        dbConnection.createDataSource();
        dbConnection.setDataSource(database);
    }




}
