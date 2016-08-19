(function() {
    'use strict';

    angular.module('movieflix')
        .controller('TitleController', TitleController);

    TitleController.$inject = ['titleService','$location'];

    function TitleController(titleService,$location) {
        var titlesVm = this;
        titlesVm.deleteTitle = deleteTitle;
        titlesVm.showMovieGenre = showMovieGenre;
        titlesVm.showSeriesGenre = showSeriesGenre;
        titlesVm.movieSortValue = movieSortValue;
        titlesVm.seriesSortValue = seriesSortValue;


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

        function showMovieGenre(movieGenre) {
            var genreType = movieGenre;
            console.log('/titles/findTitlesByTypeAndGenre/movie/'+ genreType);
            $location.path('/titles/findTitlesByTypeAndGenre/movie/'+ genreType);
        }

        function showSeriesGenre(seriesGenre) {
            var genreType = seriesGenre;
            console.log('/titles/findTitlesByTypeAndGenre/series/'+ genreType);
            $location.path('/titles/findTitlesByTypeAndGenre/series/'+ genreType);
        }

        function movieSortValue(mSortValue) {
            if (mSortValue === 'year') {
                $location.path('/titles/sortTitlesByTypeAndYear/movie');
            }
            else if(mSortValue === 'ratings'){
                $location.path('/titles/sortTitlesByTypeAndImdbRatings/movie');
            }
            else{
                $location.path('/titles/sortTitlesByTypeAndImdbVotes/movie');
            }

        }

        function seriesSortValue(sSortValue) {
            if (sSortValue === 'year') {
                $location.path('/titles/sortTitlesByTypeAndYear/series');
            }
            else if(sSortValue === 'ratings'){
                $location.path('/titles/sortTitlesByTypeAndImdbRatings/series');
            }
            else{
                $location.path('/titles/sortTitlesByTypeAndImdbVotes/series');
            }
        }



    }

})();/**
 * Created by Era on 8/12/16.
 */






