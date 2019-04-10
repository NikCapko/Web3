
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

function openTable() {
	$.get('http://127.0.0.1:8083/table',
		function (data) {
			$("body").html(data);
		});
}

// формируем новые поля
jQuery('.plus').click(function () {
	jQuery('.information_json_plus').before(
		'<tr>' +
		'<td><input type="text" class="form-control" id="information_json_name[]" placeholder="Название поля"></td>' +
		'<td><input type="text" class="form-control" id="information_json_val[]" placeholder="Значение поля"></td>' +
		'<td><span class="btn btn-danger minus pull-right">&ndash;</span></td>' +
		'</tr>'
	);
});
// on - так как элемент динамически создан и обычный обработчик с ним не работает
jQuery(document).on('click', '.minus', function () {
	jQuery(this).closest('tr').remove(); // удаление строки с полями
});

class Student {
	constructor(id, name, lastName, firstName, yearBith) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.firstName = firstName;
		this.yearBith = yearBith;
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

	getYearBith() {
		return yearBith;
	}
}