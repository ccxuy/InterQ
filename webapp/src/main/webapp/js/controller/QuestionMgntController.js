app.controller('QuestionMgntController', ['$scope', '$http', function($scope, $http) {
  var self = this; 
  this.questionTitle = 'PHP is the best programming language in the world!!'; 
  this.categories = [{'name':'Loading...', 'count':0}];
  this.curCategoryQuestions = [{'name':'Ruby is the best programming language in the world', 'date':'May 14, 2015'},
    {'name':'Scala is the best programming language in the world', 'date':'May 14, 2015'},
    {'name':'C is the best programming language in the world', 'date':'May 14, 2015'},
    {'name':'Python is the best programming language in the world', 'date':'May 14, 2015'},
    {'name':'PHP is the best programming language in the world', 'date':'May 14, 2015'},
    {'name':'Lua is the best programming language in the world', 'date':'May 14, 2015'},
    {'name':'Haskell is the best programming language in the world', 'date':'May 14, 2015'}
  ];

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

  this.editCategoryName = function editCategoryName(category) {
    category.nameEditable = true;
  };

  // Submit the category data of category name to server.
  this.submitNewCategory = function submitNewCategory() {
    console.log("submitNewCategory:"+$scope.addCategoryName);
    $http.put('./api/category/', {name:$scope.addCategoryName}).
      success(function(data, status, headers, config) {
        // self.categories = data;
        self.loadCategory();
        $scope.addCategoryName = null;
      }).
      error(function(data, status, headers, config) {
        self.categories.push({'name':'<Category name not acceptted by server>.', 'count':0});
        // log error
      });
  };

  // Update the current category.
  this.submitEditCategoryName = function submitEditCategoryName(category) {
    console.log("submitEditCategoryName:"+self.curCategory);
    category.nameEditable = false;
    $http.post('./api/category/', self.curCategory).
      success(function(data, status, headers, config) {
        self.loadCategory();
      }).
      error(function(data, status, headers, config) {
        alert('Unable to update category name.');
        // log error
      });
  };

  // Delete the current category.
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

  // Load category list from sever.
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