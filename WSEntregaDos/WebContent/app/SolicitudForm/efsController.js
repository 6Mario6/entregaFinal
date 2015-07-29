
angularFormsApp.controller("efsController",
		 ["$scope", "$window", "$routeParams", "DataService",
		  function efsController($scope, $window, $routeParams, DataService) {
	         $scope.submitSolicitudForm = function () {
	             $scope.$broadcast('show-errors-event');

	             if ($scope.solicitudForm.$invalid)
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
	     		    	$window.alert("Se ingreso la solicitud correctamente ");
	     		            $scope.$broadcast('hide-errors-event');
	     		            $window.history.back();
	     						});
	             
	         };
	         $scope.cancelSolicitudForm = function () {
	             $window.history.back();
	         };

	         $scope.resetSolicitudForm= function () {
	             $scope.$broadcast('hide-errors-event');
	         };

	     }]);
