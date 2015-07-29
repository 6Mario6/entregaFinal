var angularFormsApp = angular.module("angularFormsApp", ["ngRoute", "ui.bootstrap"]);

angularFormsApp.config(function ($routeProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "app/Home.html",
            controller: "HomeController"
        })
        .when("/newUsuarioForm", {
            templateUrl: "app/UsuarioForm/efTemplate.html",
            controller: "efController"
        })
        .when("/newSolicitudForm", {
            templateUrl: "app/SolicitudForm/efsTemplate.html",
            controller: "efsController"
        })
        .otherwise({
            redirectTo: "/home"
        });
});

angularFormsApp.controller("HomeController",
    function ($scope, $location, DataService, DataSolicitudService) {
        $scope.showCreateUsuarioForm = function () {
            $location.path('/newUsuarioForm');
        };
        $scope.showCreateSolicitudForm = function () {
            $location.path('/newSolicitudForm');
        };
        
    }
);





