package id.co.iconpln.controlflowapp.model.myUser

data class DeletedUserResponse<T>(
    val deleted_user: UserDataResponse,
    val message: String
)
