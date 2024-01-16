package com.example.datalayer

class Resource<T>(var status: Status, var data: T?) {

    companion object {
        fun <T> newInstance(status: Status, data: T?): Resource<T>{
            return Resource(status, data)
        }
    }
}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}