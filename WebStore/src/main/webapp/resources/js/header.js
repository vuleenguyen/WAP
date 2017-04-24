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
});