package br.com.estudo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import br.com.estudo.entity.Pessoa;
import br.com.estudo.enuns.EnumSexo;
import br.com.estudo.util.ConexaoUtil;

public class PessoaDAO {

    @SuppressWarnings("unchecked")
    public List<Pessoa> buscarPessoasPorSexo(EnumSexo sexo) {

        // conexao com o banco de dados
        EntityManager em = ConexaoUtil.getInstance().getEntityManager();

        // executando a function do postgrees
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("buscarPessoasPorSexo", Pessoa.class);
        storedProcedure.registerStoredProcedureParameter("genero", String.class, ParameterMode.IN);
        storedProcedure.setParameter("genero", sexo.name());
        storedProcedure.execute();

        // resultado
        List<Pessoa> results = storedProcedure.getResultList();

        // fechando transacao e o EntityManager
        em.getTransaction().commit();
        em.close();

        return results;
    }

}
