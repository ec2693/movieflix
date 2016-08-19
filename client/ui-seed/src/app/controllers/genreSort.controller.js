(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('GenreSortController', GenreSortController);

    GenreSortController.$inject = ['titleService','$routeParams'];

    function GenreSortController(titleService, $routeParams) {
        var genreSortVm = this;

        init();

        function init() {
            console.log('in MoviesGenreController');
            titleService
                .getMoviesByGenre($routeParams.genreType)
                .then(function(titles){
                    genreSortVm.movies = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .getSeriesByGenre($routeParams.genreType)
                .then(function(titles){
                    genreSortVm.series = titles;
                }, function(error) {
                    console.log(error);
                });

        }

    }
})();/**
 * Created by Era on 8/18/16.
 */
