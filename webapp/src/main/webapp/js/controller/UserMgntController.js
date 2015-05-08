app.controller('UserMgntController', ['$scope', '$http', function($scope, $http) {
  var self = this; 
  this.loginUserName = 'loading..'; 

  // Load user name from sever.
  this.loadUsername = function loadUsername() {
    $http.get('./api/user/name/').
      success(function(data, status, headers, config) {
        self.loginUserName = data;
      }).
      error(function(data, status, headers, config) {
        self.loginUserName = '<Unknown user>.';
        // log error
      });
  };

  this.uiInit = function uiInit(){
    $('.menu a.user.item')
      .popup({
        on: 'click'
      })
    ;
  }

  this.loadUsername();
  this.uiInit();

}]);