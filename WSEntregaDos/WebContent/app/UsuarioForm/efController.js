
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
    					alert("Se ingreso usuario correctamente!! "+$scope.usuario.grupo);
    		            $scope.$broadcast('hide-errors-event');
    		            $window.history.back();
    						});
            
        };

        $scope.cancelForm = function () {
            $window.history.back();
        };

        $scope.resetForm = function () {
            $scope.$broadcast('hide-errors-event');
        };

    }]);
