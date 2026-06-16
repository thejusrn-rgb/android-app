import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun AiAgentTerminalScreen(agentType: String, onBack: () -> Unit) {
    var userInput by remember { mutableStateOf("") }
    val chatLogs = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = if (agentType == "planner") "Financial Planner AI" else "Investment Advisor AI",
            style = MaterialTheme.typography.headlineMedium
        )
        
        // Chat History Console
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth().padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(chatLogs) { log ->
                Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                    Text(log, modifier = Modifier.padding(12.dp))
                }
            }
        }

        // Input Console Row
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                placeholder = { Text("Ask your agent an asset question...") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (userInput.isNotBlank()) {
                    chatLogs.add("You: $userInput")
                    // Logic to make API request would fire here
                    chatLogs.add("AI: Analyzing calculation vectors for optimization...")
                    userInput = ""
                }
            }) {
                Text("Run")
            }
        }
    }
}