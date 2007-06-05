package model.stock;

import org.joda.time.ReadableDateTime;


public class StockDropOut {

	private final Article article;
	private final double count;
	private final ReadableDateTime date;
	private final String note;

	public StockDropOut(Article article, double count, ReadableDateTime date, String note) {
		this.article = article;
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
