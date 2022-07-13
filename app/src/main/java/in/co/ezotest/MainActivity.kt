package `in`.co.ezotest

import `in`.co.ezotest.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var context: Context

    private lateinit var coroutineJob: Job
    override val coroutineContext: CoroutineContext
        get() = coroutineJob + Dispatchers.Main

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "EZO TEST"

        context = this
        coroutineJob = Job()
    }

    // SUGGESTION
    // FETCH DATA FROM API 'https://picsum.photos/v2/list?page=1&limit=200' USING RETROFIT AND FEED IT TO 'AuthorAdapter'
    // YOU CAN USE ANYTHING ELSE IF WANTED
}