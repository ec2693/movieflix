(function() {
    'use strict';

    angular.module('movieflix')
        .service('titleService', titleService);

    titleService.$inject = ['$http', '$q', 'CONFIG'];

    function titleService($http, $q, CONFIG) {

        var self = this;

         self.getAllTitles = getAllTitles;
         self.getMovies = getMovies;
         self.getSeries = getSeries;
         self.getTitleById = getTitleById;
         self.getMoviesByGenre = getMoviesByGenre;
         self.getSeriesByGenre = getSeriesByGenre;
         self.getAverageRatingForTitle = getAverageRatingForTitle;
         self.createTitle = createTitle;
         self.deleteTitle = deleteTitle;

        function getAllTitles(){
            return $http.get(CONFIG.API_HOST + '/titles')
                .then(successFn, errorFn);
        }

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

        function getMoviesByGenre(genreType) {
            return $http.get(CONFIG.API_HOST + '/titles/findTitlesByTypeAndGenre/movie/' + genreType)
                .then(successFn, errorFn);
        }

        function getSeriesByGenre(genreType) {
            return $http.get(CONFIG.API_HOST + '/titles/findTitlesByTypeAndGenre/series/' + genreType)
                .then(successFn, errorFn);
        }

        function getAverageRatingForTitle(id) {
            return $http.get(CONFIG.API_HOST + '/titles/getAverageRatingForTitle/' + id)
                .then(successFn, errorFn);
        }

        function createTitle(title){
            return $http.post(CONFIG.API_HOST + '/titles/createTitle', title)
                .then(successFn, errorFn);
        }

        function deleteTitle(id){
            return $http.delete(CONFIG.API_HOST + '/titles/' + id)
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
