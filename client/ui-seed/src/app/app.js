(function() {
  'use strict';

  angular
    .module('movieflix', ['ngMessages','ngRoute','ui.bootstrap'])
    .config(moduleConfig)
    .run(moduleRun);

  moduleConfig.$inject = ['$routeProvider'];
  function moduleConfig($routeProvider) {

    $routeProvider
        .when('/users', {
            templateUrl: 'app/views/addUser.tmpl.html',
            controller: 'AddUserController',
            controllerAs: 'addUserVm'
        })
        .when('/users/auth/user', {
            templateUrl: 'app/views/authUser.tmpl.html',
            controller: 'AuthUserController',
            controllerAs: 'authUserVm'
        })
        .when('/users/auth/admin', {
            templateUrl: 'app/views/authAdmin.tmpl.html',
            controller: 'AuthAdminController',
            controllerAs: 'authAdminVm'
        })
        .when('/titles/findTitlesByType/movie', {
          templateUrl: 'app/views/movie.tmpl.html',
          controller: 'TitleController',
          controllerAs: 'titlesVm'
        })
        .when('/titles/findTitlesByType/series', {
          templateUrl: 'app/views/series.tmpl.html',
          controller: 'TitleController',
          controllerAs: 'titlesVm'
        })
        .when('/titles/findTitleById/:id', {
          templateUrl: 'app/views/titleDetails.tmpl.html',
          controller: 'TitleDetailController',
          controllerAs: 'titleDetailVm'
        })
        .when('/titles', {
            templateUrl: 'app/views/home.tmpl.html',
            controller: 'TitleController',
            controllerAs: 'titlesVm'
        })
        .when('/AllTitles', {
            templateUrl: 'app/views/title.tmpl.html',
            controller: 'TitleController',
            controllerAs: 'titlesVm'
        })
        .when('/titles/createTitle', {
             templateUrl: 'app/views/addTitle.tmpl.html',
             controller: 'AddTitleController',
             controllerAs: 'addTitleVm'

        })
        .when('/reviews/getReviewsFor/:id', {
            templateUrl: 'app/views/movieReview.tmpl.html',
            controller: 'TitleDetailController',
            controllerAs: 'titleDetailVm'
        })
        .when('/reviews/:id', {
            templateUrl: 'app/views/addReview.tmpl.html',
            controller: 'AddReviewController',
            controllerAs: 'addReviewVm'
        })
        .when('/titles/findTitlesByTypeAndGenre/movie/:genreType', {
            templateUrl: 'app/views/sortMoviesByGenre.tmpl.html',
            controller: 'GenreSortController',
            controllerAs: 'genreSortVm'
        })
        .when('/titles/findTitlesByTypeAndGenre/series/:genreType', {
            templateUrl: 'app/views/sortSeriesByGenre.tmpl.html',
            controller: 'GenreSortController',
            controllerAs: 'genreSortVm'
        })
        .when('/titles/sortTitlesByTypeAndYear/movie', {
            templateUrl: 'app/views/sortMoviesByYear.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        .when('/titles/sortTitlesByTypeAndYear/series', {
            templateUrl: 'app/views/sortSeriesByYear.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        .when('/titles/sortTitlesByTypeAndImdbRatings/movie', {
            templateUrl: 'app/views/sortMoviesByImdbRatings.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        .when('/titles/sortTitlesByTypeAndImdbRatings/series', {
            templateUrl: 'app/views/sortSeriesByImdbRatings.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        .when('/titles/sortTitlesByTypeAndImdbVotes/movie', {
            templateUrl: 'app/views/sortMoviesByImdbVotes.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        .when('/titles/sortTitlesByTypeAndImdbVotes/series', {
            templateUrl: 'app/views/sortSeriesByImdbVotes.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        .when('/logOut', {
            templateUrl: 'app/views/logOut.tmpl.html',
            controller: 'SortController',
            controllerAs: 'sortVm'
        })
        // .otherwise({
    //         redirectTo: '/users'
    //     })
    ;
  }

  moduleRun.$inject = [];
  function moduleRun(){
      console.log('App Started');
  }

})();