package query.framework.query;

import message.MessageId;
import message.MessageRepository;
import model.cashBook.CashExtraction;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.expense.Expense;
import model.money.MoneyAmount;
import model.operationSummary.OperationSummary;
import model.receipt.Buy;
import model.receipt.Sell;
import model.stock.StockDropOut;
import model.util.Percentage;
import query.QueryFactory;
import query.criteria.IntervalSearchCriteria;
import query.framework.criteria.Criteria;
import query.framework.results.DefaultLazySearchResults;
import query.framework.results.SearchResults;
import query.results.OperationSummaryResultsSpecification;

public class OperationSummarySearchQuery implements SearchQuery {

	private IntervalSearchCriteria intervalCriteria;

	public SearchResults results() {
		DefaultLazySearchResults results = new DefaultLazySearchResults(new OperationSummaryResultsSpecification());
		results.add(buysSummary());
		results.add(sellsSummary());
		results.add(clientDebtCancellationsSummary());
		results.add(lostDebtDeclarationsSummary());
		results.add(expensesSummary());
		results.add(cashExtractionsSummary());
		results.add(stockDropOutSummary());
		return results;
	}

	private Object stockDropOutSummary() {
		SearchQuery query = QueryFactory.instance().stockDropOutSearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount lossTotal = MoneyAmount.zero();
		for (Object object : searchResults) {
			StockDropOut stockDropOut = (StockDropOut) object;
			lossTotal = lossTotal.plus(stockDropOut.getTotalCost());
		}
		String info = MessageRepository.instance().get(MessageId.stockDropOutsSummary, new Object[] {count, lossTotal});
		
		return new OperationSummary(StockDropOut.class, info);
	}

	private Object cashExtractionsSummary() {
		SearchQuery query = QueryFactory.instance().cashExtractionsSearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount total = MoneyAmount.zero();
		for (Object object : searchResults) {
			CashExtraction cashExtraction = (CashExtraction) object;
			total = total.plus(cashExtraction.getAmount());
		}
		String info = MessageRepository.instance().get(MessageId.cashExtractionsSummary, new Object[] {count, total});
		
		return new OperationSummary(CashExtraction.class, info);
	}

	private Object lostDebtDeclarationsSummary() {
		SearchQuery query = QueryFactory.instance().lostDebtDeclarationsSearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount total = MoneyAmount.zero();
		for (Object object : searchResults) {
			LostDebtDeclaration lostDebtDeclaration = (LostDebtDeclaration) object;
			total = total.plus(lostDebtDeclaration.getAmount());
		}
		String info = MessageRepository.instance().get(MessageId.lostDebtDeclarationsSummary, new Object[] {count, total});
		
		return new OperationSummary(LostDebtDeclaration.class, info);
	}
	
	private Object clientDebtCancellationsSummary() {
		SearchQuery query = QueryFactory.instance().clientDebtCancellationsSearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount total = MoneyAmount.zero();
		for (Object object : searchResults) {
			ClientDebtCancellation clientDebtCancellation = (ClientDebtCancellation) object;
			total = total.plus(clientDebtCancellation.getAmount());
		}
		String info = MessageRepository.instance().get(MessageId.clientDebtCancellationsSummary, new Object[] {count, total});
		
		return new OperationSummary(ClientDebtCancellation.class, info);
	}

	private Object expensesSummary() {
		SearchQuery query = QueryFactory.instance().expensesSearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount costTotal = MoneyAmount.zero();
		for (Object object : searchResults) {
			Expense expense = (Expense) object;
			costTotal = costTotal.plus(expense.getCost());
		}
		String info = MessageRepository.instance().get(MessageId.expensesSummary, new Object[] {count, costTotal});
		
		return new OperationSummary(Expense.class, info);
	}
	
	private Object buysSummary() {
		SearchQuery query = QueryFactory.instance().buySearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount buyTotal = MoneyAmount.zero();
		MoneyAmount paymentTotal = MoneyAmount.zero();
		for (Object object : searchResults) {
			Buy buy = (Buy) object;
			buyTotal = buyTotal.plus(buy.buyTotal());
			paymentTotal = paymentTotal.plus(buy.paymentTotal());
		}
		String info = MessageRepository.instance().get(MessageId.buysSummary, 
				new Object[] {count, buyTotal, paymentTotal});
		
		return new OperationSummary(Buy.class, info);
	}

	private OperationSummary sellsSummary() {
		SearchQuery query = QueryFactory.instance().sellSearchQuery();
		query.setCriteria(intervalCriteria);
		SearchResults searchResults = query.results();
		
		int count = searchResults.getRowCount();
		MoneyAmount sellTotal = MoneyAmount.zero();
		MoneyAmount costTotal = MoneyAmount.zero();
		MoneyAmount paymentTotal = MoneyAmount.zero();
		for (Object object : searchResults) {
			Sell sell = (Sell) object;
			sellTotal = sellTotal.plus(sell.sellTotal());
			costTotal = costTotal.plus(sell.costTotal());
			paymentTotal = paymentTotal.plus(sell.paymentTotal());
		}
		Object averagePricePercentage = (costTotal.value() == 0) ? "-" : 
			Percentage.newFor(sellTotal.dividedBy(costTotal) - 1);

		String info = MessageRepository.instance().get(MessageId.sellsSummary, 
				new Object[] {count, sellTotal, paymentTotal, averagePricePercentage});
		
		return new OperationSummary(Sell.class, info);
	}

	public void setCriteria(Criteria criteria) {
		this.intervalCriteria = (IntervalSearchCriteria) criteria;
	}

}
