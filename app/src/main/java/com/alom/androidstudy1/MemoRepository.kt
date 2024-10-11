package com.alom.androidstudy1

interface MemoRepository {
    //메모를 가져오는 추상함수와 메모를 설정하는 추상함수 설정
    fun getMemo():String
    fun setMemo(input:String):Unit
}
