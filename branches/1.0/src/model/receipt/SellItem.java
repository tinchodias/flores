package model.receipt;

import validation.ModelValidation;
import message.MessageId;
import model.money.MoneyAmount;
import model.stock.Article;

public class SellItem {
	private final double count;
	private MoneyAmount sellValue;
	private final MoneyAmount costValue;
	private final Article article;

	public SellItem(Article article, double count, MoneyAmount sellValue, MoneyAmount costValue) {
		ModelValidation.instance().assertNotNull(article, MessageId.article);
		this.article = article;

		ModelValidation.instance().assertPositive(count, MessageId.count);
		this.count = count;
		
		this.setSellValue(sellValue);
		this.costValue = costValue;
	}

	public double getCount() {
		return count;
	}

	public MoneyAmount getCostValue() {
		return costValue;
	}

	public MoneyAmount getSellValue() {
		return sellValue;
	}

	public Article getArticle() {
		return article;
	}

	public void setSellValue(MoneyAmount sellValue) {
		ModelValidation.instance().assertNotNegative(sellValue.value(), MessageId.unitPrice);
		this.sellValue = sellValue;
	}
}