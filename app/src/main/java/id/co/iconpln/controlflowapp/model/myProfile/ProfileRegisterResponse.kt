package id.co.iconpln.controlflowapp.model.myProfile

data class ProfileRegisterResponse(
    val `data`: ProfileResponse,
    val messages: List<String>,
    val status: Int,
    val success: Boolean
)
