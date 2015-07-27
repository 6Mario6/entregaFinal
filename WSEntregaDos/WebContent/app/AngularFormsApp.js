
var angularFormsApp = angular.module('angularFormsApp', ["ngRoute", "ui.bootstrap"]);

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
        .otherwise({
            redirectTo: "/home"
        });
});

angularFormsApp.controller("HomeController",
    function ($scope, $location, DataService) {
        $scope.showCreateUsuarioForm = function () {
            $location.path('/newUsuarioForm');
        };
    });

app.service('Usuarios', function($http) {
	this.guardarUsuario = function(idUsuario,nombre,apellido, telefono,email,username,password,grupo) {
		return $http({
			method : 'POST',
			url : '../rest/usuario/guardar',
			params : {
				idUsuario : idUsuario,
				nombre : nombre,
				apellido : apellido,
				telefono : telefono,
				email : email,
				username : username,
				password : password,
				grupo : grupo,
			}
		});

	};
});
angularFormsApp.controller('efController',
    function efController($scope, $window, $routeParams, Usuarios) {

        $scope.submitForm = function () {

            $scope.$broadcast('show-errors-event');

            if ($scope.usuarioForm.$invalid)
                return;
            
            Usuarios.guardarUsuario($scope.usuario.idUsuario, $scope.usuario.nombre,
    				$scope.usuario.apellido, $scope.usuario.telefono,
    				$scope.usuario.email,
    				$scope.usuario.username,
    				$scope.usuario.password,
    				$scope.usuario.grupo
    				).success(
    						function(data) {
    							$location.url('/guardar');
    						});
            
        };

        $scope.cancelForm = function () {
        
            $window.history.back();
        };

        $scope.resetForm = function () {
        
            $scope.$broadcast('hide-errors-event');
        };

    });



