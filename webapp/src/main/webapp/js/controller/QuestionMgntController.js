app.controller('QuestionMgntController', ['$scope', function($scope) { 
  $scope.questionTitle = 'PHP is the best programming language in the world!!'; 
}]);

app.controller('QuestionMgntController', function(){
  this.categories = [{'name':'Best of the best', 'count':213}
    , {'name':'Cat 2', 'count':213}
    , {'name':'Cat 3', 'count':213}];

  this.curCategory = this.categories[0].name

  this.catTitle = function catTitle( title ) {
    this.curCategory = title;
  };
});