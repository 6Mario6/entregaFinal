
angularFormsApp.controller('efController',
    function efController($scope, $window, $routeParams, DataService) {

        

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