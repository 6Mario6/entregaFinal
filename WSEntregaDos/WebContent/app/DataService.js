
angularFormsApp.factory('DataService',
    function () {
        var getUsuario = function (id) {
            if (id == 123) {
                return {
                    id: 123,
                    fullName: "Milton Waddams",
                    notes: "The ideal employee.  Just don't touch his red stapler.",
                    department: "Administration",
                    dateHired: "July 11 2014",
                    breakTime: "July 11 2014 3:00 PM",
                    perkCar: true,
                    perkStock: false,
                    perkSixWeeks: true,
                    payrollType: "none"
                };
            }
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