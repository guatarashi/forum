package br.com.atarashi.forum.service

import br.com.atarashi.forum.dto.AtualizacaoTopicoForm
import br.com.atarashi.forum.dto.NovoTopicoForm
import br.com.atarashi.forum.dto.TopicoView
import br.com.atarashi.forum.exception.NotFoundException
import br.com.atarashi.forum.mapper.TopicoFormMapper
import br.com.atarashi.forum.mapper.TopicoViewMapper
import br.com.atarashi.forum.model.Topico
import br.com.atarashi.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map { t -> topicoViewMapper.map(t) }
            .collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun buscaPorId(id: Long): Topico {
        return repository.getReferenceById(id)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) : TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}