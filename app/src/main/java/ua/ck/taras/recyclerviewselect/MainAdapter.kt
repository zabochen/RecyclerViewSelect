package ua.ck.taras.recyclerviewselect

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_item_user.view.*

// Example:
// https://stackoverflow.com/questions/36369913/how-to-implement-multi-select-in-recyclerview

class MainAdapter(
  private val userList: List<String>
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val selectedItemPositionList = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_item_user, parent, false
        ))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return if(userList.isNotEmpty()) userList.size else 0
    }

    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(user: String){
            itemView.apply {
                adapterItemUser_textView_userName.text = user

                if(!selectedItemPositionList.contains(adapterPosition)){
                    adapterItemUser_linearLayout_parent.setBackgroundColor(Color.WHITE)
                } else {
                    adapterItemUser_linearLayout_parent.setBackgroundColor(Color.BLUE)
                }
            }

            itemView.setOnClickListener {

                Log.i("MainAdapter", "Size: ${selectedItemPositionList.size}")

                if(!selectedItemPositionList.contains(adapterPosition)){
                    selectedItemPositionList.add(adapterPosition)
                    itemView.adapterItemUser_linearLayout_parent.setBackgroundColor(Color.BLUE)
                } else {
                    selectedItemPositionList.remove(adapterPosition)
                    itemView.adapterItemUser_linearLayout_parent.setBackgroundColor(Color.WHITE)
                }
            }
        }
    }
}