import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(onLogout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- Top Row: Streak & Market Data ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WireframeBox(
                title = "No. of days\nstreak",
                modifier = Modifier.weight(1f).height(100.dp)
            )
            WireframeBox(
                title = "Market Data\nIndex Tracking",
                modifier = Modifier.weight(1.3f).height(100.dp)
            )
        }

        // --- Row 2: Customer Greeting ---
        WireframeBox(
            title = "Hello (Name of Customer)",
            modifier = Modifier.fillMaxWidth().height(90.dp)
        )

        // --- Row 3: Portfolio Performance ---
        WireframeBox(
            title = "Customer Portfolio Performance",
            modifier = Modifier.fillMaxWidth().height(160.dp)
        )

        // --- Row 4: AI Agents ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WireframeBox(
                title = "Financial Planner\nAI Agent",
                modifier = Modifier.weight(1f).height(90.dp)
            )
            WireframeBox(
                title = "Investment Advisor\nAI Agent",
                modifier = Modifier.weight(1f).height(90.dp)
            )
        }

        // --- Bottom Row: Website Articles ---
        WireframeBox(
            title = "website articles (opens finance website articles page)",
            modifier = Modifier.fillMaxWidth().height(60.dp),
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Quick Logout/Back to Login element for testing
        TextButton(
            onClick = onLogout,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Logout")
        }
    }
}

/**
 * A reusable UI component that mirrors the bold outline look from your wireframe.
 */
@Composable
fun WireframeBox(
    title: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface
) {
    Surface(
        modifier = modifier.border(3.dp, Color.Black, RoundedCornerShape(4.dp)),
        color = backgroundColor,
        shape = RoundedCornerShape(4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}