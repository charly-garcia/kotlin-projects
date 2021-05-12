package com.example.androidsample

//import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidsample.databinding.ActivityMainBinding
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val android_id =
            Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID)
        Log.i("identifier", "ID: $android_id")

        binding.textView.text = viewModel.getResult().toString()

        binding.button.setOnClickListener {
            if (binding.dollarText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollarText.text.toString())
                binding.textView.text = viewModel.getResult().toString()
            } else {
                binding.textView.text = "No Value"
            }

            var list: List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
            list.toObservable()
                .subscribeBy(  // named arguments for lambda Subscribers
                    onNext = { println(it) },
                    onError = { it.printStackTrace() },
                    onComplete = { println("Done2!") }
                )
        }

        //var list: List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f) // 1
        //var observable: Observable<Any> = list.toObservable()
        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        list.toObservable() // extension function for Iterables
            .filter { it.length >= 5 }
            .subscribeBy(  // named arguments for lambda Subscribers
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("Done!") }
            )
    }

    fun convertCurrency(view: View) {
        /*if (dollarText.text.isNotEmpty()) {
            val dollarValue = dollarText.text.toString().toFloat()
            val euroValue = dollarValue * 0.85f
            textView.text = euroValue.toString()
        } else {
            textView.text = getString(R.string.no_value_string)
        }*/
        if (binding.dollarText.text.isNotEmpty()) {
            val dollarValue = binding.dollarText.text.toString().toFloat()
            val euroValue = dollarValue * 0.85f
            binding.textView.text = euroValue.toString()
        } else {
            binding.textView.text = getString(R.string.no_value_string)
        }

    }
}