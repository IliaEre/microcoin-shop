package com.ere.pgk

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec

@MicronautTest
class MicrocoinShopTest(private val application: EmbeddedApplication<*>) : StringSpec({

    "test the server is running" {
        assert(application.isRunning)
    }
})
