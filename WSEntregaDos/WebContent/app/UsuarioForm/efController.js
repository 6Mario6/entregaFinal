
angularFormsApp.controller('efController',
		 ["$scope", "$window", "$routeParams", "Usuarios",
    function efController($scope, $window, $routeParams, Usuarios) {

        $scope.submitForm = function () {

            $scope.$broadcast('show-errors-event');

            if ($scope.usuarioForm.$invalid)
                return;
            alert("Hello Friend!!")
            Usuarios.guardarUsuario($scope.usuario.idUsuario, $scope.usuario.nombre,
    				$scope.usuario.apellido, $scope.usuario.telefono,
    				$scope.usuario.email,
    				$scope.usuario.username,
    				$scope.usuario.password,
    				$scope.usuario.grupo
    				).success(
    						function(data) {
    							
    							$location.url('../rest/usuario/guardar');
    						});
            
        };

        $scope.cancelForm = function () {
			alert("Hello Friend!!");

            $window.history.back();
        };

        $scope.resetForm = function () {
			alert("Hello Friend!!");

            $scope.$broadcast('hide-errors-event');
        };

    }]);
