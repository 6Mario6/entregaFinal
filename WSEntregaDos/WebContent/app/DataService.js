angularFormsApp.service('DataService',function($http,$filter) {
	
	this.listaDispositivos = function() {
		return $http({
			method : 'GET',
			url : '../WSEntregaDos/rest/dispositivo/obtener'
		});
	};
	
	this.guardarUsuario = function(idUsuario,nombre,apellido, telefono,email,username,password,grupo) {
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

	};
	this.guardarSolicitud = function(idReservacion,idDispositivo,idUsuarioPrestamo, idAdministrador,
			fechasolicitudinicio,horasolicitudinicio,estadosolicitud) {
		
		fechasolicitudinicio=	$filter('date')(new Date(fechasolicitudinicio), 'yyyy-MM-dd');
		horasolicitudinicio= $filter('date')(new Date(horasolicitudinicio), 'HH:mm:ss');
		
		
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
