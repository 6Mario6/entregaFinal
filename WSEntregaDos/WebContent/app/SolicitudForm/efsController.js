
angularFormsApp.controller('efsController',
		 ["$scope", "$window", "$routeParams", "DataService",
    function efController($scope, $window, $routeParams, DataService) {

        $scope.submitForm = function () {

            $scope.$broadcast('show-errors-event');

            if ($scope.solicituForm.$invalid)
                return;
          
            DataService.guardarSolicitud($scope.solicitud.idReservacion,
            		$scope.solicitud.idDispositivo,
            		$scope.solicitud.idUsuarioPrestamo,
            		$scope.solicitud.idAdministrador,
            		$scope.solicitud.fechasolicitudinicio,
            		$scope.solicitud.horasolicitudinicio,
            		$scope.solicitud.estadosolicitud
    				).success(
    						function(data) {
    					alert("Se ingreso solicitud correctamente ");
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
