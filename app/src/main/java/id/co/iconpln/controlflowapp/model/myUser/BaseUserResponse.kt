package id.co.iconpln.controlflowapp.model.myUser

data class BaseUserResponse<T>(
    val count: Int,
    val data: List<Data>,
    val total: Int
)
