package id.co.iconpln.controlflowapp.model.myUser

data class UpdatedUserResponse<T>(
    val message: String,
    val updated_user: UserDataResponse
)
