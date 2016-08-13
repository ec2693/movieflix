(function() {
    'use strict';

    angular.module('movieflix')
        .controller('TitleDetailController', TitleDetailController);

    TitleDetailController.$inject = ['titleService','reviewService', '$routeParams'];

    function TitleDetailController(titleService, reviewService,$routeParams) {
        var titleDetailVm = this;

        init();

        function init() {
            console.log('TitleDetailController');


            titleService
                .getTitleById($routeParams.id)
                .then(function (movie){
                    titleDetailVm.movie = movie;
                    titleDetailVm.cast = movie.cast;
                    titleDetailVm.imdb = movie.imdb;
                    console.dir(titleDetailVm.movie)
                }, function (error) {
                    console.log(error);
                });

            reviewService
                .getAllReviewsForMovie($routeParams.id)
                .then(function(review) {
                    titleDetailVm.review = review;
                    console.dir(titleDetailVm.review)
                }, function (error) {
                    console.log(error);

                });

        }
    }

})();/**
 * Created by Era on 8/12/16.
 */
