package br.upf.magicdeck.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()