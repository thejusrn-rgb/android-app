import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MarketDataWidget(spyPrice: String, spyChange: Double, qqqPrice: String, qqqChange: Double) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Market Index Tracking", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                IndexItem("SPY", spyPrice, spyChange)
                IndexItem("QQQ", qqqPrice, qqqChange)
            }
        }
    }
}

@Composable
fun IndexItem(ticker: String, price: String, change: Double) {
    Column {
        Text(ticker, style = MaterialTheme.typography.bodySmall)
        Text(price, style = MaterialTheme.typography.bodyLarge)
        Text(
            text = if (change >= 0) "+$change%" else "$change%",
            color = if (change >= 0) Color(0xFF2E7D32) else Color.Red,
            style = MaterialTheme.typography.bodySmall
        )
    }
}