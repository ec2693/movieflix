(function(){
    'use strict';

    angular.module('movieflix')
        .controller('AddTitleController', AddTitleController);

    AddTitleController.$inject = ['titleService','reviewService', '$routeParams'];

    function AddTitleController(titleService, reviewService,$routeParams) {
        var addTitleVm = this;
        var cast = new Array();
        console.log('era');

        addTitleVm.addCast = addCast;

        addTitleVm.addTitle = addTitle;

       init();

        function init() {
            console.log('in AddTitleController');


        }

        // console.dir(addTitleVm.newTitle);
        function addCast() {
            console.log('in addCast');

            cast.push(addTitleVm.newCast);
            var newCast = new Array();
            newCast.castType.push(addTitleVm.newCast.castType);
            newCast.castName.push(addTitleVm.newCast.castName);
            cast.push(newCast);
            console.dir(addTitleVm.newCast);
        }

        // addTitleVm.newTitle.cast.push(addTitleVm.newCast);
        // console.dir(addTitlevm.newTitle);

        function addTitle() {
            titleService
                .createTitle(addTitleVm.newTitle)
                .then(function(title) {
                    $location.path('/titles');
                }, function(error) {
                    console.log(error);
                })
        }

    }




    /**
     * Created by Era on 8/13/16.
     */
})();
