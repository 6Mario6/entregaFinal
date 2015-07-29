
angularFormsApp.controller('efsController',
		 ["$scope", "$window", "$routeParams", "DataSolicitudService",
    function efsController($scope, $window, $routeParams, DataSolicitudService) {
alert("Controlador efsController");
        $scope.submitSolicitudForm = function () {

            $scope.$broadcast('show-errors-event');

            if ($scope.solicituForm.$invalid)
                return;
			alert("Se  "+$scope.solicitud.horasolicitudinicio);

			DataSolicitudService.guardarSolicitud($scope.solicitud.idReservacion,
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

        $scope.cancelSolicitudForm = function () {
        	alert("Cancelo");

            $window.history.back();
        };

        $scope.resetSolicitudForm= function () {
        	alert("reset");

            $scope.$broadcast('hide-errors-event');
        };

    }]);
