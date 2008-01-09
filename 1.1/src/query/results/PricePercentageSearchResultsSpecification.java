package query.results;


import message.MessageId;
import model.price.SimplePercentagePriceStrategy;
import model.stock.Article;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class PricePercentageSearchResultsSpecification extends LazySearchResultsSpecification {

	public PricePercentageSearchResultsSpecification() {
		add(MessageId.name);
		add(MessageId.articleGroup);
		add(MessageId.unitCost);
		add(MessageId.priceMargin);
		add(MessageId.unitPrice);
	}
	
	public Object value(Object object, int columnIndex) {
		Article article = (Article) object;
		switch (columnIndex) {
		case 0:
			return article;
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
