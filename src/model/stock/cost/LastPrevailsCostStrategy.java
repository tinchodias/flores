package model.stock.cost;

import java.util.Map;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.stock.Article;
import model.stock.Stock;
import model.stock.StockDropOut;
import model.util.CollectionFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LastPrevailsCostStrategy implements CostStrategy {

	private Map<Article, Pesos> costs = CollectionFactory.newMap();
	private Stock stock;
	
	public LastPrevailsCostStrategy(Stock stock) {
		this.stock = stock;
	}

	public Pesos cost(Article article) {
		Pesos pesos = costs.get(article);
		return pesos != null ? pesos : Pesos.newFor(0.0);
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void notify(Buy buy) {
		for (Article article : buy.items().getArticles()) {
			Pesos inputCost = buy.items().getValue(article);
			costs.put(article, inputCost);
		}
	}

	public void notify(BuyAnnulment annulment) {
		//TODO
		throw new NotImplementedException();
	}

	public void notify(Sell sell) {
		//Do nothing on Sell
	}

	public void notify(SellAnnulment annulment) {
		//Do nothing on SellAnnulment
	}

	public void notify(StockDropOut dropOut) {
		//Do nothing on StockDropOut
	}

}
