package br.com.estudo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import br.com.estudo.dto.PessoaDTO;
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

    public List<PessoaDTO> buscarTodasPessoas() {

        EntityManager em = ConexaoUtil.getInstance().getEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM buscarTodasPessoas();");

        List<Object> results = query.getResultList();
        List<PessoaDTO> pessoas = criarListaPessoaDTO1(results);

        em.getTransaction().commit();
        em.close();

        return pessoas;
    }

    private List<PessoaDTO> criarListaPessoaDTO1(List<Object> listObject) {

        List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();

        listObject.forEach(o -> {

            Object[] arrayObjects = (Object[]) o;
            PessoaDTO pessoaDTO = new PessoaDTO();

            pessoaDTO.setRecebeId(Integer.parseInt(arrayObjects[0].toString()));
            pessoaDTO.setRecebeNome(arrayObjects[1].toString());
            pessoaDTO.setRecebeIdade(Integer.parseInt(arrayObjects[2].toString()));
            pessoaDTO.setRecebeGeneroSexual( arrayObjects[3].toString() );

            pessoas.add(pessoaDTO);

        });

        return pessoas;
    }
    
    private List<PessoaDTO> criarListaPessoaDTO2(List<Object> listObject) {

        List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();

        for (Object o : listObject) {

            Object[] arrayObjects = (Object[]) o;
            PessoaDTO pessoaDTO = new PessoaDTO();

            pessoaDTO.setRecebeId(Integer.parseInt(arrayObjects[0].toString()));
            pessoaDTO.setRecebeNome(arrayObjects[1].toString());
            pessoaDTO.setRecebeIdade(Integer.parseInt(arrayObjects[2].toString()));
            pessoaDTO.setRecebeGeneroSexual(arrayObjects[3].toString());

            pessoas.add(pessoaDTO);

        }

        return pessoas;
    }


}
