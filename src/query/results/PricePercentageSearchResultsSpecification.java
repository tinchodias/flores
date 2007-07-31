package query.results;


import message.MessageId;
import model.money.Pesos;
import model.price.SimplePercentagePriceStrategy;
import model.stock.Article;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class PricePercentageSearchResultsSpecification extends LazySearchResultsSpecification {

	public PricePercentageSearchResultsSpecification() {
		add(MessageId.code);
		add(MessageId.name);
		add(MessageId.articleGroup);
		add(MessageId.articleCost, Pesos.class);
		add(MessageId.priceMargin, Double.class);
		add(MessageId.unitPrice, Pesos.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Article article = (Article) object;
		switch (columnIndex) {
		case 0:
			return article.getCode();
		case 1:
			return article.toString();
		case 2:
			return article.getGroup();
		case 3:
			return ModelPersistence.instance().loadedModel().store().stock().cost(article);
		case 4:
			return ((SimplePercentagePriceStrategy) ModelPersistence.instance().loadedModel().store().priceStrategy()).getPriceMargin(article);
		case 5:
			return ModelPersistence.instance().loadedModel().store().priceStrategy().priceFor(article);
		}
		return null;
	}

}
