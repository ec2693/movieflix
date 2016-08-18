(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('SeriesGenreController', SeriesGenreController);

    SeriesGenreController.$inject = ['titleService', '$location','$routeParams'];

    function SeriesGenreController(titleService, $location,$routeParams) {
        var seriesGenreVm = this;

        init();

        function init() {
            console.log('in SeriesGenreController');
            titleService
                .getSeriesByGenre($routeParams.genreType)
                .then(function(titles){
                    seriesGenreVm.series = titles;
                }, function(error) {
                    console.log(error);
                });

        }

    }
})();/**
 * Created by Era on 8/18/16.
 */
