(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('TitlesGenreController', TitlesGenreController);

    TitlesGenreController.$inject = ['titleService','$routeParams'];

    function TitlesGenreController(titleService, $routeParams) {
        var titlesGenreVm = this;

        init();

        function init() {
            console.log('in MoviesGenreController');
            titleService
                .getMoviesByGenre($routeParams.genreType)
                .then(function(titles){
                    titlesGenreVm.movies = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .getSeriesByGenre($routeParams.genreType)
                .then(function(titles){
                    titlesGenreVm.series = titles;
                }, function(error) {
                    console.log(error);
                });

        }

    }
})();/**
 * Created by Era on 8/18/16.
 */
