$(document).ready(function() {
	$('.menu-toggle .glyphicon').click(function() {
		if ($('.menu-toggle').hasClass("active")) {
			$('.menu-toggle').removeClass("active");
		} else {
			$('.menu-toggle').addClass('active');
		}
	});
	
	$('.sf-menu').find('li').each(function() {
		$(this).hover(function() {
			var a = $(this).children().first();
			a = $(a);
			a.toggleClass("active");
		});
	});
	
	
	$('.rowProduct').children().each(function() {
		$(this).find('img').each(function() {
			$(this).mouseover(function() {
				var src = $(this).attr("src").match(/[^\.]+/) + "_.png";
				$(this).fadeOut("fast").attr("src",src).fadeIn("fast");
			});
			
			$(this).mouseout(function() {
				var src = $(this).attr("src").replace("_.png",".png");
				$(this).fadeOut("fast").attr("src",src).fadeIn("fast");
			});
		});
	});
	
});