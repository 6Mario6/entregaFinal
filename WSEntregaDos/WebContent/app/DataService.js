angularFormsApp.service('Usuarios', function($http) {
	this.guardarUsuario = function(idUsuario,nombre,apellido, telefono,email,username,password,grupo) {
		alert("ECORP"+idUsuario+nombre+ apellido+telefono+email+username+password+grupo);
		return $http({
			method : 'POST',
			url : 'http://localhost:8080/WSEntregaDos//rest/usuario/guardar',
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
});