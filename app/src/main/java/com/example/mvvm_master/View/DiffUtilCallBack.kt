package com.example.mvvm_master.View

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvm_master.Model.Result

class DiffUtilCallBack: DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.title == newItem.title
                && oldItem.id == newItem.id
                && oldItem.genreIds == newItem.genreIds
    }

}
