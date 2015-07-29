
angularFormsApp.controller('efsController',
		 ["$scope", "$window", "$routeParams", "DataService",
    function efsController($scope, $window, $routeParams, DataService) {
alert("Controlador efsController");
        $scope.submitForm = function () {

            $scope.$broadcast('show-errors-event');

            if ($scope.solicituForm.$invalid)
                return;
			alert("Se  "+$scope.solicitud.horasolicitudinicio);

            DataService.guardarSolicitud($scope.solicitud.idReservacion,
            		$scope.solicitud.idDispositivo,
            		$scope.solicitud.idUsuarioPrestamo,
            		$scope.solicitud.idAdministrador,
            		$scope.solicitud.fechasolicitudinicio,
            		$scope.solicitud.horasolicitudinicio,
            		$scope.solicitud.estadosolicitud
    				).success(
    						function(data) {
    		    	$window.alert("Se ingreso la solicitud correctamente ");
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
