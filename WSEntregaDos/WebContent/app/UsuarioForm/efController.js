
angularFormsApp.controller('efController',
    function efController($scope, $window, $routeParams, DataService) {

        if ($routeParams.id)
            $scope.usuario = DataService.getEmployee($routeParams.id);
        else
            $scope.usuario = { id: 0 };

        $scope.editableUsuario = angular.copy($scope.usuario);

        $scope.departments = [
            "Engineering",
            "Marketing",
            "Finance",
            "Administration"
        ];

        $scope.shouldShowFullName = function () {
            return true;
        };

        $scope.submitForm = function () {

            $scope.$broadcast('show-errors-event');

            if ($scope.usuarioForm.$invalid)
                return;


            if ($scope.editableUsuario.id == 0) {
                // insert new usuario
                DataService.insertUsuario($scope.editableUsuario);
            }
            else {
                // update the Usuario
                DataService.updateUsuario($scope.editableUsuario);
            }

            $scope.usuario = angular.copy($scope.editableUsuario);
            $window.history.back();
        };

        $scope.cancelForm = function () {
            $window.history.back();
        };

        $scope.resetForm = function () {
            $scope.$broadcast('hide-errors-event');
        }

    });