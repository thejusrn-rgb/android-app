import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomerPortfolioCard(totalBalance: String, positiveChange: Boolean, balanceChangeDelta: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Your Net Worth", color = MaterialTheme.colorScheme.onPrimaryContainer)
            Text(
                text = totalBalance, 
                fontSize = 32.sp, 
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = if (positiveChange) "▲ $balanceChangeDelta today" else "▼ $balanceChangeDelta today",
                color = if (positiveChange) Color(0xFF1B5E20) else Color.Red,
                fontWeight = FontWeight.Medium
            )
        }
    }
}