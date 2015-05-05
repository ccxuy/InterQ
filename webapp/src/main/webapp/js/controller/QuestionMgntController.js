app.controller('QuestionMgntController', ['$scope', '$http', function($scope, $http) {
  var self = this; 
  this.questionTitle = 'PHP is the best programming language in the world!!'; 
  this.categories = [{'name':'Loading...', 'count':0}];

  this.curCategory = this.categories[0];

  this.catTitle = function catTitle( title ) {
    this.curCategory = title;
  };

  this.newQuestion = function newQuestion( name ) {
    alert("new question");
  };

  this.addCategory = function addCategory() {
    $scope.editorEnabled = true;
  };

  this.addCategoryCancel = function addCategoryCancel() {
    $scope.editorEnabled = false;
    $scope.addCategoryName = null;
  };

  this.submitNewCategory = function submitNewCategory() {
    console.log("submitNewCategory:"+$scope.addCategoryName);
    $http.put('./api/category/', {name:$scope.addCategoryName}).
      success(function(data, status, headers, config) {
        // self.categories = data;
        self.loadCategory();
      }).
      error(function(data, status, headers, config) {
        self.categories.push({'name':'Unable to create new category.', 'count':0});
        // log error
      });
  };

  this.submitDeleteCategory = function submitDeleteCategory() {
    console.log("submitDeleteCategory:"+self.curCategory);
    $http.delete('./api/category/'+self.curCategory.id).
      success(function(data, status, headers, config) {
        self.loadCategory();
      }).
      error(function(data, status, headers, config) {
        self.categories.push({'name':'Unable to create new category.', 'count':0});
        // log error
      });
  };

  this.showCategory = function showCategory( name ) {
    alert("showCategory: "+name);
  };

  this.loadCategory = function loadCategory() {
    $http.get('./api/category/all/').
      success(function(data, status, headers, config) {
        self.categories = data;
      }).
      error(function(data, status, headers, config) {
        self.categories = [{'name':'Unable to load categories.', 'count':0}];
        // log error
      });
  };

  this.loadCategory();

}]);