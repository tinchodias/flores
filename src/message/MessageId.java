package message;

public enum MessageId {
	mainTitle, 

	persistenceInvalidModel, 
	persistenceInvalidState,

	securityInvalidLogin, 

	loginDialogTitle, 
	userName, 
	userPassword, 
	
	clientsDialogTitle, 
	clientDialogTitle, 
	clientName, 
	clientDebt, 

	stockDialogTitle, 
	article, 
	articleCode, 
	articleDescription, 
	articleCost,
	articleGroup, 

	buysDialogTitle, 
	supplier, 
	paymentTotal, 
	buyTotal,
	
	stockDropOutsDialogTitle, 
	stockDropOutDialogTitle,
	
	searchFiltersTitle,

	objectPickerButton, 
	
	invalidSelection, 
	modify, 
	create,
	close,
	accept,
	search,
	date,
	count, 
	select,
	fromDate,
	toDate;
	
}