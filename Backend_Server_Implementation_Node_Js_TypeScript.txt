import express, { Request, Response } from 'express';
const app = express();
app.use(express.json());

// Mock Data
const mockPortfolio = {
  totalValue: 24500.75,
  dailyChange: 340.20,
  dailyChangePercent: 1.41,
  holdings: [{ asset: "AAPL", shares: 10, value: 1800 }, { asset: "BTC", shares: 0.5, value: 22000 }]
};

const mockMarketData = {
  spy: { price: 510.40, change: 0.25 },
  qqq: { price: 438.10, change: -0.12 },
  dia: { price: 390.05, change: 0.08 }
};

// --- ROUTES ---

// 1. Market Data Endpoint
app.get('/api/market-data', (req: Request, res: Response) => {
  res.json(mockMarketData);
});

// 2. Portfolio Endpoint
app.get('/api/portfolio/:userId', (req: Request, res: Response) => {
  res.json(mockPortfolio);
});

// 3. AI Agent Logic (Mocking LLM processing for Planner & Advisor)
app.post('/api/ai-agent', (req: Request, res: Response) => {
  const { agentType, prompt } = req.body;
  
  if (agentType === "planner") {
    res.json({ response: `[Financial Planner AI]: Based on your entry "${prompt}", I recommend setting aside 20% of your current liquid assets for emergency funding.` });
  } else {
    res.json({ response: `[Investment Advisor AI]: Analyzing market data for "${prompt}". Valuation structures point towards a DCA approach into Index ETFs today.` });
  }
});

// 4. Website Articles Endpoint
app.get('/api/articles', (req: Request, res: Response) => {
  res.json([
    { id: 1, title: "How to Build a Recession-Proof Portfolio", url: "https://example-finance.com/p1", source: "FinMarket" },
    { id: 2, title: "Understanding Compound Interest in 2026", url: "https://example-finance.com/p2", source: "WealthDaily" }
  ]);
});

app.listen(3000, () => console.log('Finance Backend running on port 3000'));