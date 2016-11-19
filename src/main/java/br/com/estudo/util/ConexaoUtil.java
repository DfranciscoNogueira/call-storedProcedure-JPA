package br.com.estudo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoUtil {

    private static ConexaoUtil conexaoUtil;
    private EntityManagerFactory emf;

    private ConexaoUtil() {
        emf = Persistence.createEntityManagerFactory("call-stotedProcedure-JPA");
    }

    public static ConexaoUtil getInstance() {
        if (conexaoUtil == null)
            conexaoUtil = new ConexaoUtil();
        return conexaoUtil;
    }

    // retorna o entityManager com a transacao ja aberta
    public EntityManager getEntityManager() {
        EntityManager toReturn = emf.createEntityManager();
        toReturn.getTransaction().begin();
        return toReturn;
    }

}
