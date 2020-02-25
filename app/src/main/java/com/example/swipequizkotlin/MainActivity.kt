package com.example.swipequizkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Question>()
    private lateinit var questionAdapter : QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        recyclerViewQuiz.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            questionAdapter = QuestionAdapter(questions)
            adapter = questionAdapter
        }
        recyclerViewQuiz.addItemDecoration(
            DividerItemDecoration(
            this@MainActivity,
            DividerItemDecoration.VERTICAL
            )
        )



        for (i in Question.questions.indices) {
            questions.add(Question(Question.questions[i], Question.answers[i]))
        }
        questionAdapter.notifyDataSetChanged()

        createItemTouchHelper().attachToRecyclerView(recyclerViewQuiz)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if(direction == ItemTouchHelper.LEFT){
                    if(!questions[position].answer){
                        questions.removeAt(position)
                        questionAdapter.notifyDataSetChanged()
                        Snackbar.make(recyclerViewQuiz, "Item removed", Snackbar.LENGTH_LONG).show()
                    }else{
                        Snackbar.make(recyclerViewQuiz, "Item not removed", Snackbar.LENGTH_LONG).show()
                        questionAdapter.notifyDataSetChanged()
                    }
                }else if(direction == ItemTouchHelper.RIGHT){
                    if(questions[position].answer){
                        questions.removeAt(position)
                        questionAdapter.notifyDataSetChanged()
                        Snackbar.make(recyclerViewQuiz, "Item removed", Snackbar.LENGTH_LONG).show()
                    }else{
                        Snackbar.make(recyclerViewQuiz, "Item not removed", Snackbar.LENGTH_LONG).show()
                        questionAdapter.notifyDataSetChanged()
                    }

                }


            }
        }
        return ItemTouchHelper(callback)
    }







}
