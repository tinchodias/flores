package query.implementation.db4o;

import java.util.Collection;

import model.CashBookEntry;
import model.JuridicPerson;
import model.address.City;
import model.expense.Expense;
import model.expense.ExpenseArticle;
import model.receipt.Buy;
import model.receipt.Sell;
import model.stock.Article;
import model.stock.ArticleGroup;
import model.stock.StockDropOut;

import org.apache.commons.lang.StringUtils;

import query.QueryFactory;
import query.criteria.ArticleGroupSearchCriteria;
import query.criteria.BuySearchCriteria;
import query.criteria.CashBookEntrySearchCriteria;
import query.criteria.CitySearchCriteria;
import query.criteria.ClientSearchCriteria;
import query.criteria.ExpenseArticleSearchCriteria;
import query.criteria.ExpenseSearchCriteria;
import query.criteria.SellSearchCriteria;
import query.criteria.StockArticleSearchCriteria;
import query.criteria.StockDropOutSearchCriteria;
import query.criteria.SupplierSearchCriteria;
import query.framework.criteria.StringCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResults;
import query.framework.results.LazySearchResultsSpecification;
import query.implementation.natives.StandardNativeSearchQuery;
import query.results.ArticleGroupSearchResultsSpecification;
import query.results.BuySearchResultsSpecification;
import query.results.CashBookEntrySearchResultsSpecification;
import query.results.CitySearchResultsSpecification;
import query.results.ClientSearchResultsSpecification;
import query.results.ExpenseArticleSearchResultsSpecification;
import query.results.ExpenseSearchResultsSpecification;
import query.results.PricePercentageSearchResultsSpecification;
import query.results.SellSearchResultsSpecification;
import query.results.StockArticleSearchResultsSpecification;
import query.results.StockDropOutSearchResultsSpecification;
import query.results.SupplierSearchResultsSpecification;

import com.db4o.query.Query;

public class Db4oQueryFactory extends QueryFactory {

	public SearchQuery clientSearchQuery() {
		return new StandardNativeSearchQuery<JuridicPerson, ClientSearchCriteria>() {

			protected boolean accepts(JuridicPerson object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getClientName());
			}

			protected Collection objects() {
				return store().clients();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new ClientSearchResultsSpecification();
			}
		};
	}

	public SearchQuery stockArticleSearchQuery() {
		return new StandardNativeSearchQuery<Article, StockArticleSearchCriteria>() {

			protected boolean accepts(Article object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getArticleName());
			}

			protected Collection objects() {
				return store().stockArticles();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new StockArticleSearchResultsSpecification();
			}
		};
	}

	public SearchQuery pricePercentageSearchQuery() {
		//Note this query shares too much with stockArticleSearchQuery()
		return new StandardNativeSearchQuery<Article, StockArticleSearchCriteria>() {

			protected boolean accepts(Article object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getArticleName());
			}

			protected Collection objects() {
				return store().stockArticles();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new PricePercentageSearchResultsSpecification();
			}
		};
	}

	public SearchQuery stockDropOutSearchQuery() {
		return new StandardSodaSearchQuery<StockDropOutSearchCriteria>() {
			
			protected Query query() {
				return constrainInterval(queryFor(StockDropOut.class), criteria().getInterval());			
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new StockDropOutSearchResultsSpecification();
			}
		};
	}

	public SearchQuery buySearchQuery() {
		return new StandardSodaSearchQuery<BuySearchCriteria>() {
			
			protected Query query() {
				return constrainInterval(queryFor(Buy.class), criteria().getInterval());			
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new BuySearchResultsSpecification();
			}
		};
	}

	public SearchQuery citySearchQuery() {
		return new StandardNativeSearchQuery<City, CitySearchCriteria>() {

			protected boolean accepts(City object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getCityName());
			}

			protected Collection objects() {
				return store().cities();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new CitySearchResultsSpecification();
			}
			
		};
	}

	public SearchQuery suppliersSearchQuery() {
		return new StandardNativeSearchQuery<JuridicPerson, SupplierSearchCriteria>() {

			protected boolean accepts(JuridicPerson object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getSupplierName());
			}

			protected Collection objects() {
				return store().suppliers();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new SupplierSearchResultsSpecification();
			}
		};
	}

	public SearchQuery sellSearchQuery() {
		return new StandardSodaSearchQuery<SellSearchCriteria>() {
			
			protected Query query() {
				return constrainInterval(queryFor(Sell.class), criteria().getInterval());			
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new SellSearchResultsSpecification();
			}
		};
	}
	
	public SearchQuery articleGroupSearchQuery() {
		return new StandardNativeSearchQuery<ArticleGroup, ArticleGroupSearchCriteria>() {

			protected boolean accepts(ArticleGroup object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getArticleGroupName());
			}

			protected Collection objects() {
				return store().stockArticleGroups();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new ArticleGroupSearchResultsSpecification();
			}
		};
	}
	
	public SearchQuery stringSearchQuery(final Iterable items) {
		return new StandardNativeSearchQuery<Object, StringCriteria>() {

			protected boolean accepts(Object object) {
				String criteriaString = StringUtils.lowerCase(criteria().getString());
				String objectString = StringUtils.lowerCase(object.toString());
				return objectString.contains(criteriaString);
			}

			protected Iterable objects() {
				return items;
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				//TODO
				return null;
			}
			
			@Override
			protected boolean mustBreakWith(LazySearchResults results) {
				return results.getRowCount() >= 15;
			}
		};
	}
	
	public SearchQuery cashBookEntrySearchQuery() {
		return new StandardSodaSearchQuery<CashBookEntrySearchCriteria>() {
			
			protected Query query() {
				return constrainInterval(queryFor(CashBookEntry.class), criteria().getInterval());			
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new CashBookEntrySearchResultsSpecification();
			}
		};
	}

	public SearchQuery expensesArticlesSearchQuery() {
		return new StandardNativeSearchQuery<ExpenseArticle, ExpenseArticleSearchCriteria>() {

			protected boolean accepts(ExpenseArticle object) {
				return StringUtils.containsIgnoreCase(object.getName(), criteria().getArticleName());
			}
			
			protected Collection objects() {
				return store().expensesArticles();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new ExpenseArticleSearchResultsSpecification();
			}
		};
	}
	
	public SearchQuery expensesSearchQuery() {
		return new StandardSodaSearchQuery<ExpenseSearchCriteria>() {
			
			protected Query query() {
				return constrainInterval(queryFor(Expense.class), criteria().getInterval());			
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new ExpenseSearchResultsSpecification();
			}
		};
	}
	
}
