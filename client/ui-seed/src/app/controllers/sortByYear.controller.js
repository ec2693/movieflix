(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('SortByYearController', SortByYearController);

    SortByYearController.$inject = ['titleService', '$location','$routeParams'];

    function SortByYearController(titleService, $location,$routeParams) {
        var sortByYearVm = this;

        init();

        function init() {
            console.log('in SortByYearController');
            titleService
                .sortMoviesByYear()
                .then(function(titles){
                    sortByYearVm.movies = titles;
                }, function(error) {
                    console.log(error);
                });

            titleService
                .sortSeriesByYear()
                .then(function(titles){
                    sortByYearVm.series = titles;
                }, function(error) {
                    console.log(error);
                });

        }

    }
})();/**
 * Created by Era on 8/18/16.
 */
