package id.co.iconpln.controlflowapp.model.myProfile

data class ProfileLoginResponse(
    val customer: ProfileResponse,
    val token: String
)
