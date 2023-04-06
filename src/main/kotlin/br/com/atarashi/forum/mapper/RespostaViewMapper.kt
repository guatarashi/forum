package br.com.atarashi.forum.mapper

import br.com.atarashi.forum.dto.RespostaView
import br.com.atarashi.forum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper(): Mapper<Resposta, RespostaView> {

    override fun map(t: Resposta): RespostaView {
        return RespostaView(
        mensagem = t.mensagem,
        autor = t.autor
        )
    }
}