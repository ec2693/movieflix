(function() {
  'use strict';

  angular
    .module('movieflix', ['ngRoute'])
    .config(moduleConfig);

  function moduleConfig($routeProvider) {

    $routeProvider
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

})();