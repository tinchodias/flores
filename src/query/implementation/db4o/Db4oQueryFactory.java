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
import org.joda.time.ReadableInterval;

import persistence.db4o.Db4oModelPersistence;
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
import query.framework.criteria.Criteria;
import query.framework.criteria.StringCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.Db4oObjectSetSearchResults;
import query.framework.results.LazySearchResults;
import query.framework.results.LazySearchResultsSpecification;
import query.framework.results.SearchResults;
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

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class Db4oQueryFactory extends QueryFactory {

	public SearchQuery clientSearchQuery() {
		return new StandardSearchQuery<JuridicPerson, ClientSearchCriteria>() {

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
		return new StandardSearchQuery<Article, StockArticleSearchCriteria>() {

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
		return new StandardSearchQuery<Article, StockArticleSearchCriteria>() {

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
		return new StandardSearchQuery<StockDropOut, StockDropOutSearchCriteria>() {

			protected boolean accepts(StockDropOut object) {
				return criteria().getInterval().contains(object.getDate());
			}

			protected Collection objects() {
				return store().stock().dropOuts();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new StockDropOutSearchResultsSpecification();
			}
		};
	}

	public SearchQuery buySearchQuery() {
		
		return new SearchQuery() {
			private BuySearchCriteria criteria;

			public SearchResults results() {

				ObjectSet objectSet = sodaQuery(criteria.getInterval());
//				ObjectSet objectSet = nativeQuery(criteria.getInterval());
				
				return new Db4oObjectSetSearchResults(new BuySearchResultsSpecification(), objectSet);
			}

			private ObjectSet nativeQuery(ReadableInterval interval) {
				final long startMillis = interval.getStartMillis();
				final long endMillis = interval.getEndMillis();
				Predicate<Buy> predicate = new Predicate<Buy>() {
					public boolean match(Buy buy) {
//						return criteria.getInterval().contains(buy.date());
						return 
							startMillis <= buy.date().getMillis() &&
							endMillis > buy.date().getMillis();
					}
				};
				return Db4oModelPersistence.instance().container().query(predicate);
			}

			private ObjectSet sodaQuery(ReadableInterval interval) {
				Query query = Db4oModelPersistence.instance().container().query();
				query.constrain(Buy.class);
				Query iMillisField = query.descend("date").descend("iMillis");
				iMillisField.constrain(interval.getStartMillis()).greater();
				iMillisField.constrain(interval.getEndMillis()).smaller();
				iMillisField.orderAscending();
				return query.execute();
			}

			public void setCriteria(Criteria criteria) {
				this.criteria = (BuySearchCriteria) criteria;
			}
		};
	}

	public SearchQuery citySearchQuery() {
		return new StandardSearchQuery<City, CitySearchCriteria>() {

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
		return new StandardSearchQuery<JuridicPerson, SupplierSearchCriteria>() {

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
		return new StandardSearchQuery<Sell, SellSearchCriteria>() {

			protected boolean accepts(Sell object) {
				return criteria().getInterval().contains(object.date());
			}

			protected Iterable objects() {
				return store().sells();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new SellSearchResultsSpecification();
			}
		};
	}
	
	public SearchQuery articleGroupSearchQuery() {
		return new StandardSearchQuery<ArticleGroup, ArticleGroupSearchCriteria>() {

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
		return new StandardSearchQuery<Object, StringCriteria>() {

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
		return new StandardSearchQuery<CashBookEntry, CashBookEntrySearchCriteria>() {

			protected boolean accepts(CashBookEntry object) {
				return criteria().getInterval().contains(object.getDate());
			}

			protected Iterable objects() {
				return store().cashBook().entries();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new CashBookEntrySearchResultsSpecification();
			}
			
		};
	}

	public SearchQuery expensesArticlesSearchQuery() {
		return new StandardSearchQuery<ExpenseArticle, ExpenseArticleSearchCriteria>() {

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
		return new StandardSearchQuery<Expense, ExpenseSearchCriteria>() {

			protected boolean accepts(Expense object) {
				return criteria().getInterval().contains(object.getDate());
			}

			protected Iterable objects() {
				return store().expenses();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new ExpenseSearchResultsSpecification();
			}
		};
	}
}
