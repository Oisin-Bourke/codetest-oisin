var app = angular.module('bfCodeTest', []);

app.controller('studentCtrl', function($scope, $location, $http) {
	console.log("StudentCtrl loaded.");
	
	$http.get('http://localhost:8080/api/getStudents')
	.then(function(response) {
		$scope.students = response.data;
	});

	$http.get('http://localhost:8080/api/getSubjects')
		.then(function(response) {
			$scope.subjects = response.data;
		});

	$scope.postdata = function (studentID, subjectID) {
		var data = {
			student: studentID,
			subject: subjectID
		};

		$http.post('http://localhost:8080/api/addSubject', JSON.stringify(data))
			.then(function () {
				$http.get('http://localhost:8080/api/getStudents')
					.then(function(response) {
						$scope.students = response.data;
					});
				$scope.errorMsg = null;
			}, function (response) {
				$scope.errorMsg = "Invalid Request";
				$scope.statusval = response.status;
			});
	};

});

