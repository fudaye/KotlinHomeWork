package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

class LessonPresenter(private var activity: LessonActivity) {
    companion object {
        const val LESSON_PATH = "lessons"
    }

    private var lessons = arrayListOf<Lesson>()

    private val type: Type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                lessons = entity as ArrayList<Lesson>
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String) {
                activity.runOnUiThread { Utils.toast(message) }
            }

        })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter { lesson -> lesson.state == Lesson.State.PLAYBACK })
    }

}