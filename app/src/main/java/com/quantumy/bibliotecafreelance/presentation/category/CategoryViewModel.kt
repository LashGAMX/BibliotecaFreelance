package com.quantumy.bibliotecafreelance.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.quantumy.bibliotecafreelance.presentation.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CategoryViewModel : ViewModel() {

    private val _category = MutableStateFlow<List<Category>>(emptyList())
    val category: StateFlow<List<Category>> = _category

    private val db: FirebaseFirestore = Firebase.firestore

    /**
     * Función pública para actualizar la lista de categorías.
     * Si categoryName es null, trae todas las categorías.
     */
    fun getCategories(categoryName: String? = null) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getAllCategories(categoryName)
            }
            _category.value = result
        }
    }

    private suspend fun getAllCategories(categoryName: String? = null): List<Category> {
        return try {
            val query = if (!categoryName.isNullOrEmpty()) {
                db.collection("resource")
                    .whereEqualTo("category", categoryName)
            } else {
                db.collection("resource")
            }

            query.get().await().documents.mapNotNull { snapshot ->
                snapshot.toObject(Category::class.java)
            }
        } catch (e: Exception) {
            Log.e("CategoryViewModel", "Error al obtener categorías", e)
            emptyList()
        }
    }
}