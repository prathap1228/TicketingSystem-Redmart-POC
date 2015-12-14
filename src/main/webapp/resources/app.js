app = angular.module('Tickets', ['restangular']);
app.config(function(RestangularProvider) {
	//192.168.0.103:8080
      RestangularProvider.setBaseUrl('https://fierce-badlands-9753.herokuapp.com');
	//RestangularProvider.setBaseUrl('http://localhost:8080/TicketingSystem');
  });
app.config(['$routeProvider',function($routeProvider) {
	
	$routeProvider.when('/login', {
		templateUrl: 'resources/login.html',
		controller : 'loginCtrl'
	}).
	when('/dashboard', {
		templateUrl: 'resources/dashboard.html',
		controller : 'mainCtrl'
	}).
	otherwise({
		redirectTo: '/login'
	});
	
}]);
app.controller('loginCtrl', function($scope, $location, Restangular,$rootScope) {
	console.log("tetsing");
	$scope.login = function(user){
		console.log(user);
		 Restangular.all("login").post(user).then(function(response){
			 console.log(response);
			 //$scope.status =  response.status;
			 if (response.statusCode=="200") {
				 $rootScope.userId = response.data.employeeId;
				 $rootScope.userName = response.data.welcomeMessage;
				 console.log(response.data+$scope.userName);
				 $rootScope.assigneeList = Restangular.all("employees/all").getList();
				 console.log($scope.assigneeList);
				$location.path("/dashboard");
			}else{
				console.log("Username/  Password is incorrect");
			}
	});
	
	};
});
app.controller('mainCtrl', function($scope, Restangular,$rootScope) {
  $scope.tickets = Restangular.all('ticket/all').getList();
  console.log($scope.tickets);
  $rootScope.assigneeList = Restangular.all("employees/all").getList();
  
	 console.log($scope.assigneeList);
  $scope.hideDashboard = false;
  $scope.hideTicketForm = true;
  $scope.commentsView = true;
  $scope.editTicket = function(ticket){
	  if(ticket.status === "Closed") {
		  alert("This ticket already closed. You can't edit it.")
	  }else{
		  Restangular.all("ticket/details").get(ticket.id).then(function(response){
			  console.log('response:'+response);
			  $scope.ticket = response;
		  });
		  
		  console.log(ticket);
		  console.log('new:'+$scope.ticket);
		  //$scope.ticket = ticket;
		  $scope.hideDashboard = true;
		  $scope.hideTicketForm = false;
		  $scope.commentsView = false;
		 /* Restangular.all("getUser").get(ticket.ticketId).then(function(response){
			  $scope.commments = response.data.comments;
		  });*/
	  }
  }; 
  
  $scope.createTicket = function(){
	  $scope.ticket="";
	  $scope.hideDashboard = true;
	  $scope.hideTicketForm = false;
	  $scope.commentsView = true;
  }; 
  
  $scope.goToDashboard = function(){
	  $scope.hideDashboard = false;
	  $scope.hideTicketForm = true;
  };
  $scope.addOrUpdateTicket = function(ticket){
		  ticket.assignedTo = ticket.assignedTo.employeeId;
		  ticket.raisedBy = $scope.userId;
		  
		  var tic = {};
		  	tic.id = ticket.id;
			tic.name = ticket.name;
			tic.contactNumber = ticket.contactNumber;
			tic.emailId = ticket.emailId;
			tic.category = ticket.category;
			tic.status = ticket.status;
			//tic.loggedAt = ticket.loggedAt;
			tic.assignedTo = ticket.assignedTo; 
			tic.raisedBy = ticket.raisedBy;
			tic.comment = ticket.comment;
		  Restangular.all("ticket/save").post(tic).then(function(response){
			  if(response.statusCode=="200"){
				  $scope.tickets = {};
				  console.log("After cleanup"+response);
			 Restangular.all('ticket/all').getList().then(function(response){
				 console.log(response);
				 $scope.tickets = response;
				  })
					  ;
				  console.log("got the Response from server"+$scope.tickets);
				  $scope.hideDashboard = false;
				  $scope.hideTicketForm = true;
			  }else{
				  console.log("Failed");
				  console.log("Unable to Add/Update");
			  }
		  })
  }
});
