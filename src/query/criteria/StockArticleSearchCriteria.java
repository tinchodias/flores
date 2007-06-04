package query.criteria;

import model.stock.ArticleGroup;
import query.framework.criteria.Criteria;

public interface StockArticleSearchCriteria extends Criteria {
	
	public String getCode();

	public String getDescription();

	public ArticleGroup getGroup();

}
