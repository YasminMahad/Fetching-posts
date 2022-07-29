package com.yasmin.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yasmin.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }

    fun fetchPosts(){
        val apiClient = ApiClient.BuildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts()

        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               if (response.isSuccessful){
                   var posts = response.body()
                   Toast.makeText(baseContext, "fetched ${posts!!.size} posts", Toast.LENGTH_LONG).show()

                   var postsList=PostRvAdapter(posts)
                   binding.rvPost.layoutManager=LinearLayoutManager(baseContext)
                   binding.rvPost.adapter=postsList
               }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }


}