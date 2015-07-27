
angularFormsApp.factory('DataService',
    function () {
        var getUsuario = function (id) {
           
            return undefined;
        };

        var insertUsuario = function (newUsuario) {
            return true;
        };

        var updateUsuario = function (usuario) {
            return true;
        };

        return {
            insertUsuario: insertUsuario,
            updateUsuario: updateUsuario,
            getUsuario: getUsuario
        };
    });