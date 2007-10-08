package message;

public enum MessageId {
	//Main
	mainTitle, 

	//Persistence
	persistenceInvalidModel, 
	persistenceInvalidState,

	//Security
	securityInvalidLogin, 

	//Login
	loginDialogTitle, 
	userName, 
	userPassword, 

	//Client
	clients, 
	client, 
	clientName, 
	clientDebt, 

	//Stock
	stockDialogTitle, 
	article, 
	unitCost,
	code, 
	size,
	insufficientStock, 
	stockCount, 
	
	//ArticleGroup
	articleGroups, 
	articleGroup, 

	//Buy
	buys, 
	supplier, 
	paymentTotal, 
	buy,
	buyItem, 
	priceMargin, 

	//Stock Drop Out
	stockDropOuts, 
	stockDropOutDialogTitle,
	
	pricesDialogTitle,
	modifyPercentage, 
	
	searchFiltersTitle,
	searchPanelButtons, 

	objectPickerButton, 

	//Generic
	invalidSelection, 
	modify, 
	create,
	remove, 
	close,
	accept,
	search,
	date,
	count, 
	select,
	fromDate,
	toDate, 
	unitPrice, 
	amount, 
	name, 
	show, 
	cashPay, 
	total, 
	reason, 
	view,
	print,
	note, 
	calculate, 
	acceptAndContinue, 
	acceptAndPrint, 
	moneyAmount, 
	itemCount, 

	//Address
	city, 
	address, 
	cities, 
	province, 
	mainAddress, 
	
	//Supplier
	suppliers, 
	supplierName, 
	supplierDialogTitle, 
	
	adjustTotal, 
	adjustedTotal, 
	
	//Sell
	sells, 
	sell, 
	costTotal, 
	sellTotal, 
	sellItem, 
	sellToString, 
	
	//CashBook
	cashBook, 
	currentCash, 
	
	//Expenses
	expensesArticles, 
	expenseArticle, 
	expenses,
	expense, 
	
	//Cash Extractions
	cashExtractions, 
	cashExtraction, 
	
	//Client Debt Cancellations
	clientDebtCancellations, 
	clientDebtCancellation, 
	clientDebtCancellationToString,
	
	//Lost Debt Declarations
	lostDebtDeclarationToString,
	
	//Commissions
	commissionCalculation, 
	commissionSummary, 
	createCommissionCashExtraction, 
	
	//ModelValidation
	assertNotBlank, 
	assertNotNull, 
	assertPositive, 
	assertNotNegative, 
	
	//Client Movements
	clientMovements, 
	clientMovement, 
	
	;
	
}
