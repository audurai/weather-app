$(function() {
	$("#show-cities").click(getCities);
});

function getCities() {
	var url = "http://localhost:8080/weather-app/rest/report/"
			+ escape($("#country").val());
	$.ajax({
		url : url,
		success : showCities
	});
}

function getReport() {
	var selectedCity = $("#cities").find(":selected").text();

	var url = "http://localhost:8080/weather-app/rest/report/"
			+ escape($("#country").val()) + "/" + escape(selectedCity);
	$.ajax({
		url : url,
		success : showReport
	});
}

function showCities(text, status) {
	// alert(text);
	var cityList = text.cities;
	var citiesSelectOptions = "<select id = 'cities' > <option value='0' selected=selected>Select City</option>";
	for (var i = 0; i < cityList.length; i++) {
		console.log(cityList[i]);
		citiesSelectOptions = citiesSelectOptions + "<option value='" + i + 1
				+ "'>" + cityList[i] + "</option>";
	}
	citiesSelectOptions + "</select>";
	$("#cities-list").html("Cities ");
	$("#cities").html(citiesSelectOptions);
	$("#report-btn").html(
			"<input type='button' id='show-report' value='Show Report' />");
	$("#show-report").click(getReport);
}

function showReport(text, status) {
	alert("Success");
}