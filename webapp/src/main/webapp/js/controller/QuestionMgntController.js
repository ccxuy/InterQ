app.controller('QuestionMgntController', ['$scope', '$http', function($scope, $http) {
  var self = this; 
  this.questionTitle = 'PHP is the best programming language in the world!!'; 
  this.categories = [{'name':'Loading...', 'count':0}];

  this.curCategory = this.categories[0].name

  this.catTitle = function catTitle( title ) {
    this.curCategory = title;
  };

  this.newQuestion = function newQuestion( name ) {
    alert("new question");
  };

  this.addCategory = function addCategory() {
    $scope.editorEnabled = true;
  };

  this.showCategory = function showCategory( name ) {
    alert("showCategory: "+name);
  };

  $http.get('./api/category/all/').
    success(function(data, status, headers, config) {
      self.categories = data;
    }).
    error(function(data, status, headers, config) {
      self.categories = [{'name':'Unable to load categories.', 'count':0}];
      // log error
    });

}]);