/**
 * 
 */

function formValidator(){
	$_form = $(this);
	var toReturn = true;
	var firstFocus;
	var height = "100%";
	var passVal = "";
	$.each($_form.find("input"),function(index,value){
		
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
			else passVal = _val;
			break;
		case "cpwd":
			if (passVal.length >0 && _val != passVal)
				msg = "Not match password filed"
			break;
		}
		
		if (msg.length > 0){
			if (typeof firstFocus == 'undefined') {
				firstFocus = $(this);
			}
			height = parseInt(height) + 4 + "%";
			toReturn = false;
			$(this).next().text(msg).css("color","red");
			$(this).css("border","1px solid red");
		} else {
			$(this).next().text("");
			$(this).removeAttr("style");
		}
	})
	
	if (!toReturn) {
		firstFocus.focus();
	} 
	$("#signup").css("height", height);
	return toReturn;
}

$(document).ready(function(){
	$(".formValidator").submit(formValidator);
	
	// profile, order history
	var stilHave = true;
	$('#orderHistoryJs').on('scroll', function() {
        if(stilHave && $(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
            
        	_this = $(this);
        	
        	// ADD AJAX CALL HERE
        	
        	 $.ajax({
      		    url:"/WebStore/checkout",
      		    data: {action: "ajaxcall" },
      		    success:function(data) {
      		    	var itemsList = "";
      		    	
      		    	itemList = JSON.parse(data.itemList);
      		    	$.each( itemList , function(index, value){
      		    		itemsList += '<a href="#" class="list-group-item list-group-item-action"> '+value+' </a>'
      		    	});
      		    	
      		    	
      		    	_this.append('\
      	        			<div \
      						class="list-group-item list-group-item-action flex-column align-items-start"> \
      						<div class="d-flex w-100 justify-content-between"> \
      							<h5 class="mb-1">Order #'+ data.orderNumber +'</h5> \
      							<small>'+data.orderDate+'</small> \
      						</div> \
      						<p class="mb-1"> \
      						<div class="list-group"> \
      							'+itemsList+'\
      						</div> \
      						</div>\
      					</div>');
      		    }
      		 });
        }
    })
    
    
    // Admin panel
    $("#product_table").on('click' , '#removeProduct' , function(){
    	var _tr = $(this).closest("tr");
    	var _tr_id = parseInt(_tr.find("#id").text());
    	
    	 $.ajax({
 		    url:"/WebStore/AdminPanel",
 		    data: {action: "delete",
 		    	id: _tr_id
 		    },
 		    success:function(data) {
 		    	_tr.remove();
 		    }
 		 });
    	
    });
	
	$("#product_table").on('click' , "#updateProduct", function(){
		var _tr = $(this).closest("tr");
		var _tr_id = parseInt(_tr.find("#id").text());
		var _tr_name = $(_tr).find("#name").text();
		var _tr_price = $(_tr).find("#price").text(); 
		var _tr_binfo = $(_tr).find("#binfo").text();
		var _tr_dinfo = $(_tr).find("#dinfo").text();

		$(_tr).find("#name").html("<input type='text' id='name_"+_tr_id+"' value='"+_tr_name+"' />");
		$(_tr).find("#price").html("<input type='text' id='price_"+_tr_id+"' value='"+_tr_price+"' />");
		
		$(_tr).find("#binfo").html("<textarea id='binfo_"+_tr_id+"'>"+_tr_binfo+"</textarea>");
		$(_tr).find("#dinfo").html("<textarea id='dinfo_"+_tr_id+"'>"+_tr_dinfo+"</textarea>");
		
		$(_tr).find("#actions").html("<input id='update_product' type='submit' value='Update' class='btn btn-primary' />");
	})
    
	$("#product_table").on('click' , "#update_product" , function(){
		var _tr = $(this).closest("tr");
		var _tr_id = parseInt(_tr.find("#id").text())
		var nameVal = _tr.find("#name_"+_tr_id).val();
		var priceVal = _tr.find("#price_"+_tr_id).val();
		var binfoVal = _tr.find("#binfo_"+_tr_id).val();
		var dinfo = _tr.find("#dinfo_"+_tr_id).val();
		
		 $.ajax({
		    url:"/WebStore/AdminPanel",
		    data: {action: "update",
		    	name: nameVal,
		    	price: priceVal,
		    	id: _tr_id,
		    	briefInformation : binfoVal,
		    	detailInformation : dinfo
		    },
		    success:function(data) {
				$(_tr).find("#name").html(nameVal);
				$(_tr).find("#price").html(priceVal);
				$(_tr).find("#binfo").html(binfoVal);
				$(_tr).find("#dinfo").html(dinfo);
				$(_tr).find("#actions").html('<a href="#" id="removeProduct" class="blue-text"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a> \
						<a href="#" id="updateProduct" class="blue-text"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>');
		    }
		 });
	})
	
	
//	$("#addProduct").click(function(){
//		$("#product_table").append('<tr>\
//				<td id="id" scope="row">4</td>\
//				<td id="name"><input type="text" id="name_4" value=""></td>\
//				<td id="price"><input type="text" id="price_4" value=""></td> \
//				<td id="actions"><input id="update_product" type="submit" value="Save" class="btn btn-primary"></td>\
//				</tr>')
//	});
	
	 $("#productImage").elevateZoom();
	 
	 $("#productDetail .col-sm-2 > div").click(function() {
		 var image = $(this).children().first();
		 var linkOfImage = $(image).attr("src");
		 $("#productImage").attr("src",linkOfImage);
	 });
	
});