package query.results;


import message.MessageId;
import model.money.Pesos;
import model.receipt.SellItem;
import query.framework.results.LazySearchResultsSpecification;

public class SellItemResultsSpecification extends LazySearchResultsSpecification {

	public SellItemResultsSpecification() {
		add(MessageId.article);
		add(MessageId.count, Double.class);
		add(MessageId.unitPrice, Pesos.class);
	}
	
	public Object value(Object object, int columnIndex) {
		SellItem item = (SellItem) object;
		switch (columnIndex) {
		case 0:
			return item.getArticle();
		case 1:
			return item.getCount();
		case 2:
			return item.getSellValue();
		}
		return null;
	}

}
