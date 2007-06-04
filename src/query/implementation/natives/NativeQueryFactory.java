package query.implementation.natives;

import java.util.Collection;

import model.JuridicPerson;
import model.stock.Article;

import org.apache.commons.lang.StringUtils;

import persistence.Model;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.criteria.ClientSearchCriteria;
import query.criteria.StockArticleSearchCriteria;
import query.framework.criteria.Criteria;
import query.framework.query.SearchQuery;
import query.framework.results.LazySearchResults;
import query.framework.results.SearchResults;
import query.results.ClientSearchResultsSpecification;
import query.results.StockArticleSearchResultsSpecification;

public class NativeQueryFactory extends QueryFactory {

	@Override
	public SearchQuery<JuridicPerson> clientSearchQuery(final ClientSearchCriteria criteria) {
		
		SearchQuery<JuridicPerson> query = new SearchQuery<JuridicPerson>() {
			private LazySearchResults<JuridicPerson> results;
			
			public SearchResults<JuridicPerson> results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<JuridicPerson> clients = model.store().clients();
				
				//TODO Usar singleton en spec
				results = new LazySearchResults<JuridicPerson>(new ClientSearchResultsSpecification());
				
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
	public SearchQuery<Article> stockArticleSearchQuery(Criteria criteria) {
		
		final StockArticleSearchCriteria stockArticleSearchCriteria = (StockArticleSearchCriteria) criteria; 
		
		SearchQuery<Article> query = new SearchQuery<Article>() {
			private LazySearchResults<Article> results;
			
			public SearchResults<Article> results() {
				Model model = ModelPersistence.instance().loadedModel();
				Collection<Article> articles = model.store().stockArticles();

				//TODO Usar singleton en spec
				results = new LazySearchResults<Article>(new StockArticleSearchResultsSpecification());
				
				for (Article article : articles) {
					if (StringUtils.containsIgnoreCase(article.getCode(), stockArticleSearchCriteria.getCode()) &&
						StringUtils.containsIgnoreCase(article.getDescription(), stockArticleSearchCriteria.getDescription())) {
						results.add(article);
					}
				}
				return results;
			}
		};
		
		return query;
	}

}
