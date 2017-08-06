/**
 * Created by yingmeng on 2017/5/13 0013.
 */
var app = angular.module("myapp", ['ngTable']).controller("MyDairy",
    function($scope, $timeout, NgTableParams) {
    $scope.updateClock = function () {
        var date = new Date();
        $scope.clock = date.toLocaleDateString() + " " + date.toLocaleTimeString();
        $timeout(function () {
            $scope.updateClock();
        },999);
    };
    $scope.init = function () {
        $scope.id = 0;
        $scope.level = 1;
        $scope.deadTime = new Date();
        $scope.editValue = {};
        $scope.content = "";
        $scope.noSetName = false;
        $scope.user = {"name":""};
        $scope.queryName();
    }
    $scope.cancel = function () {
        $scope.id = 0;
        $scope.content = "";
    };
    $scope.editUser = function (user) {
        user.edit = true;
        $scope.editValue.content = user.content;
        $scope.editValue.levelValue = user.levelValue;
        $scope.editValue.deadTime = new Date(user.deadTime);
    };
    $scope.cancelEdit = function (user) {
        user.edit = false;
        $scope.editValue.content = user.content;
        $scope.editValue.levelValue = user.levelValue;
        $scope.editValue.deadTime = new Date(user.deadTime);
    };
    $scope.saveUser = function (user) {
        user.content = $scope.editValue.content;
        user.levelValue = $scope.editValue.levelValue;
        user.deadTime = $scope.editValue.deadTime.getTime();
        $scope.updateItem(user, 0);
    };
    $scope.queryName = function () {
        $.ajax({
            type: 'post',
            url: '../../ajax/user/getName',
            data: {},
            dataType: "text",
            success: function (data) {
                var name = JSON.parse(data).result;
                if (name === undefined || name === "") {
                    $scope.noSetName = true;
                } else {
                    $scope.user.name = name;
                }
            }
        });
    };
    $scope.addItem = function () {
        $.ajax({
            type: 'post',
            url: '../../ajax/item/AddItem',
            data: {
                "id": 0,
                "content": $scope.content,
                "deadTime": $scope.deadTime.getTime(),
                "result": 0,
                "type":0,
                "levelValue":$scope.level,
            },
            dataType: "text",
            success: function (data) {
                console.log(data)
                $scope.init();
                $scope.tableParams.reload();
            }
        });
    };
    $scope.updateItem = function (data, result) {
        $.ajax({
            type: 'post',
            url: '../../ajax/item/AddItem',
            data: {
                "id": data.id,
                "content": data.content,
                "deadTime": data.deadTime,
                "result": result,
                "levelValue":data.levelValue,
                "type":0
            },
            dataType: "text",
            success: function (data) {
                console.log(data)
                $scope.tableParams.reload();
            }
        });
    };
    $scope.queryDoingItem = function () {
        $scope.tableParams = new NgTableParams(
            {
                page: 1,      // show first page
                count: 10,      // count per page
            },
            {
                total: 0, // length of data
                getData: function($defer, params) {
                    console.log("123");
                    $.ajax({
                        type: 'post',
                        url: '../../ajax/item/queryDoingItem',
                        data: {},
                        dataType: "text",
                        success: function (data) {
                            console.log(data)
                            $scope.formData = JSON.parse(data).result;
                            for (var i = 0; i < $scope.formData.length; i++) {
                                $scope.formData[i].edit = false;
                                $scope.formData[i].edit = false;
                            }
                        }
                    });
                }
            });
    };
    $scope.queryDoneOrCancel = function () {
        $.ajax({
            type: 'post',
            url: '../../ajax/item/queryDomeOrDoingItem',
            data: {},
            dataType: "text",
            success: function (data) {
                console.log(data)
            }
        });
    };
    $scope.setName = function () {
        $.ajax({
            type: 'post',
            url: '../../ajax/user/setIpAndName',
            data: {
                "name": $scope.user.name
            },
            dataType: 'text',
            success: function (data) {
                $scope.noSetName = false;
            }
        });
    }
    $scope.updateClock();
    $scope.init();
    $scope.queryDoingItem();
    // $scope.queryDoneOrCancel();
});