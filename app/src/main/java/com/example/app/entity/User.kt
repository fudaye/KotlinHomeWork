package com.example.app.entity

class User {

    constructor()

    constructor(username: String, password: String, code: String) {
        this.username = username
        this.password = password
        this.code = code
    }

    var username: String? = null
    var password: String? = null
    var code: String? = null


}