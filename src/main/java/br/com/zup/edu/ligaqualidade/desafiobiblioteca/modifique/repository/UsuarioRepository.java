package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.repository;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;

import java.util.Set;

public class UsuarioRepository {

    public static DadosUsuario buscaUsuario(int idUsuario, Set<DadosUsuario> usuarios) throws Exception {
        for (DadosUsuario usuario: usuarios) {
            if (usuario.idUsuario == idUsuario)
                return usuario;
        }
        throw new Exception("Usuario não encontrado");
    }
}
