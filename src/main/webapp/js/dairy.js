/**
 * Created by yingmeng on 2017/5/13 0013.
 */
var app = angular.module("myapp", []).controller("MyDairy",
    function($scope, $timeout) {
    $scope.updateClock = function () {
        var date = new Date();
        $scope.clock = date.toLocaleDateString() + " " + date.toLocaleTimeString();



        $timeout(function () {
            $scope.updateClock();
        },999);
    };
    $scope.addItem = function () {
        $.ajax({
            type: 'get',
            url: '../ajax/item/AddItem',
            data: {
                "id": 0,
                "content": "tstcontent",
                "deadTime": 1234,
                "result": 0
            },
            dataType: "text",
            success: function (data) {
                console.log(data)
            }
        });
    };
    $scope.queryDoingItem = function () {
        $.ajax({
            type: 'get',
            url: '../ajax/item/queryDoingItem',
            data: {},
            dataType: "text",
            success: function (data) {
                console.log(data)
            }
        });
    };
        $scope.queryDoneOrCancel = function () {
            $.ajax({
                type: 'get',
                url: '../ajax/item/queryDomeOrDoingItem',
                data: {},
                dataType: "text",
                success: function (data) {
                    console.log(data)
                }
            });
        };
    $scope.commit = function() {
        // $.ajax({
        //     type: 'get',
        //     url: '../ajax/dairy/saveDariy',
        //     data: {
        //         "level": 1,
        //         "title": $scope.title,
        //         "content": $scope.content
        //     },
        //     dataType: "text",
        //     success: function (data) {
                // $.ajax({
                //     type: 'get',
                //     url: '../ajax/dairy/queryAll',
                //     data: {},
                //     dataType: "text",
                //     success: function (data) {
                //         console.log(data)
                //     }
                // });
        //     }
        // });
    }
    $scope.updateClock();
});