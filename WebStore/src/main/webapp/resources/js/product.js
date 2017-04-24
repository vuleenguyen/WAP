$(document).ready(function() {
	
	
	$('.rowProduct').children().each(function() {
		$(this).find('img').each(function() {
			$(this).mouseover(function() {
				var src = $(this).attr("src").match(/[^\.]+/) + "_.png";
				$(this).fadeOut(100, function() {
					$(this).attr("src",src);
					$(this).fadeIn(100);
			    });
			});
			
			$(this).mouseout(function() {
				var src = $(this).attr("src").replace("_.png",".png");
				$(this).fadeOut(100, function() {
					$(this).attr("src",src);
					$(this).fadeIn(100);
			    });
			});
		});
	});
	
	$('.rowProduct .information').each(function() {
		$(this).mouseover(function() {
			$(this).find('.detailBtn').children().first().css("display", "block");
		});
		
		$(this).mouseout(function() {
			$(this).find('.detailBtn').children().first().css("display", "none");
		});
	})
	
});