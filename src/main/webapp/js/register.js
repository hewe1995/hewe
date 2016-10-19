$(document).ready(function() {
	$("#name").blur(function() {
		var name = $("#name").val();
		if (name.length < 4 || name.length > 10){
			$("#hint").html("<font color='red'><b>用户名格式不对</b></font>");
			$("#name").focus().css({
				border : "1px solid red",
				boxShadow : "0 0 2px red"
			});
			return;
		}
		$.ajax({
			type : "GET",
			url : "isExit",
			data : "username=" + $("#name").val(),
			dataType : 'text',
			success : function(result) {
				if (result == '1') {
					$("#hint").html("<font color='red'><b>用户已存在</b></font>");
					$("#name").focus().css({
						border : "1px solid red",
						boxShadow : "0 0 2px red"
					});
				} else if (result == '2') {
					$("#hint").html("<font color='red'><b>用户名格式不对</b></font>");
					$("#name").focus().css({
						border : "1px solid red",
						boxShadow : "0 0 2px red"
					});
				} else if (result == '0') {
					$("#hint").html("<font color='green'><b>用户名可以使用</b></font>");
					$("#name").css({
						border : "1px solid #D7D7D7",
						boxShadow : "none"
					});
				}
			}
		});
	});
});