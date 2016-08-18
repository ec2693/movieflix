(function() {
    'use strict';

    angular.module('movieflix')
        .controller('TitleController', TitleController);

    TitleController.$inject = ['titleService','$location','$routeParams'];

    function TitleController(titleService,$location,$routeParams) {
        var titlesVm = this;
        titlesVm.deleteTitle = deleteTitle;
        titlesVm.showSelectValue = showSelectValue;
        // titlesVm.clicked = clicked;
        titlesVm.genreTitles = genreTitles;


        function showSelectValue(mySelect) {
            titlesVm.genreType = mySelect;
            console.log(titlesVm.genreType);
        }

        // function clicked() {
        //     $location.path('/titles/findTitlesByTypeAndGenre/movie/' + titlesVm.genreType);
        // }


        init();

        function init() {
            console.log('In TitleController');

            titlesVm.sorter = {
                sortBy: 'title',
                sortOrder: false
            };

            titleService
                .getMovies()
                .then(function (movies) {
                    titlesVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
            titleService
                .getSeries()
                .then(function (series) {
                    titlesVm.series = series;
                }, function (error) {
                    console.log(error);
                });
            titleService
                .getAllTitles()
                .then(function (titles) {
                    titlesVm.titles = titles;
                }, function (error) {
                    console.log(error);
                });


            // titleService
            //     .getTitlesByTypeAndGenre(titlesVm.genreType)
            //     .then(function(titles){
            //         titlesVm.moviesOfGenre = titles;
            //     }, function(error) {
            //         console.log(error);
            //     });
        }


        function deleteTitle(id){
            titleService
                .deleteTitle(id)
                .then(function (data) {
                    $location.path('/AllTitles');
                }, function (error) {
                    console.log(error);
                });
        }

        function genreTitles() {
        titleService
            .getTitlesByTypeAndGenre(titlesVm.genreType)
            .then(function (titles) {
                titlesVm.moviesOfGenre = titles;
                console.log(titlesVm.moviesOfGenre);
            }, function (error) {
                console.log(error);
            });

            $location.path('/titles/findTitlesByTypeAndGenre/movie/' + titlesVm.genreType);
        }


    }

})();/**
 * Created by Era on 8/12/16.
 */
