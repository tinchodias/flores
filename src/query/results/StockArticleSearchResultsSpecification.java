package query.results;


import message.MessageId;
import model.money.Pesos;
import model.stock.Article;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class StockArticleSearchResultsSpecification extends LazySearchResultsSpecification {

	public StockArticleSearchResultsSpecification() {
		add(MessageId.articleDescription);
		add(MessageId.articleGroup);
		add(MessageId.count, Double.class);
		add(MessageId.articleCost, Pesos.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Article article = (Article) object;
		switch (columnIndex) {
		case 0:
			return article.getDescription();
		case 1:
			return article.getGroup();
		case 2:
			return ModelPersistence.instance().loadedModel().store().stock().count(article);
		case 3:
			return ModelPersistence.instance().loadedModel().store().stock().cost(article);
		}
		return null;
	}

}
