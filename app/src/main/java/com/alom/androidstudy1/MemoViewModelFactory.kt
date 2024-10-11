package com.alom.androidstudy1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MemoViewModelFactory(private val memoRepository: MemoRepository) : ViewModelProvider.Factory {
    //ViewModel에 생성자가 있을 경우 factory를 만들어야함
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MemoViewModel::class.java)){
            return MemoViewModel(memoRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}