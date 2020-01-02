package ua.ck.taras.recyclerviewselect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainUserAdapter = MainUserAdapter(generateUserList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initBottomButton()
    }

    private fun initRecyclerView() {
        val mainAdapter = MainAdapter(generateUserStringList())

        activityMain_recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainUserAdapter
        }
    }

    private fun initBottomButton() {
        activityMain_button.setOnClickListener {
            Log.i("MainActivity", "${mainUserAdapter.getSelectedItems()}")
        }
    }

    private fun generateUserStringList(): List<String> {
        val userList = arrayListOf<String>()
        for(i in 0..10) {
            userList.add("User_$i")
        }
        return userList
    }

    private fun generateUserList(): List<User> {
        val userList = arrayListOf<User>()
        for(i in 0..10) {
            userList.add(User(
                id = i,
                name = "User_$i",
                isSelected = false
            ))
        }
        return userList
    }
}
