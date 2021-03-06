package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.service;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.repository.ExemplarRepository.buscaExemplar;
import static br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.repository.UsuarioRepository.buscaUsuario;

public class EmprestimoConcebidoService {

    public static Set<EmprestimoConcedido> analisaEmprestimos(Set<DadosEmprestimo> emprestimos, Set<DadosUsuario> usuarios, Set<DadosExemplar> exemplares) throws Exception {
        List<EmprestimoConcedido> response = new ArrayList<>();

        for (DadosEmprestimo emprestimo: emprestimos) {
            DadosUsuario usuario = buscaUsuario(emprestimo.idUsuario, usuarios);

            if ((usuario.padrao == TipoUsuario.PADRAO && emprestimo.tipoExemplar == TipoExemplar.RESTRITO) || emprestimo.tempo > 60) {
                continue;
            }

            int idExemplar = buscaExemplar(emprestimo.idLivro, emprestimo.tipoExemplar, exemplares);
            response.add(new EmprestimoConcedido(
                    usuario.idUsuario,
                    idExemplar,
                    LocalDate.now().plusDays(emprestimo.tempo)));
        }

        return new HashSet<>(response);
    }
}
