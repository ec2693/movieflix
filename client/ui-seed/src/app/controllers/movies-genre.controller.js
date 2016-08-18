(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MoviesGenreController', MoviesGenreController);

    MoviesGenreController.$inject = ['titleService', '$location','$routeParams'];

    function MoviesGenreController(titleService, $location,$routeParams) {
        var moviesGenreVm = this;

        init();

        function init() {
            console.log('in MoviesGenreController');
            titleService
                .getMoviesByGenre($routeParams.genreType)
                .then(function(titles){
                    moviesGenreVm.movies = titles;
                }, function(error) {
                    console.log(error);
                });

        }

    }
})();/**
 * Created by Era on 8/18/16.
 */
