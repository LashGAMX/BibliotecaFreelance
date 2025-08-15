package com.quantumy.bibliotecafreelance.presentation.category

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.quantumy.bibliotecafreelance.presentation.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CategoryViewModel: ViewModel() {

    private  val _category = MutableStateFlow<List <Category>>(emptyList())
    private var db: FirebaseFirestore = Firebase.firestore

    val category: StateFlow<List<Category>> = _category

    init {
        db = Firebase.firestore
        getCategories()
    }

    fun getCategories(){
        viewModelScope.launch {
            val result: List<Category> = withContext(Dispatchers.IO){
                getAllCategories()
            }
            _category.value = result
        }
    }
     private suspend fun getAllCategories(): List<Category>{
         return try {
             db.collection("resource").get().await().documents.mapNotNull { snapshot ->
                 snapshot.toObject(Category::class.java)
             }
         } catch (e: Exception){
            Log.i("Resoruces",e.toString())
             emptyList()
         }
     }

}