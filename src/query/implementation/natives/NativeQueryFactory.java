package query.implementation.natives;

import java.util.Collection;

import model.JuridicPerson;
import model.address.City;
import model.receipt.Buy;
import model.stock.Article;
import model.stock.StockDropOut;

import org.apache.commons.lang.StringUtils;

import query.QueryFactory;
import query.criteria.BuySearchCriteria;
import query.criteria.CitySearchCriteria;
import query.criteria.ClientSearchCriteria;
import query.criteria.StockArticleSearchCriteria;
import query.criteria.StockDropOutSearchCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResultsSpecification;
import query.results.BuySearchResultsSpecification;
import query.results.CitySearchResultsSpecification;
import query.results.ClientSearchResultsSpecification;
import query.results.StockArticleSearchResultsSpecification;
import query.results.StockDropOutSearchResultsSpecification;

public class NativeQueryFactory extends QueryFactory {

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
				return StringUtils.containsIgnoreCase(object.getDescription(), criteria().getDescription());
			}

			protected Collection objects() {
				return store().stockArticles();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new StockArticleSearchResultsSpecification();
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
		return new StandardSearchQuery<Buy, BuySearchCriteria>() {

			protected boolean accepts(Buy object) {
				return criteria().getInterval().contains(object.date());
			}

			protected Collection objects() {
				return store().buys();
			}

			protected LazySearchResultsSpecification resultsSpecification() {
				return new BuySearchResultsSpecification();
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
	
}
