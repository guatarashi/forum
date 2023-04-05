package br.com.atarashi.forum.dto

import jakarta.validation.constraints.NotEmpty

data class NovaRespostaForm(
    @field:NotEmpty
    val mensagem: String,
    val idAutor: Long
)
