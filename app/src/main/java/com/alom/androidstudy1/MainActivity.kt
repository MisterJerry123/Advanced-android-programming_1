package com.alom.androidstudy1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var memoViewModel: MemoViewModel
    private lateinit var binding : ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("memo", MODE_PRIVATE)
        val memoRepository = MemoRepositoryImpl(sharedPreferences)

        val memoViewModelFactory = MemoViewModelFactory(memoRepository)

        memoViewModel = ViewModelProvider(this,memoViewModelFactory).get(MemoViewModel::class.java)

        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    memoViewModel.currentValue.collect{
                        binding.etMemo.setText(it)
                    }
                }
            }
        }

        binding.btnSave.setOnClickListener {
            memoViewModel.saveMemo(binding.etMemo.text.toString())
        }
    }
}