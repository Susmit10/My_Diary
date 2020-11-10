package com.example.mydiary

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class NotesAdapter(private val context: Context, private val listener: INotesRVAdapter): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private val allNote = ArrayList<Note>()

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.text)
        val img = itemView.findViewById<ImageView>(R.id.del)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_items, parent, false))
        viewHolder.img.setOnClickListener {
            listener.onItemClicked(allNote[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = allNote[position]
        holder.text.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNote.size
    }

    fun updateList(newList: List<Note>){
        allNote.clear()
        allNote.addAll(newList)

        notifyDataSetChanged()
    }

}

interface INotesRVAdapter{
    fun onItemClicked(note: Note)
}

