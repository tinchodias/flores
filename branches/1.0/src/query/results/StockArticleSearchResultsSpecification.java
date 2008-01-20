package query.results;


import message.MessageId;
import model.stock.Article;
import persistence.ModelPersistence;
import query.framework.results.LazySearchResultsSpecification;

public class StockArticleSearchResultsSpecification extends LazySearchResultsSpecification {

	public StockArticleSearchResultsSpecification() {
		add(MessageId.article);
		add(MessageId.articleGroup);
		add(MessageId.count);
//		add(MessageId.unitCost, MoneyAmount.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Article article = (Article) object;
		switch (columnIndex) {
		case 0:
			return article;
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
