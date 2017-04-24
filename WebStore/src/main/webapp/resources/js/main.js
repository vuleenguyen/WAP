/**
 *  
 */

function formValidator(){
	$_form = $(this);
	var toReturn = true;
	
	$.each($_form.find("input"),function(index,value){
		var passVal = "";
		var msg = "";
		_val = $(value).val();
		if (_val.length == 0){
			$(this).css("border","1px solid red");
			msg = "Required !"
		}
		
		switch ($(value).attr("id")){
		case "userNameR":
			break;
		case "email":
			 var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			 if (!re.test(_val))
				 msg = "Check the email"
			break;
		case "name":
			break;
		case "password":
			re = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$/;
			if(!re.test(_val))
				 msg = "Your password should be at least 6 letters and have at least one capital letter, one small letter, one number";
			break;
		case "cpwd":
			if (passVal.length >0 && _val != passVal)
				msg = "Not match password filed"
			break;
		}
		
		if (msg.length > 0){
			toReturn = false;
			$(this).next().text(msg).css("color","red");
			$(this).css("border","1px solid red");
		} else {
			$(this).next().text("");
			$(this).removeAttr("style");
		}
	})
	
	return toReturn;
}



$(document).ready(function(){
	$(".formValidator").submit(formValidator);
	
	// profile, order history
	var stilHave = true;
	$('#orderHistoryJs').on('scroll', function() {
        if(stilHave && $(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
            
        	// ADD AJAX CALL HERE
        	
        	
        	// call back AJAX call
        	$(this).append('\
        			<div \
					class="list-group-item list-group-item-action flex-column align-items-start"> \
					<div class="d-flex w-100 justify-content-between"> \
						<h5 class="mb-1">Order #000112</h5> \
						<small>3 days ago</small> \
					</div> \
					<p class="mb-1"> \
					<div class="list-group"> \
						<a href="#" class="list-group-item list-group-item-action"> \
							item #1 </a> <a href="#" \
							class="list-group-item list-group-item-action"> item #2 </a> <a \
							href="#" class="list-group-item list-group-item-action"> \
							item #3 </a> \
					</div> \
					</div>\
				</div>')
        }
    })
});