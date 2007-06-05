package query.implementation.natives;

import java.util.Collection;

import model.JuridicPerson;
import model.stock.Article;
import model.stock.StockDropOut;

import org.apache.commons.lang.StringUtils;

import persistence.Model;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.criteria.ClientSearchCriteria;
import query.criteria.StockArticleSearchCriteria;
import query.criteria.StockDropOutSearchCriteria;
import query.framework.criteria.Criteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResults;
import query.framework.results.SearchResults;
import query.results.ClientSearchResultsSpecification;
import query.results.StockArticleSearchResultsSpecification;
import query.results.StockDropOutSearchResultsSpecification;

public class NativeQueryFactory extends QueryFactory {

	@Override
	public SearchQuery<JuridicPerson> clientSearchQuery() {
		
		SearchQuery<JuridicPerson> query = new SearchQuery<JuridicPerson>() {
			
			private ClientSearchCriteria criteria;

			public void setCriteria(Criteria criteria) {
				this.criteria = (ClientSearchCriteria) criteria;
			}

			public SearchResults<JuridicPerson> results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<JuridicPerson> clients = model.store().clients();
				
				//TODO Usar singleton en spec
				LazySearchResults<JuridicPerson> results = 
					new LazySearchResults<JuridicPerson>(new ClientSearchResultsSpecification());
				
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

	@Override
	public SearchQuery<Article> stockArticleSearchQuery() {
		
		SearchQuery<Article> query = new SearchQuery<Article>() {
			
			private StockArticleSearchCriteria criteria;
			
			public void setCriteria(Criteria criteria) {
				this.criteria = (StockArticleSearchCriteria) criteria; 
			}
			
			public SearchResults<Article> results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<Article> articles = model.store().stockArticles();

				//TODO Usar singleton en spec
				LazySearchResults<Article> results = 
					new LazySearchResults<Article>(new StockArticleSearchResultsSpecification());
				
				for (Article article : articles) {
					if (StringUtils.containsIgnoreCase(article.getCode(), criteria.getCode()) &&
						StringUtils.containsIgnoreCase(article.getDescription(), criteria.getDescription())) {
						results.add(article);
					}
				}
				return results;
			}
		};
		
		return query;
	}

	@Override
	public SearchQuery<StockDropOut> stockDropOutSearchQuery() {
		SearchQuery<StockDropOut> query = new SearchQuery<StockDropOut>() {
			
			private StockDropOutSearchCriteria criteria;
			
			public void setCriteria(Criteria criteria) {
				this.criteria = (StockDropOutSearchCriteria) criteria; 
			}
			
			public SearchResults<StockDropOut> results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<StockDropOut> dropOuts = model.store().stock().dropOuts();

				//TODO Usar singleton en spec
				LazySearchResults<StockDropOut> results = 
					new LazySearchResults<StockDropOut>(new StockDropOutSearchResultsSpecification());
				
				for (StockDropOut dropOut : dropOuts) {
//					if (StringUtils.containsIgnoreCase(dropOut.getArticle(), criteria.getArticle()) {
						results.add(dropOut);
//					}
				}
				return results;
			}
		};
		
		return query;
	}

}
