(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['titleService', '$location'];

    function AdminController(titleService, $location) {
        var adminVm = this;


        init();

        function init() {
            console.log('in AdminController');
        }

    }
})();/**
 * Created by Era on 8/17/16.
 */
