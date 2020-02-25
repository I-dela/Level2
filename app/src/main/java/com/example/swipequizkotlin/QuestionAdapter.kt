package com.example.swipequizkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.question_place.view.*

class QuestionAdapter(private var questions: ArrayList<Question>) : RecyclerView.Adapter<QuestionAdapter.Viewholder>() {


   inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val questionn  = itemView.question

       var context = itemView





       fun bind(question : Question){
           questionn.text = question.question
           val answer = question.answer
           itemView.setOnClickListener{
               Toast.makeText(context.context, "Answer is $answer", Toast.LENGTH_SHORT ).show()
           }

       }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.question_place, parent, false))

    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        when(holder){
            is Viewholder -> {
                holder.bind(questions[position])
            }

        }
    }
}