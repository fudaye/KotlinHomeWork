package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson

class LessonAdapter :RecyclerView.Adapter<LessonAdapter.LessonViewHolder>(){

    var list = listOf<Lesson>()

    fun updateAndNotify(list: List<Lesson>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {

        companion object{
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false))
            }
        }

        fun onBind(lesson: Lesson) {
            var data = lesson.date
            if (data == null) {
                data = "日期待定"
            }
            setText(R.id.tv_date, data)
            //let 判断这个值是否为null 如果不为null的时候才执行代码块里面的代码
            lesson.content?.let { setText(R.id.tv_content, it) }
            val state = lesson.state
            if (state != null) {
                state.stateName()?.let { setText(R.id.tv_state, it) }
                val colorRes: Int = when (state) {
                    Lesson.State.PLAYBACK -> R.color.playback
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state).setBackgroundColor(backgroundColor)
            }
        }

    }
}