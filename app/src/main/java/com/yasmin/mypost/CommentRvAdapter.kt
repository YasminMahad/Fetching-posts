package com.yasmin.mypost

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasmin.mypost.databinding.CommentListItemBinding

class CommentRvAdapter (var commentList:List<Comment>): RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding =
            CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        holder.binding.tvPost.text = currentComment.post.toString()
        holder.binding.tvCommentId.text = currentComment.id.toString()
        holder.binding.tvName.text = currentComment.name
        holder.binding.tvEmail.text = currentComment.body
        val context = holder.itemView.context
        holder.binding.cvComment.setOnClickListener{
            val intent = Intent(context,Comments::class.java)
            intent.putExtra("POST_ID", currentComment.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}

class CommentViewHolder(var binding: CommentListItemBinding): RecyclerView.ViewHolder(binding.root)