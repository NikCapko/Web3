
function openTask() {
	$.get('http://127.0.0.1:8083/second_page',
		function (data) {
			$("body").html(data);
		});
}

function sendNumber() {
	var rimNumber = $("#rim").val();
	console.log(rimNumber);
	$.get('http://127.0.0.1:8083/convert?number=' + rimNumber, function (data) {
		console.log(data);
		$('#arabic').val(data.number);
	}, "json");
}

function deleteStudent(e) {
    var sourceElem = e.target || e.srcElement;
    console.log(sourceElem.id);
}

function openTable() {
	$.get('http://127.0.0.1:8083/table',
		function (data) {
			$("body").html(data);
		});
}

class Student {
	constructor(id, name, lastName, firstName, yearBirth) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.firstName = firstName;
		this.yearBirth = yearBirth;
	}

	getId() {
		return id;
	}

	getName() {
		return name;
	}

	getLastName() {
		return lastName;
	}

	getFirstName() {
		return firstName;
	}

	getYearBirth() {
		return yearBirth;
	}
}