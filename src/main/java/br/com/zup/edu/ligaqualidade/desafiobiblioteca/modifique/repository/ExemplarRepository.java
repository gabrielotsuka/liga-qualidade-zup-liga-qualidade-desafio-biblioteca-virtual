package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.repository;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;

import java.util.Set;

public class ExemplarRepository {

    public static int buscaExemplar(int idLivro, TipoExemplar tipoExemplar, Set<DadosExemplar> exemplares) throws Exception {
        for (DadosExemplar exemplar: exemplares) {
            if (exemplar.idLivro == idLivro && exemplar.tipo == tipoExemplar)
                return exemplar.idExemplar;
        }
        throw new Exception("Exemplar não encontrado");
    }

}
