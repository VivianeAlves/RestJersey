var app = angular.module('testeapp', []);
app.controller('MainCtrl', function ($scope) {
    $scope.names = ['Adam', 'Steve', 'George', 'James', 'Armin'];
    console.log($scope.names);

});