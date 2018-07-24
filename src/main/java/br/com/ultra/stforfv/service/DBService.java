package br.com.ultra.stforfv.service;

import br.com.ultra.stforfv.infrastructure.database.DB;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    private static final String ULTRASERVER_URL = "D:/ftp/Clientes/Bancos";

    private static final DB db_provina = new DB("ultra-db-provina", ULTRASERVER_URL + "/PROVINA_NF.FDB");
    private static final DB db_deroma = new DB("ultra-db-deroma", ULTRASERVER_URL + "/DEROMA.FDB");
    private static final DB db_kgepel = new DB("ultra-db-kgepel", ULTRASERVER_URL + "/KGEPEL.FDB");
    private static final DB db_dalazen = new DB("ultra-db-dalazen", ULTRASERVER_URL + "/DALAZEN.FDB");
    private static final DB db_global = new DB("ultra-db-global", ULTRASERVER_URL + "/GLOBAL.FDB");

}
