(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('SortController', SortController);

    SortController.$inject = ['titleService'];

    function SortController(titleService) {
        var sortVm = this;

        init();

        function init() {
            console.log('in SortByYearController');
            titleService
                .sortMoviesByYear()
                .then(function(titles){
                    sortVm.moviesByYear = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .sortSeriesByYear()
                .then(function(titles){
                    sortVm.seriesByYear = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .sortMoviesByImdbRatings()
                .then(function(titles){
                    sortVm.moviesByRatings = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .sortSeriesByImdbRatings()
                .then(function(titles){
                    sortVm.seriesByRatings = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .sortMoviesByImdbVotes()
                .then(function(titles){
                    sortVm.moviesByVotes = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .sortSeriesByImdbVotes()
                .then(function(titles){
                    sortVm.seriesByVotes = titles;
                }, function(error) {
                    console.log(error);
                });
        }

    }
})();/**
 * Created by Era on 8/18/16.
 */
