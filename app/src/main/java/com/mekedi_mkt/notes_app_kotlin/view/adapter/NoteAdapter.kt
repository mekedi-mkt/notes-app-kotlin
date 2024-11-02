package com.mekedi_mkt.notes_app_kotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mekedi_mkt.notes_app_kotlin.databinding.NoteLayoutBinding
import com.mekedi_mkt.notes_app_kotlin.model.entities.Note
import com.mekedi_mkt.notes_app_kotlin.view.fragments.HomeFragmentDirections

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemBinding: NoteLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.title == newItem.title &&
                    oldItem.description == newItem.description
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote= differ.currentList[position]

        holder.itemBinding.noteTitle.text = currentNote.title
        holder.itemBinding.noteDesc.text = currentNote.description

        holder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(currentNote)
            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}