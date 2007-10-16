package model.stock;

import message.MessageId;
import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;


public class StockDropOut {

	private final Article article;
	private final double count;
	private final BaseDateTime date;
	private final String note;
	private final MoneyAmount unitCost;

	public StockDropOut(Article article, double count, BaseDateTime date, String note, MoneyAmount unitCost) {
		ModelValidation.instance().assertNotNull(article, MessageId.article);
		this.article = article;
		
		ModelValidation.instance().assertPositive(count, MessageId.count);
		this.count = count;

		ModelValidation.instance().assertNotBlank(note, MessageId.note);
		this.note = note;

		this.date = date;
		this.unitCost = unitCost;
	}

	public Article getArticle() {
		return article;
	}

	public double getCount() {
		return count;
	}

	public BaseDateTime getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}

	public MoneyAmount getUnitCost() {
		return unitCost;
	}

}
