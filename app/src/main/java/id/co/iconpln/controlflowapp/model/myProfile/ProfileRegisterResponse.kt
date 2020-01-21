package id.co.iconpln.controlflowapp.model.myProfile

data class ProfileRegisterResponse<T>(
    val `data`: ProfileResponse,
    val messages: List<String>,
    val status: Int,
    val success: Boolean
)
