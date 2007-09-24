package query.results;


import message.MessageId;
import model.money.MoneyAmount;
import model.price.SimplePercentagePriceStrategy;
import model.stock.Article;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class PricePercentageSearchResultsSpecification extends LazySearchResultsSpecification {

	public PricePercentageSearchResultsSpecification() {
		add(MessageId.name);
		add(MessageId.articleGroup);
		add(MessageId.articleCost, MoneyAmount.class);
		add(MessageId.priceMargin, Double.class);
		add(MessageId.unitPrice, MoneyAmount.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Article article = (Article) object;
		switch (columnIndex) {
		case 0:
			return article.toString();
		case 1:
			return article.getGroup();
		case 2:
			return ModelPersistence.instance().loadedModel().store().stock().cost(article);
		case 3:
			return ((SimplePercentagePriceStrategy) ModelPersistence.instance().loadedModel().store().priceStrategy()).getPriceMargin(article);
		case 4:
			return ModelPersistence.instance().loadedModel().store().priceStrategy().priceFor(article);
		}
		return null;
	}

}
