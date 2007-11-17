package query.results;


import java.util.Map;

import message.MessageId;
import model.money.MoneyAmount;
import model.stock.Article;
import model.util.Percentage;
import query.framework.query.StockAnalysisSearchQuery.ArticleCalculation;
import query.framework.results.LazySearchResultsSpecification;

public class StockAnalysisResultsSpecification extends LazySearchResultsSpecification {

	private final Map<Article, ArticleCalculation> calculations;

	public StockAnalysisResultsSpecification(Map<Article, ArticleCalculation> calculations) {
		add(MessageId.article);
		add(MessageId.sellCount);
		add(MessageId.gainTotal);
		add(MessageId.gainAverage);
		add(MessageId.marginAverage);
		add(MessageId.dropOutsTotal);
		
		this.calculations = calculations;
	}

	public Object value(Object object, int columnIndex) {
		Article article = (Article) object;
		ArticleCalculation calculation = calculations.get(article);
		int sellCount = calculation.sellCount();
		
		switch (columnIndex) {
		case 0:
			return article;
		case 1:
			return sellCount;
		case 2:
			return calculation.sellValueTotal().minus(calculation.costValueTotal());
		case 3:
			return (sellCount == 0) ? "-" :
				calculation.sellValueTotal().minus(calculation.costValueTotal()).dividedBy(Double.valueOf(sellCount));
		case 4:
			return (calculation.costValueTotal().equals(MoneyAmount.zero())) ? "-" : 
				Percentage.newFor(calculation.sellValueTotal().dividedBy(calculation.costValueTotal()) - 1);
		case 5:
			return calculation.dropOutCostTotal();
		}
		return null;
	}
	
}
