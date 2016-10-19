/**
 * function 年月日显示
 */
function showDate() {
	showYear();
	showMonth();
	showDay();
}
/*
 * 提交爱好
 */
function doSubmit(form) {
	linkDate(form);
	return true;
}
function linkDate(form) {
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;
	var str = year + "-" + month + "-" + day;

	// 创建输入项,保存日期,传给服务器
	var date = document.createElement("input");
	date.type = "hidden";
	alert("str" + str);
	date.name = "birthday";
	date.value = str;
	form.appendChild(date);
}
function showYear() {
	var year = document.getElementById("year");
	var year1 = new Date().getYear();
	for (var i = (new Date().getYear() + 1900); i >= 1900; --i) {
		var option = document.createElement("option");
		option.value = i;
		option.innerText = i;

		year.appendChild(option);
	}
}
function showMonth() {
	var month = document.getElementById("month");
	for (var i = 1; i <= 12; ++i) {
		var option = document.createElement("option");
		if (i < 10) {
			option.value = "0" + i;
			option.innerText = "0" + i;
		} else {
			option.value = i;
			option.innerText = i;
		}
		month.appendChild(option);
	}
}
function showDay() {
	var day = document.getElementById("day");
	for (var i = 1; i <= 31; ++i) {
		var option = document.createElement("option");
		if (i < 10) {
			option.value = "0" + i;
			option.innerText = "0" + i;
		} else {
			option.value = i;
			option.innerText = i;
		}

		day.appendChild(option);
	}
}