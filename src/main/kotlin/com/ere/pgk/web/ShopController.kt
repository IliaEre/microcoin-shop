package com.ere.pgk.web

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.vertx.reactivex.sqlclient.SqlClient

@Controller("/v1/products/")
class ShopController(private val client: SqlClient) {

    @Get
    fun getAll() = client.query("select * from public.product").rxExecute()

    @Get("/{id}")
    fun findOne(@PathVariable id: Long) = "ok"

}
