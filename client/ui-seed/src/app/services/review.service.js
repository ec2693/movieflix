(function(){

    angular.module('movieflix')
        .service('reviewService',reviewService);

    reviewService.$inject = ['$http', '$q', 'CONFIG'];

    function reviewService($http, $q, CONFIG){

        var self = this;

        self.getAllReviewsForMovie = getAllReviewsForMovie;
        self.createMovieReview = createMovieReview;


        function getAllReviewsForMovie(id){
            return $http.get(CONFIG.API_HOST + '/reviews/getReviewsFor/' + id)
                .then(successFn, errorFn);
        }

        function createMovieReview(review){
            return $http.post(CONFIG.API_HOST + '/reviews/' , review)
                .then(successFn, errorFn);

        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }

    }

    /**
     * Created by Era on 8/12/16.
     */
})();
