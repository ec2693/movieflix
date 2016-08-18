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
            templateUrl: 'app/views/add-user.tmpl.html',
            controller: 'AddUserController',
            controllerAs: 'addUserVm'
        })
        .when('/users/auth/user', {
            templateUrl: 'app/views/auth-user.tmpl.html',
            controller: 'AuthUserController',
            controllerAs: 'authUserVm'
        })
        .when('/users/auth/admin', {
            templateUrl: 'app/views/auth-admin.tmpl.html',
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
          templateUrl: 'app/views/title-details.tmpl.html',
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
             templateUrl: 'app/views/add-title.tmpl.html',
             controller: 'AddTitleController',
             controllerAs: 'addTitleVm'

        })
        .when('/titles/findTitlesByTypeAndGenre/movie/:genreType', {
            templateUrl: 'app/views/movie-genreSort-tmpl.html',
            controller: 'TitleController',
            controllerAs: 'titlesVm'
        })
        .when('/reviews/getReviewsFor/:id', {
            templateUrl: 'app/views/movie-review.tmpl.html',
            controller: 'TitleDetailController',
            controllerAs: 'titleDetailVm'
        })
        .when('/reviews/:id', {
            templateUrl: 'app/views/add-review.tmpl.html',
            controller: 'AddReviewController',
            controllerAs: 'addReviewVm'
        })



        // .when('/titles/findTitlesByTypeAndGenre/movie/adventure', {
        //     templateUrl: 'app/views/movie-genreSort-tmpl.html',
        //     controller: 'TitleController',
        //     controllerAs: 'titlesVm'
        // })
        // .when('/titles/findTitlesByTypeAndGenre/movie/fantasy', {
        //     templateUrl: 'app/views/movie-genreSort-tmpl.html',
        //     controller: 'TitleController',
        //     controllerAs: 'titlesVm'
        // })
        // .when('/titles/findTitlesByTypeAndGenre/movie/sci-fi' , {
        //     templateUrl: 'app/views/movie-genreSort-tmpl.html',
        //     controller: 'TitleController',
        //     controllerAs: 'titlesVm'
        //
        // })



    // .when('/reviews/getReviewsFor/:id', {
    //   templateUrl: 'app/views/title-details.tmpl.html',
    //   controller: 'TitleDetailController',
    //   controllerAs: 'titleDetailVm'
    // })
    // .otherwise({
    //   redirectTo: '/users'
    // })
    ;
  }

  moduleRun.$inject = [];
  function moduleRun(){
      console.log('App Started');
  }

})();