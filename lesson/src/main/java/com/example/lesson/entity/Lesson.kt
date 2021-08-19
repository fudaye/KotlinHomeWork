package com.example.lesson.entity

data class Lesson constructor(var date: String? = null, var content: String? = null, var state: State? = null) {
    enum class State {
        PLAYBACK {
            override fun stateName(): String? {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String? {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String? {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }
}