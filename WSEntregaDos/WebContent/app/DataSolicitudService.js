angularFormsApp.service('DataSolicitudService', function($http) {
	this.guardarSolicitud = function(idReservacion,idDispositivo,idUsuarioPrestamo, idAdministrador,
			fechasolicitudinicio,horasolicitudinicio,estadosolicitud) {
		alert(idReservacion+idDispositivo+idUsuarioPrestamo+idAdministrador+fechasolicitudinicio
				+horasolicitudinicio+estadosolicitud);
		return $http({
			method : 'POST',	
			url : '../WSEntregaDos/rest/solicitud/guardar',
			params : {
				idReservacion : idReservacion,
				idDispositivo : idDispositivo,
				idUsuarioPrestamo : idUsuarioPrestamo,
				idAdministrador : idAdministrador,
				fechasolicitudinicio : fechasolicitudinicio,
				horasolicitudinicio : horasolicitudinicio,
				estadosolicitud : estadosolicitud
			}
		});

	};
	
	
});
