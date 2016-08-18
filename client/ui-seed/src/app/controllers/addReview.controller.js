(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('AddReviewController', AddReviewController);

    AddReviewController.$inject = ['reviewService','titleService', '$location','$routeParams',];

    function AddReviewController(reviewService, titleService,$location, $routeParams) {
        var addReviewVm = this;

        addReviewVm.addReview = addReview;

        init();

        function init() {
            console.log('in AddReviewController');

        }

        function addReview() {
            // console.log($routeParams.id);
            titleService
                .getTitleById($routeParams.id)
                .then(function(data) {
                    addReviewVm.newReview.movie = data;
                    console.log(addReviewVm.newReview.movie);
                    reviewService
                        .createMovieReview(addReviewVm.newReview)
                        .then(function(data) {
                            $location.path('/titles');
                        }, function(error) {
                            console.log(error);
                        })
                }, function(error) {
                console.log(error);
            })

            // addReviewVm.newReview.movie = addReviewVm.movie;
            // console.log(addReviewVm.newReview.movie);
            // reviewService
            //     .createMovieReview(addReviewVm.newReview)
            //     .then(function(data) {
            //         $location.path('/titles');
            //     }, function(error) {
            //         console.log(error);
            //     })

        }
    }
})()/**
 * Created by Era on 8/16/16.
 */
