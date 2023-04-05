package br.com.atarashi.forum.mapper

import br.com.atarashi.forum.dto.NovaRespostaForm
import br.com.atarashi.forum.model.Resposta
import br.com.atarashi.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService
): Mapper<NovaRespostaForm, Resposta> {

    override fun map(t: NovaRespostaForm): Resposta {
        return Resposta(
        mensagem = t.mensagem,
        autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}