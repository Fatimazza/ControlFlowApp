package id.co.iconpln.controlflowapp.database

import androidx.lifecycle.LiveData

class FavoriteDatabaseRepository(private val favDatabaseDao: FavoriteDatabaseDao) {

    val allFavUsers: LiveData<List<FavoriteUser>> = favDatabaseDao.getAllUsers()

    fun insertUser(user: FavoriteUser) {
        favDatabaseDao.insertUser(user)
    }

    fun deleteUser(id: Int) {
        favDatabaseDao.deleteUser(id)
    }

}
