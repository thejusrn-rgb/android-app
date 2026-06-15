import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Path

// Data Models
data class MarketTracker(val price: Double, val change: Double)
data class MarketDataResponse(val spy: MarketTracker, val qqq: MarketTracker, val dia: MarketTracker)
data class PortfolioResponse(val totalValue: Double, val dailyChange: Double, val dailyChangePercent: Double)
data class AiAgentRequest(val agentType: String, val prompt: String)
data class AiAgentResponse(val response: String)
data class Article(val id: Int, val title: String, val url: String, val source: String)

// Retrofit API Contract
interface FinanceApiService {
    @GET("api/market-data")
    suspend fun getMarketData(): MarketDataResponse

    @GET("api/portfolio/{userId}")
    suspend fun getPortfolio(@Path("userId") userId: String): PortfolioResponse

    @POST("api/ai-agent")
    suspend fun queryAiAgent(@Body request: AiAgentRequest): AiAgentResponse

    @GET("api/articles")
    suspend fun getArticles(): List<Article>
}