package br.com.atarashi.forum.service

import br.com.atarashi.forum.dto.NovaRespostaForm
import br.com.atarashi.forum.mapper.RespostaFormMapper
import br.com.atarashi.forum.model.Curso
import br.com.atarashi.forum.model.Resposta
import br.com.atarashi.forum.model.Topico
import br.com.atarashi.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.Arrays
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: List<Resposta>,
    private val respostaFormMapper: RespostaFormMapper,
    private val topicoService: TopicoService
    ) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        val autor = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )

        val topico = Topico(
            id = 1,
            titulo = "Dúvida Kotlin",
            mensagem = "Variáveis no Kotlin",
            curso = curso,
            autor = autor
        )

        val resposta = Resposta(
            id = 1,
            mensagem = "Resposta 1",
            autor = autor,
            topico = topico,
            solucao = false
        )

        val resposta2 = Resposta(
            id = 2,
            mensagem = "Resposta 2",
            autor = autor,
            topico = topico,
            solucao = false
        )

        respostas = Arrays.asList(resposta, resposta2)
    }

    fun listar(idTopico: Long): List<Resposta> {
        return respostas.stream()
            .filter{r -> r.id == idTopico}
            .collect(Collectors.toList())
    }

    fun cadastrar(form: NovaRespostaForm, idTopico: Long) {
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topico = topicoService.buscaPorId(idTopico)

        respostas = respostas.plus(resposta)
    }
}