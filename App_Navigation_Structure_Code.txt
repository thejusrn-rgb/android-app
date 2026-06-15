import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf("login") }

    Surface(modifier = Modifier.fillMaxSize()) {
        when (currentScreen) {
            "login" -> LoginScreen(onLoginSuccess = { currentScreen = "home" })
            "home" -> HomeScreen(onLogout = { currentScreen = "login" })
        }
    }
}