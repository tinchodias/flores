package query.implementation.natives;

import java.util.Collection;

import model.JuridicPerson;
import model.receipt.Buy;
import model.stock.Article;
import model.stock.StockDropOut;

import org.apache.commons.lang.StringUtils;

import persistence.Model;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.criteria.BuySearchCriteria;
import query.criteria.ClientSearchCriteria;
import query.criteria.StockArticleSearchCriteria;
import query.criteria.StockDropOutSearchCriteria;
import query.framework.criteria.Criteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResults;
import query.framework.results.SearchResults;
import query.results.BuySearchResultsSpecification;
import query.results.ClientSearchResultsSpecification;
import query.results.StockArticleSearchResultsSpecification;
import query.results.StockDropOutSearchResultsSpecification;

public class NativeQueryFactory extends QueryFactory {

	public SearchQuery clientSearchQuery() {
		
		SearchQuery query = new SearchQuery() {
			
			private ClientSearchCriteria criteria;

			public void setCriteria(Criteria criteria) {
				this.criteria = (ClientSearchCriteria) criteria;
			}

			public SearchResults results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<JuridicPerson> clients = model.store().clients();
				
				//TODO Usar singleton en spec
				LazySearchResults results = 
					new LazySearchResults(new ClientSearchResultsSpecification());
				
				for (JuridicPerson client : clients) {
					if (StringUtils.containsIgnoreCase(client.getName(), criteria.getClientName())) {
						results.add(client);
					}
				}
				return results;
			}
		};
		
		return query;
	}

	public SearchQuery stockArticleSearchQuery() {
		
		SearchQuery query = new SearchQuery() {
			
			private StockArticleSearchCriteria criteria;
			
			public void setCriteria(Criteria criteria) {
				this.criteria = (StockArticleSearchCriteria) criteria; 
			}
			
			public SearchResults results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<Article> articles = model.store().stockArticles();

				//TODO Usar singleton en spec
				LazySearchResults results = 
					new LazySearchResults(new StockArticleSearchResultsSpecification());
				
				for (Article article : articles) {
					if (StringUtils.containsIgnoreCase(article.getDescription(), criteria.getDescription())) {
						results.add(article);
					}
				}
				return results;
			}
		};
		
		return query;
	}

	public SearchQuery stockDropOutSearchQuery() {
		SearchQuery query = new SearchQuery() {
			
			private StockDropOutSearchCriteria criteria;
			
			public void setCriteria(Criteria criteria) {
				this.criteria = (StockDropOutSearchCriteria) criteria; 
			}
			
			public SearchResults results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<StockDropOut> dropOuts = model.store().stock().dropOuts();

				//TODO Usar singleton en spec
				LazySearchResults results = 
					new LazySearchResults(new StockDropOutSearchResultsSpecification());
				
				for (StockDropOut dropOut : dropOuts) {
					if (criteria.getInterval().contains(dropOut.getDate())) {
						results.add(dropOut);
					}
				}
				return results;
			}
		};
		
		return query;
	}

	public SearchQuery buySearchQuery() {

		SearchQuery query = new SearchQuery() {
			
			private BuySearchCriteria criteria;
			
			public void setCriteria(Criteria criteria) {
				this.criteria = (BuySearchCriteria) criteria; 
			}
			
			public SearchResults results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<Buy> buys = model.store().buys();

				LazySearchResults results = 
					new LazySearchResults(new BuySearchResultsSpecification());
				
				for (Buy buy : buys) {
					if (criteria.getInterval().contains(buy.date())) {
						results.add(buy);
					}
				}
				return results;
			}
		};
		
		return query;	
	}

}
