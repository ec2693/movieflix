(function() {
    'use strict';

    angular.module('movieflix')
        .controller('TitleController', TitleController);

    TitleController.$inject = ['titleService'];

    function TitleController(titleService) {
        var titlesVm = this;
        init();

        function init() {
            console.log('TitleController');

            
            titleService
                .getMovies()
                .then(function(movies) {
                    titlesVm.movies = movies;
                }, function(error) {
                    console.log(error);
                });
            titleService
                .getSeries()
                .then(function(series) {
                    titlesVm.series = series;
                }, function(error) {
                    console.log(error);
                });
        }
    }

})();/**
 * Created by Era on 8/12/16.
 */
