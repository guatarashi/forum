package br.com.atarashi.forum.service

import br.com.atarashi.forum.dto.AtualizacaoRespostaForm
import br.com.atarashi.forum.dto.NovaRespostaForm
import br.com.atarashi.forum.dto.RespostaView
import br.com.atarashi.forum.mapper.RespostaFormMapper
import br.com.atarashi.forum.mapper.RespostaViewMapper
import br.com.atarashi.forum.model.Resposta
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: List<Resposta>,
    private val respostaFormMapper: RespostaFormMapper,
    private val topicoService: TopicoService,
    private val respostaViewMapper: RespostaViewMapper
    ) {

    fun listar(idTopico: Long): List<Resposta> {
        return respostas.stream()
            .filter{r -> r.id == idTopico}
            .collect(Collectors.toList())
    }

    fun cadastrar(form: NovaRespostaForm, idTopico: Long):RespostaView {
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topico = topicoService.buscaPorId(idTopico)

        respostas = respostas.plus(resposta)

        return respostaViewMapper.map(resposta)
    }

    fun atualizar(form: AtualizacaoRespostaForm): RespostaView {
        val resposta = respostas.stream()
            .filter{ r -> r.id == form.id}
            .findFirst()
            .get()

        val respostaAtualizada = Resposta(
            id = form.id,
            mensagem = form.mensagem,
            autor = resposta.autor,
            topico = resposta.topico,
            dataCriacao = resposta.dataCriacao
        )

        respostas = respostas.minus(resposta).plus(respostaAtualizada)
        return respostaViewMapper.map(respostaAtualizada)
    }

    fun deletar(id: Long) {
        val resposta = respostas.stream()
            .filter { r -> r.id == id }
            .findFirst()
            .get()

        respostas = respostas.minus(resposta)
    }
}