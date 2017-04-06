package br.com.estudo.main;

import java.util.List;

import br.com.estudo.dao.PessoaDAO;
import br.com.estudo.dto.PessoaDTO;
import br.com.estudo.entity.Pessoa;
import br.com.estudo.enuns.EnumSexo;

public class TesteMain {

    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDAO();

        List<Pessoa> pessoas = dao.buscarPessoasPorSexo(EnumSexo.M);

        List<PessoaDTO> pessoasDTO = dao.buscarTodasPessoas();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome().concat(" e do sexo Masculino !"));
        }

        System.out.println("Total de Pessoas encontradas : " + pessoasDTO.size());
    }
}
