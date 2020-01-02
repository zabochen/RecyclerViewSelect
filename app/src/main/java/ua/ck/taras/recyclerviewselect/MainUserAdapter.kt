package ua.ck.taras.recyclerviewselect

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_item_user.view.*

class MainUserAdapter(
    userList: List<User>
) : RecyclerView.Adapter<MainUserAdapter.MainViewHolder>() {

    private val mutableUserList: MutableList<User> = userList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_item_user, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(mutableUserList[position])
    }

    override fun getItemCount(): Int {
        return if (mutableUserList.isNotEmpty()) mutableUserList.size else 0
    }

    fun getSelectedItems(): List<User>{
        return mutableUserList.filter {
            it.isSelected
        }
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.apply {
                adapterItemUser_textView_userName.text = user.name

                adapterItemUser_linearLayout_parent.apply {
                    if (user.isSelected) {
                        setBackgroundColor(Color.GRAY)
                    } else {
                        setBackgroundColor(Color.TRANSPARENT)
                    }
                }
            }

            itemView.setOnClickListener {
                mutableUserList[adapterPosition].apply {
                    isSelected = !this.isSelected
                }
                notifyItemChanged(adapterPosition)
            }
        }
    }
}