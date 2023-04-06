package br.com.atarashi.forum.controller

import br.com.atarashi.forum.dto.AtualizacaoRespostaForm
import br.com.atarashi.forum.dto.NovaRespostaForm
import br.com.atarashi.forum.dto.RespostaView
import br.com.atarashi.forum.model.Resposta
import br.com.atarashi.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostasController(private val service: RespostaService) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<Resposta> {
        return service.listar(id)
    }

    @PostMapping
    fun cadastrar(@PathVariable id: Long, @RequestBody @Valid dto: NovaRespostaForm, uriBuilder: UriComponentsBuilder): ResponseEntity<RespostaView> {
        val respostaView = service.cadastrar(dto, id)
        val uri = uriBuilder.path("/topicos/${respostaView.topico?.id}/respostas/${respostaView.id}").build().toUri()

        return ResponseEntity.created(uri).body(respostaView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoRespostaForm): ResponseEntity<RespostaView> {
        val respostaView = service.atualizar(form)

        return ResponseEntity.ok(respostaView)
    }

    @DeleteMapping("{idResposta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idResposta: Long) {
        service.deletar(idResposta)
    }
}