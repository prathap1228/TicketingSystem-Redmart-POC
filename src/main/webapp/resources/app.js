app = angular.module('Tickets', ['restangular']);
app.config(function(RestangularProvider) {
      RestangularProvider.setBaseUrl('http://localhost:8080/TicketingSystem');
  });
app.config(['$routeProvider',function($routeProvider) {
	
	$routeProvider.when('/login', {
		templateUrl: 'login.html',
		controller : 'loginCtrl'
	}).
	when('/dashboard', {
		templateUrl: 'dashboard.html',
		controller : 'mainCtrl'
	}).
	otherwise({
		redirectTo: '/login'
	});
	
}]);
app.controller('loginCtrl', function($scope, $location, Restangular,$rootScope) {
	
	$scope.login = function(user){
		 Restangular.all("LoginService").post(user).then(function(response){
			 alert(response);
			 $rootScope.userId = response.userId;
			 //$scope.status =  response.status;
			 if ( response.status == 'success') {
				 console.log("inside success");
				$location.path("/dashboard");
			}else{
				console.log("Username/  Password is incorrect");
			}
	});
	
	};
});
app.controller('mainCtrl', function($scope, Restangular) {
  $scope.tickets = Restangular.all('getTicketList').getList();
  console.log($scope.tickets);
  $scope.hideDashboard = false;
  $scope.hideTicketForm = true;
  $scope.commentsView = true;
  $scope.editTicket = function(ticket){
	  $scope.ticket = ticket;
	  $scope.hideDashboard = true;
	  $scope.hideTicketForm = false;
	  Restangular.all("getUser").get(ticket.ticketId).then(function(response){
		  $scope.commments = response.data.comments;
	  });
	  $scope.commentsView = false;
  }; 
  
  $scope.createTicket = function(){
	  $scope.hideDashboard = true;
	  $scope.hideTicketForm = false;
	  $scope.commentsView = true;
  }; 
  
  $scope.goToDashboard = function(){
	  $scope.hideDashboard = false;
	  $scope.hideTicketForm = true;
  }
  $scope.addOrUpdateTicket = function(ticket){
	  Restangular.all("/ticket/save").post(ticket).then(function(response){
		  
		  if(response.status=="SUCCESS"){
			  $scope.tickets = {};
			  console.log("After cleanup"+response);
		 Restangular.all('getTicketList').getList().then(function(response){
			 console.log(response);
			 $scope.tickets = response;
			  })
				  ;
			  alert("got the Response from server"+$scope.tickets);
			  $scope.hideDashboard = false;
			  $scope.hideTicketForm = true;
		  }else{
			  alert("Failed");
			  cosole.log("Unable to Add/Update");
		  }
	  })
  }
});
