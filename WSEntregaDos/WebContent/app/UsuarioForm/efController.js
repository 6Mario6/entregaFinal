
angularFormsApp.controller('efController',
		 ["$scope", "$window", "$routeParams", "Usuarios",
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
    						//	alert("Exploit!! "+$scope.usuario.grupo);
    							$location.url('/home');
    						});
            
        };

        $scope.cancelForm = function () {
            $window.history.back();
        };

        $scope.resetForm = function () {
            $scope.$broadcast('hide-errors-event');
        };

    }]);
