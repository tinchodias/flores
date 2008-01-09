package model.stock;

import message.MessageId;

import org.joda.time.ReadableDateTime;

import validation.ModelValidation;


public class StockDropOut {

	private final Article article;
	private final double count;
	private final ReadableDateTime date;
	private final String note;

	public StockDropOut(Article article, double count, ReadableDateTime date, String note) {
		ModelValidation.instance().assertNotNull(article, MessageId.article);
		this.article = article;
		
		ModelValidation.instance().assertPositive(count, MessageId.count);
		this.count = count;
		
		this.date = date;
		this.note = note;
	}

	public StockDropOut(Article article, double count, ReadableDateTime date) {
		this(article, count, date, "");
	}

	public Article getArticle() {
		return article;
	}

	public double getCount() {
		return count;
	}

	public ReadableDateTime getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}

}
