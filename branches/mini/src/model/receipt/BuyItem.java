package model.receipt;

import message.MessageId;
import model.money.MoneyAmount;
import model.stock.Article;
import validation.ModelValidation;

public class BuyItem {
	private double count;
	private MoneyAmount value;
	private final Article article;

	public BuyItem(Article article, double count, MoneyAmount value) {
		ModelValidation.instance().assertNotNull(article, MessageId.article);
		this.article = article;

		ModelValidation.instance().assertPositive(count, MessageId.count);
		this.count = count;
		
		this.setValue(value);
	}

	public double getCount() {
		return count;
	}

	public MoneyAmount getValue() {
		return value;
	}

	public Article getArticle() {
		return article;
	}

	public void setValue(MoneyAmount value) {
		ModelValidation.instance().assertNotNegative(value.value(), MessageId.unitCost);
		this.value = value;
	}
	
}