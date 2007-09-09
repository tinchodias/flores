package query.implementation.db4o;

import java.util.Collection;

import model.JuridicPerson;
import model.address.City;
import model.cashBook.CashBookEntry;
import model.cashBook.CashExtraction;
import model.debts.ClientDebtCancellation;
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
import query.criteria.CitySearchCriteria;
import query.criteria.ClientSearchCriteria;
import query.criteria.ExpenseArticleSearchCriteria;
import query.criteria.IntervalSearchCriteria;
import query.criteria.StockArticleSearchCriteria;
import query.criteria.SupplierSearchCriteria;
import query.framework.criteria.StringCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResults;
import query.framework.results.LazySearchResultsSpecification;
import query.implementation.natives.StandardNativeSearchQuery;
import query.results.ArticleGroupSearchResultsSpecification;
import query.results.BuySearchResultsSpecification;
import query.results.CashBookEntrySearchResultsSpecification;
import query.results.CashExtractionSearchResultsSpecification;
import query.results.CitySearchResultsSpecification;
import query.results.ClientDebtCancellationSearchResultsSpecification;
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

	private static SearchQuery standardSodaIntervalQuery(final Class clazz, final LazySearchResultsSpecification spec) {
		return new StandardSodaSearchQuery<IntervalSearchCriteria>() {
			
			protected Query query() {
				return constrainInterval(queryFor(clazz), criteria().getInterval());			
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return spec;
			}
		};
	}
	
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
		return standardSodaIntervalQuery(StockDropOut.class, new StockDropOutSearchResultsSpecification());
	}

	public SearchQuery buySearchQuery() {
		return standardSodaIntervalQuery(Buy.class, new BuySearchResultsSpecification());
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
		return standardSodaIntervalQuery(Sell.class, new SellSearchResultsSpecification());
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
		return standardSodaIntervalQuery(CashBookEntry.class, new CashBookEntrySearchResultsSpecification());
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
		return standardSodaIntervalQuery(Expense.class, new ExpenseSearchResultsSpecification());
	}

	public SearchQuery cashExtractionsSearchQuery() {
		return standardSodaIntervalQuery(CashExtraction.class, new CashExtractionSearchResultsSpecification());
	}

	public SearchQuery clientDebtCancellationsSearchQuery() {
		return standardSodaIntervalQuery(ClientDebtCancellation.class, new ClientDebtCancellationSearchResultsSpecification());
	}
	
}
