import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun DrivePreview(url: String) {
    AndroidView(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(top = 16.dp), // ✅ margen de 16dp alrededor
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(url) // URL de tipo https://drive.google.com/file/d/FILE_ID/preview
            }
        }
    )
}
