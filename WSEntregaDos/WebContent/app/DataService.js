angularFormsApp.service('DataService', function($http) {
	/*this.guardarUsuario = function(idUsuario,nombre,apellido, telefono,email,username,password,grupo) {
		return $http({
			method : 'POST',	
			url : '../WSEntregaDos/rest/usuario/guardar',
			params : {
				idUsuario : idUsuario,
				nombre : nombre,
				apellido : apellido,
				telefono : telefono,
				email : email,
				username : username,
				password : password,
				grupoInvestigacion : grupo,
			}
		});

	};*/
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
