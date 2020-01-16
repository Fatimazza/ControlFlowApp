package id.co.iconpln.controlflowapp.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FavoriteDatabaseRepository
    private val allFavoriteUsers: LiveData<List<FavoriteUser>>

    init {
        val favDatabaseDao = FavoriteDatabase.getInstance(application).favoriteDatabaseDao
        repository = FavoriteDatabaseRepository(favDatabaseDao)
        allFavoriteUsers = repository.allFavUsers
    }

    fun getAllFavoriteUsers(): LiveData<List<FavoriteUser>> {
        return allFavoriteUsers
    }

    fun insertUser(user: FavoriteUser) {
        GlobalScope.launch {
            repository.insertUser(user)
            Log.d("Izza", "User ${user.userName} ${user.userId} - - INSERTED")
        }
    }

    fun deleteUser(userId: Int) {
        GlobalScope.launch {
            repository.deleteUser(userId)
            Log.d("Izza", "User $userId - - DELETED")
        }
    }

    fun getUser(id: Int): LiveData<FavoriteUser> {
        return repository.getUser(id)
    }

}
