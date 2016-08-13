(function() {
    'use strict';

    angular.module('movieflix')
        .service('titleService', titleService);

    titleService.$inject = ['$http', '$q', 'CONFIG'];

    function titleService($http, $q, CONFIG) {

        var self = this;

         self.getMovies = getMovies;
         self.getSeries = getSeries;
         self.getTitleById = getTitleById;

        function getMovies() {
            return $http.get(CONFIG.API_HOST + '/titles/findTitlesByType/movie')
                .then(successFn, errorFn);
        }

        function getSeries() {
            return $http.get(CONFIG.API_HOST + '/titles/findTitlesByType/series')
                .then(successFn, errorFn);
        }

        function getTitleById(id) {
            return $http.get(CONFIG.API_HOST + '/titles/findTitleById/' + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }

})();/**
 * Created by Era on 8/11/16.
 */
