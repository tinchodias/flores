package query.results;


import message.MessageId;
import model.money.Pesos;
import model.stock.Article;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class StockArticleSearchResultsSpecification extends
		LazySearchResultsSpecification<Article> {

	public StockArticleSearchResultsSpecification() {
		add(MessageId.articleCode);
		add(MessageId.articleDescription);
		add(MessageId.articleCount, Double.class);
		add(MessageId.articleCost, Pesos.class);
	}
	
	public Object value(Article article, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return article.getCode();
		case 1:
			return article.getDescription();
		case 2:
			return ModelPersistence.instance().loadedModel().store().stock().count(article);
		case 3:
			return ModelPersistence.instance().loadedModel().store().stock().cost(article);
		}
		return null;
	}

}
