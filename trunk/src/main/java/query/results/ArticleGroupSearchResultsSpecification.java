package query.results;


import message.MessageId;
import model.stock.ArticleGroup;
import query.framework.results.LazySearchResultsSpecification;

public class ArticleGroupSearchResultsSpecification extends LazySearchResultsSpecification {

	public ArticleGroupSearchResultsSpecification() {
		add(MessageId.name);
	}
	
	public Object value(Object object, int columnIndex) {
		ArticleGroup articleGroup = (ArticleGroup) object;
		switch (columnIndex) {
		case 0:
			return articleGroup.getName();
		}
		return null;
	}

}
