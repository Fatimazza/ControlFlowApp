package id.co.iconpln.controlflowapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_user_table")
data class FavoriteUser(

    @PrimaryKey(autoGenerate = true)
    var favUserId: Long = 0L,

    @ColumnInfo(name = "userAddress")
    var userAddress: String = "",

    @ColumnInfo(name = "userId")
    var userId: String = "",

    @ColumnInfo(name = "userName")
    var userName: String = "",

    @ColumnInfo(name = "userPhone")
    var userPhone: String = ""
)
