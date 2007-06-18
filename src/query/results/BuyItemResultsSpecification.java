package query.results;


import message.MessageId;
import model.money.Pesos;
import model.receipt.BuyItem;
import query.framework.results.LazySearchResultsSpecification;

public class BuyItemResultsSpecification extends LazySearchResultsSpecification {

	public BuyItemResultsSpecification() {
		add(MessageId.article);
		add(MessageId.count, Double.class);
		add(MessageId.articleCost, Pesos.class);
	}
	
	public Object value(Object object, int columnIndex) {
		BuyItem item = (BuyItem) object;
		switch (columnIndex) {
		case 0:
			return item.getArticle();
		case 1:
			return item.getCount();
		case 2:
			return item.getValue();
		}
		return null;
	}

}
